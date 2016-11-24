package com.example.rbocanegramez.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = (Button) findViewById(R.id.button_start);
        Button stopButtton = (Button) findViewById(R.id.button_stop);

        startButton.setOnClickListener(new View.OnClickListener(){
         public void onClick(View v){
                startService();
            }
        });

    }
    void  startService(){
        //explicit intent to start MyService
        Intent intent = new Intent(this, MyService.class);
        //Start service by calling context.startService()
        startService(intent);
    }

}
