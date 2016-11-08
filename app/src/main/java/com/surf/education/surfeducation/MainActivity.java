package com.surf.education.surfeducation;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


//dpi =c/inch, где width^2 + height^2 = c^2
//размеры всегда указывать в dp, не в px
//шрифты - в sp
//startandroid.ru/ru/uroki/vse-uroki-spiskom/
public class MainActivity extends AppCompatActivity {
    public String firstName = "John";
    public String lastName = "Doe";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        //также можно использовать, но редко onRestoreInstanceState(savedInstanceState);
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
    public void teleport(int id) {//тут был new
        SecondActivity.start(MainActivity.this, "Имя", "Фамилия");
    }

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

    /*
    public void teleport() {
        Intent intent = new Intent(this, TargetActivity.class);
        intent.putExtra("firstName", firstName);
        intent.putExtra("lastName", lastName);
        startActivity(intent);
    }
    */

}