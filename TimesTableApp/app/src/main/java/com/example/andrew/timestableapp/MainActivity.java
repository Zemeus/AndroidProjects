package com.example.andrew.timestableapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final String TEXT_VIEW_BASE_MESSAGE = "Times Table: ";
    int baseNumber = 1;
    SeekBar numberSelectSeekBar;

    SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            baseNumber = seekBar.getProgress();
            updateNumberText();
            updateListView();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberSelectSeekBar = findViewById(R.id.numberSelectSeekBar);
        numberSelectSeekBar.setOnSeekBarChangeListener(listener);
        numberSelectSeekBar.setProgress(1);
    }


    public void updateNumberText(){
        TextView currentNumberTextView = findViewById(R.id.currentNumberTextView);
        currentNumberTextView.setText(TEXT_VIEW_BASE_MESSAGE + baseNumber);

    }

    public void updateListView(){
        ListView table = findViewById(R.id.timesTableListView);
        ArrayList<Integer> numbers = getTimesTableValues();
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, R.layout.custom_simple_list_view, numbers);
        table.setAdapter(arrayAdapter);
        table.setDividerHeight(0);


    }

    public ArrayList<Integer> getTimesTableValues(){
        ArrayList<Integer> multiplicationValues = new ArrayList<Integer>();

        for(int i = 0; i < 11; i++){
            multiplicationValues.add(baseNumber * i);
        }

        return multiplicationValues;
    }


}
