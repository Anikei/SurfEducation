package com.surf.education.surfeducation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

}
/*
android.app.fragment (родительский класс)
android.app.fragmentmanager (взаимодействие с активити)
android.app.fragmenttransaction
теоретически можно использовать для хранения данных
 */
