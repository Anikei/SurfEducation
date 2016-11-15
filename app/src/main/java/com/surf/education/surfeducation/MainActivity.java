package com.surf.education.surfeducation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

//dpi =c/inch, где width^2 + height^2 = c^2
//размеры всегда указывать в dp, не в px
//шрифты - в sp
//startandroid.ru/ru/uroki/vse-uroki-spiskom/
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText input = (EditText) findViewById(R.id.input);

    public String firstName = "John";
    public String lastName = "Doe";

    /**
     * 1) в реальности практически не прописывается в android:onclick
     * 2) анонимный класс в setOnClickListener()
     * 3) реализация интерфейса View.onClickListener в классе, содержащем ссылку на экземпляр
     * button, затем передать в метод конкретного экземпляра Button setOnClickListener() текущий контекст
     */
    public void myClickHandler(View target) {
        teleport();// Do stuff
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        //также можно использовать, но редко onRestoreInstanceState(savedInstanceState);

        Button teleportButton = (Button) findViewById(R.id.main_goto_button);
        //teleportButton.setOnClickListener(this);
        Button second = (Button) findViewById(R.id.second);
        second.setOnClickListener(this);
        Button third = (Button) findViewById(R.id.third);
        third.setOnClickListener(this);

        //teleportButton.setOnClickListener();

        ImageView view = (ImageView) findViewById(R.id.image);

        RadioGroup switcher = (RadioGroup) findViewById(R.id.group);
        /*
        switcher.setOnCheckedChangeListener(new RadioGroup.on {
            @Override
            public void onCheckedChanged(RadioGroup switcher, int checkedId {
                //TODO:
            }

            )
        });
        */


        Log.d("TAG", "onCreate");
        if (savedInstanceState != null) {
            String label = savedInstanceState.getString("label");
            Log.d("TAG", label);
        }
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

    //поправить
    /*
    public void teleport(int id) {//тут был new
        SecondActivity.start(MainActivity.this, "Имя", "Фамилия");
    }
    */

    //TODO: дописать код неявного интента
    public void teleportToSpace(int id) {//тут был new
        String textMessage = "xxx";
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, textMessage);
        sendIntent.setType("text/plain");

        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(sendIntent);
        }
    }


    public void teleport() {
        Intent intent = new Intent(this, TargetActivity.class);

        /**
         * text
         * textEmailAddress
         * textUri
         * ...
         */

        intent.putExtra("firstName", input.getText().toString());
        intent.putExtra("lastName", "");
        startActivity(intent);
    }


    @Override
    public void onClick(View view) {
        view.setOnClickListener(this);
    }

/*
check_box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked {
		//TODO:
	}
});
*/

//checkBox.toogle() - инверсия значения

//Чем больше уровней вложенности в контейнерах, тем тормознее (не больше 10 уровней вложенности)

    /*
    * от легкого к тяжелому
    * FrameLayout - все друг на друга с перекрытиями, поддерживает gravity для компонентов содержимого
    * LinearLayout - Weight доступен только в этом контейнере
    * RelativeLayout - весьма ресурсоемкий, тормозит при большом содержимом
    * android:layout_below="@+id/btn1" //если ссылать на то, чего нет выше по списку - может ругнуться
    * android:layout_above="@+id/btn2" //нельзя делать циклические отношения
    * android:layout_toRightOf="@+id/btn1"
    * android:layout_toLeftOf="@+id/btn2"
    * anroid:layout_alignTop - позиционирование границы эл-та по границе другого эл-та

позиционирование относительно контейнера
android:layout_centerInParent="true"

позиционирование относительно границ контейнера
android:layout_alignParentLeft
    */
}