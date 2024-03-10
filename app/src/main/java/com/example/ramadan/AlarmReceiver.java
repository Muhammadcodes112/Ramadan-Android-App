package com.example.ramadan;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // Show the notification here
        LayoutInflater inflater = LayoutInflater.from(context);
        View toastview = inflater.inflate(R.layout.customtoast, null);
        Toast toast = new Toast(context);
        toast.setView(toastview);
        toast.show();
    }
}
