package com.example.andrew.homeschoolhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SubjectSelect extends AppCompatActivity {

    ArrayList<String> subjects;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_select);

        subjects = new ArrayList<>();
        subjects.add("Math");
        subjects.add("Reading");
        subjects.add("Science");

        arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, subjects);
        ListView subjectList = findViewById(R.id.subjectListView);
        subjectList.setAdapter(arrayAdapter);


    }
}
