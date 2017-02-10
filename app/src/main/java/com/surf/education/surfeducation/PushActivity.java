package com.surf.education.surfeducation;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

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

        Log.d("TAG", "START");

        final Handler handler = new Handler() {
            public void handleMessage(Message msg) {
                Bundle bundle = msg.getData();
                String date = bundle.getString("Key");
                //textView.setText(date);
            }
        };

        Runnable runnable = new Runnable() {
            public void run() {

                long endTime = System.currentTimeMillis() + 20 * 1000;
                //код с предыдущего слайда
              /*  try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                //код с предыдущего слайда
                while (System.currentTimeMillis() < endTime) {
                    synchronized (this) {
                        try {
                            Log.d("TAG", "START LOAD");
                            wait(endTime - System.currentTimeMillis());
                            Log.d("TAG", "FIN LOAD");
                            Bundle bundle = new Bundle();
                            bundle.putString("Key", "Text");
                            Message msg = handler.obtainMessage();
                            msg.setData(bundle);
                            handler.sendMessage(msg);
                        } catch (Exception e) {
                        }
                    }
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        Log.d("TAG", "FIN");
    }

}
