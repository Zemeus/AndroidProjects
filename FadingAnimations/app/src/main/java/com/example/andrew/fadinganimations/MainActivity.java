package com.example.andrew.fadinganimations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean isBart = true;

    public void fade(View view){

        ImageView bart = findViewById(R.id.imageView);
        ImageView homer = findViewById(R.id.imageView2);

        if(isBart) {
            bart.animate().alpha(0).setDuration(2000);
            homer.animate().alpha(1).setDuration(2000);
        } else {
            bart.animate().alpha(1).setDuration(2000);
            homer.animate().alpha(0).setDuration(2000);
        }

        //bart.animate().rotation(180).setDuration(2000);

        isBart = !isBart;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
