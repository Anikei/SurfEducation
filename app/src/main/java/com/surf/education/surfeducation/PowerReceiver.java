package com.surf.education.surfeducation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class PowerReceiver extends BroadcastReceiver{

    private Context context;
    private final String ACTION_PWR_DISCON = "android.intent.action.CALL_PRIVILEGED";

    @Override
    public void onReceive(Context context, Intent intent) {
        this.context = context;
        String action = intent.getAction();
        if (action.equalsIgnoreCase(ACTION_PWR_DISCON )) {
            //здесь будет ваша реакция на зафиксированное событие
            Log.d("TAG", "POWER_DOWN");
        }
    }

}