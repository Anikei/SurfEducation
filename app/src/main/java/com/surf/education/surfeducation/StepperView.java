package com.surf.education.surfeducation;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.util.Log;


public class StepperView extends LinearLayout {
    ImageButton plusButton;
    TextView valueField;
    ImageButton minusButton;
    private int baseColor;
    int value = 25;
    final int MAX_STEPPER_VALUE = 50;
    final int MIN_STEPPER_VALUE = 0;
    public static final String MYPREFS = "mySharedPreferences";
    SharedPreferences mySharedPreferences;

    protected void savePref(int value) {
        Context context = this.getContext();
        try {
            SharedPreferences pref = context.getSharedPreferences(MYPREFS, Activity.MODE_PRIVATE);
            if (pref == null) {

            }
            SharedPreferences.Editor edit = mySharedPreferences.edit();
            edit.putInt("value", value);
            edit.commit();
        } catch (NullPointerException e) {
            Log.d("TAG", "Error of ");
            e.printStackTrace();
        }
        Log.d("TAG", this.getResources().getQuantityString(R.plurals.android_plural, value, value));
    }

    public StepperView(Context context) {
        this(context, null);
    }

    public StepperView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(getContext(), R.layout.stepper, this);
        init();
    }

    private void init() {
        this.plusButton = (ImageButton) findViewById(R.id.plus_button);
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incValue();
            }
        });

        this.valueField = (TextView) findViewById(R.id.counter);
        valueField.setText(Integer.toString(value));

        this.minusButton = (ImageButton) findViewById(R.id.minus_button);
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decValue();
            }
        });
    }

    private void incValue() {
        if (value < MAX_STEPPER_VALUE) {
            value++;
            valueField.setText(Integer.toString(value));
        }
        Log.d("TAG", Integer.toString(value));
        savePref(value);
    }

    private void decValue() {
        if (value > MIN_STEPPER_VALUE) {
            value--;
            valueField.setText(Integer.toString(value));
        }
        Log.d("TAG", Integer.toString(value));
        savePref(value);
    }

    private void applyAttrs(Context context, AttributeSet attrs) {
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.StepperView, 0, 0);
        baseColor = a.getColor(R.styleable.StepperView_baseColor, R.color.colorAccent);//red - дефолтное значение
        a.recycle();
    }

    public void setValue(int value) {
        this.value = value;
    }

}
/*
есть еще PreferencesActivity
можно использовать SharedPrefernces для каждой активити
 */