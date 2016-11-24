package com.example.rbocanegramez.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

    int notificationCount;

    /*
    AVOID CALLING ANY ANDROID APIS FROM HERE ex. Context.whatever.
     */
    public MyService() {
        notificationCount = 1;
    }

    /*
    onStart command is a better place to do initialization code
     */

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        //TODO: display a notification when this starts.
        //TODO: use alarm manager for notification for the lab.
        //for now we are just going to display a toast

        //Toast.makeText(this,"service starting", Toast.LENGTH_LONG).show();

        //Adding a notification:
        //Show notification when intent starts
        Notification.Builder mBuilder = new Notification.Builder(this).setSmallIcon(null).
                setContentTitle("Service was started").setContentText("This is the body text");

        //create a implicit Intent that will be broadcast when the user clicks pm the Notification
        Intent notificationIntent = new Intent("com.example.rbocanegramez.NOTIFICATION_CLICKED");

        //create pending PendingIntent to package the above intent
        PendingIntent notificationPendingIntent = PendingIntent.getBroadcast(this,123,notificationIntent,0);
        //associate the two using our Notification.Builder instance:
        mBuilder.setContentIntent(notificationPendingIntent);

        //get an instance of notification manager:
        //for location it is the same but with location service.
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        //Notify the user (fire off the notification)
        //for notifications to not overlap the notification id needs to be different.
        //notificationManager.notify(1,mBuilder.build());
        notificationManager.notify(notificationCount++,mBuilder.build());

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"service is stopping", Toast.LENGTH_SHORT).show();
        /*
        WARNING: if another android component (ex. a system service) has a reference or is sending Intents to this service
        it won't actually be stopped.
        MAKE SURE you deregister with System Serices (here) ex. AlarmManager, LocationManager
        (if oyu have broadcast receiver deregister them too.)
         */
    }
}
