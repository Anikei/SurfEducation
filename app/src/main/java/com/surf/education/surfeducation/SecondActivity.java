package com.surf.education.surfeducation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * интенты вызывают активити, вызывают сервисы, используются для рассылки бордкастов
 * интенты делятся на явные(переход между экранами, четкий переход в конкретное место) и неявные
 */
public class SecondActivity extends AppCompatActivity {
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";

    //вызов интента
    public static void start(Context context, String firstname, String lastname) {
        Intent intent = new Intent(context, SecondActivity.class);

        intent.putExtra(FIRST_NAME, firstname);
        intent.putExtra(LAST_NAME, lastname);
        Log.d("TAG", FIRST_NAME + " " + LAST_NAME);

        context.startActivity(intent);
        //TODO: выяснить, почему не работает onCreate
    }

    /*
    @Override
    public void onCreate(Bundle savedInstanceState, Bundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        Intent intent = getIntent();
        String firstName = intent.getStringExtra(FIRST_NAME);
        String lastName = intent.getStringExtra(LAST_NAME);

        firstName = "1";
        lastName = "2";

        setContentView(R.layout.second_activity);
        //StepperView stepperView = (StepperView) findViewById(R.id.stepper);
    }
    */

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //также можно использовать, но редко onRestoreInstanceState(savedInstanceState);
        Log.d("TAG", "onCreate");
        if (savedInstanceState != null) {
            String label = savedInstanceState.getString("label");
            Log.d("TAG", label);
        }
        setContentView(R.layout.second_activity);
        TextView label = (TextView) findViewById(R.id.text);
        label.setText("LABEL");
        StepperView stepperView = (StepperView) findViewById(R.id.stepper);
    }



    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TAG", "onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "onResume");
    }

    //Все данные сохраняются в этот момент (т.к. переходи на другую активити)
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG", "onPause");
        //отписка от листенеров, стартовавших в onResume()
    }

    //при переходе на другую активити для текущей отработает только после отработки
    //на новой активити onCreate(), onStart(), onResume()
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG", "onStop");
        //убираем то, что инициализировано в онСтарт
    }

    //гарантированно вызывается методом finish()
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "onDestroy");
    }

    /**
     * активити удаляется и пересоздается при повороте устройства
     * сюда вcё надо сохранить
     */
    //если виджет имеет id, он сохраняет состояния автоматически
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("label", "Restored!!!");
        //всё это вернется в onCreate()
        //не использовать для сохранения данных, отличных от
    }

}


/*

customView - для собственных переиспользуемых элементов
1) если элемент используется более одного раза
2) если надо скрыть логику

flaticon.com - хранилище иконок

1) Создаем класс, расширяющий одну из ViewGroup

public class $MyCustomViewName$View extends LinearLayout {

}

2) Далее создаем Layout, описывающий CustomView в XML

3) Конструктор программный

public MyComponentView(Context context) {
	this(context, null);
}

4) Конструктор из XML

public MyComponentView(Context context, AttributeSet attrs) {
	super(context, attrs);
	inflate(getContext(), R.layout.my_view_layout.this);
	init();
}

5) inflate layout в custom view

6) инициализация customview в init() методе

7) создаем открытые методы для работы с customView

8) используем




Обработка событий из Custom View
1) вставляем в сам файл с view
public interface OnStepperViewListener {
	void onClick();
}

2) вставляем сеттер
public void setClickListener {
	this.clickListener = listener;
}

3) вызываем

	if (clickListener != null) { //на случай, если ни разу не вызывался
		clickListener.onClick();
	}


*/