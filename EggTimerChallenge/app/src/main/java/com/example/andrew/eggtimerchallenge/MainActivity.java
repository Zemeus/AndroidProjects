package com.example.andrew.eggtimerchallenge;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SeekBar timeSetSeekBar;
    private long timerValue= 0;
    private boolean isRunning = false;
    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeSetSeekBar = findViewById(R.id.seekBar);
        timeSetSeekBar.setOnSeekBarChangeListener(listener);
        timeSetSeekBar.setProgress(30 * 1000);
    }

    SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            updateTime(i);


        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };



    public void start(View view){
        isRunning = !isRunning;
        if(isRunning && timeSetSeekBar.getProgress() != 0){

            startTimer();
            updateButton();

        } else {
            stopTimer();

        }


    }

    public void startTimer(){
        Toast.makeText(this, "Timer Started!", Toast.LENGTH_SHORT).show();
        if(isRunning){
            timeSetSeekBar.setEnabled(false);
            timer = new CountDownTimer(timerValue, 1000){

                @Override
                public void onTick(long timeLeft) {
                    updateTime(timeLeft);
                    timeSetSeekBar.setProgress( (int) timeLeft);


                }

                @Override
                public void onFinish() {
                    reset();
                    playSound();
                }
            }.start();
        }


    }

    private void playSound(){
        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.beep);
        mediaPlayer.start();
    }

    public void stopTimer(){
        if(timer != null)
            timer.cancel();
        if(!isRunning) {
            updateButton();
            timeSetSeekBar.setEnabled(true);
        }
    }

    private void reset(){
        timer = null;
        timerValue = 0;
        timeSetSeekBar.setEnabled(true);
        timeSetSeekBar.setProgress(0);
        isRunning = false;
        updateButton();
        updateTime(timerValue);


    }


    public void updateTime(long value){
        timerValue = value;
        TextView textView = findViewById(R.id.textView);
        textView.setText(getTimeString(timerValue));
    }

    private String getTimeString(long value){
        String timeString = "";

        value /= 1000; //set in seconds.
        if(value % 60 < 10) {
            timeString = String.valueOf(value / 60) + ":0" + String.valueOf(value % 60);
        } else {
            timeString = String.valueOf(value / 60) + ":" + String.valueOf(value % 60);
        }
        return timeString;
    }

    private void updateButton(){
        Button button = findViewById(R.id.button);
        if(isRunning){
            button.setText("STOP!");
        }
        else {
            button.setText(R.string.go);
        }
    }


}
