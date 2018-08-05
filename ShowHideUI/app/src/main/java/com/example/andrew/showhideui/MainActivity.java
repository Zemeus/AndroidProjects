package com.example.andrew.showhideui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void show(View view){
        TextView text = findViewById(R.id.textView);
        text.setVisibility(View.VISIBLE);
    }

    public void hide(View view){
        TextView text = findViewById(R.id.textView);
        text.setVisibility(View.INVISIBLE);

    }
}
