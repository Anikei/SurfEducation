package com.surf.education.surfeducation;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class PushActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.push_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                waitMe();
            }
        });
    }


    public void waitMe() {

        Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;

        final Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                //textView.setText("Text");
            }
        };


        final Runnable runnable = new Runnable() {

            //@Override
            public void run(){

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                /*
                long endTime = System.currentTimeMillis() + 10 * 1000;
                while (System.currentTimeMillis() < endTime) {
                    synchronized (this) {
                        try {wait(endTime - System.currentTimeMillis());} catch (Exception e) {}
                    }
                }*/
                //PushActivity.this.findViewById(R.id.)

                handler.sendEmptyMessage(0);

            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

//

        toast.show();
    }

}
