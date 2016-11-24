package com.example.rbocanegramez.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /*
    Create broadcast receiver, its for receiving intents while the activity is running
    it's instantiated in the onResume() method
    and its removed in onPause() method
     */

    myBroadcastReceiver  MyBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = (Button) findViewById(R.id.button_start);
        Button stopButton = (Button) findViewById(R.id.button_stop);

        startButton.setOnClickListener(new View.OnClickListener(){
         public void onClick(View v){
                startMyService();
            }
        });
        stopButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                stopMyService();
            }
        });
        MyBroadcastReceiver = new myBroadcastReceiver();

    }

    @Override
    protected void onResume(){
        super.onResume();
        //register the my BroadcastReceiver
        // to receive broadcast intents we need to do a couple of tins.
        //Create an IntentFilter

        IntentFilter filter = new IntentFilter("com.example.rbocanegramez.NOTIFICATION_CLICKED");

        //register the receive:
        registerReceiver(MyBroadcastReceiver, filter);
    }
    @Override
    protected void onPause(){
        super.onPause();
        unregisterReceiver(MyBroadcastReceiver);
    }

    public class myBroadcastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            handleIntentBroadcast(intent);
        }
    }

    private void handleIntentBroadcast(Intent intent) {
        System.out.println("Activity received an intent: " + intent.toString());

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(intent.toString());
        //TODO: process the extras in the intent.
    }

    void  startMyService(){
        //explicit intent to start MyService
        Intent intent = new Intent(this, MyService.class);
        //Start service by calling context.startService()
        startService(intent);
    }

    void stopMyService(){
        //explicit intent to start MyService
        Intent intent = new Intent(this, MyService.class);
        //Start service by calling context.startService()
        stopService(intent);

    }

}
