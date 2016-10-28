package com.surf.education.surfeducation;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


//startandroid.ru/ru/uroki/vse-uroki-spiskom/
public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.main_activity);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
}