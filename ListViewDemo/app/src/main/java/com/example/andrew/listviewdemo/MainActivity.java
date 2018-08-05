package com.example.andrew.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.myListView);

        ArrayList<String> family = new ArrayList<>();
        family.add("Andrew");
        family.add("Amanda");
        family.add("Ava");
        family.add("Josh");
        family.add("Lexi");
        family.add("Gunner");

        //set adapter with an android.r.layout.(ListLayout)
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, family);
        listView.setAdapter(arrayAdapter);

        //Handle click on a ListView item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Tapped: " + adapterView.getAdapter().getItem(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
