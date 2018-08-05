package com.example.andrew.simpleloginscreenchallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        EditText username = (EditText) findViewById(R.id.nameEditText);
        EditText password = (EditText) findViewById(R.id.passwordEditText);

        Log.i("User", username.getText().toString());
        Log.i("Pass", password.getText().toString());

        Toast.makeText(this, "Gotta Catch 'Em All! " + username.getText().toString(), Toast.LENGTH_SHORT).show();

    }
}
