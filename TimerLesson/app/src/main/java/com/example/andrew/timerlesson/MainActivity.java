package com.example.andrew.timerlesson;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* HANDLER/RUNNABLE TIMER METHOD */
//        final Handler handler = new Handler();
//
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                Toast.makeText(MainActivity.this, "Hey it's us, a second passed by...", Toast.LENGTH_SHORT).show();
//                handler.postDelayed(this, 1000);
//            }
//        };
//
//        handler.post(runnable);


        //CountDownTimer method
        new CountDownTimer(12000, 3000){

            @Override
            public void onTick(long l) {
                Toast.makeText(MainActivity.this, String.valueOf(l/1000) + " seconds left.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinish() {
                Log.i("I", "Timer Finished.");
            }
        }.start();
    }
}
