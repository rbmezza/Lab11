package com.example.rbocanegramez.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    /*
    AVOID CALLING ANY ANDROID APIS FROM HERE ex. Context.whatever.
     */
    public MyService() {
    }

    /*
    onStart command is a better place to do initialization code
     */

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        //TODO: display a notification when this starts.
        //TODO: use alarm manager for notification for the lab.
        //for now we are just going to display a toast

        Toast.makeText(this,"service starting", Toast.LENGTH_LONG).show();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
