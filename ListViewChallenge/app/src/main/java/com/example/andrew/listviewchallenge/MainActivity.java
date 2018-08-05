package com.example.andrew.listviewchallenge;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = findViewById(R.id.myListView);
        final ArrayList<String> friends = new ArrayList<>();
        friends.add("Nobody");
        friends.add("Nobody, Nobody");

        list.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, friends));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               //Toast.makeText(MainActivity.this, "Tapped: " + friends.get(i), Toast.LENGTH_SHORT);


                //Custom Toast: Create new layout.xml file for toast contents, make toast and inflate the layout, set values for duration, gravity, view etc.
                Toast toast = new Toast(getApplicationContext());
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toastLayout));
                TextView text = (TextView) layout.findViewById(R.id.textView);
                text.setText(friends.get(i));

                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0,0);
                toast.setView(layout);
                toast.show();
            }
        });
    }
}
