package com.example.andrew.homeschoolhelper;

import android.animation.TimeInterpolator;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChildSelect extends AppCompatActivity {
    final float FREQ = 3f;
    final float DECAY = 2f;
    boolean hasChild = false;
    TimeInterpolator decayingSineWave = new TimeInterpolator() {
        @Override
        public float getInterpolation(float input) {
            double raw = Math.sin(FREQ * input * 2 * Math.PI);
            return (float)(raw * Math.exp(-input * DECAY));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_select);

        if(!hasChild) {
            new CountDownTimer(5000, 1000) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    animate();
                }
            }.start();
        }
    }


    public void animate(){
        if(!hasChild){

            ImageButton addImageButton = findViewById(R.id.addImageButton);
            addImageButton.animate().translationXBy(40f).setInterpolator(decayingSineWave).setDuration(1000);

        }


    }

    public void submit(View view){

        Intent intent = new Intent(ChildSelect.this, SubjectSelect.class);
        startActivity(intent);
    }
}
