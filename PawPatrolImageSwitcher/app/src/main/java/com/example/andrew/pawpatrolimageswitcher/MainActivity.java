package com.example.andrew.pawpatrolimageswitcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random = new Random();

    public void switchImage(View view){

        int index = getRandomNumber();
        int image = getImageFromIndex(index);
        String name = getNameFromIndex(index);

        TextView nameTextView = (TextView) findViewById(R.id.nameTextView);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        nameTextView.setText(name);
        imageView.setImageResource(image);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private int getRandomNumber(){
        return (random.nextInt(11));
    }

    private String getNameFromIndex(int index) {

        switch (index) {

            case 0:
                return "Chase";

            case 1:
                return "Chickaletta";

            case 2:
                return "Everest";

            case 3:
                return "Jake";

            case 4:
                return "Marshall";

            case 5:
                return "Rocky";

            case 6:
                return "Rubble";

            case 7:
                return "Ryder";

            case 8:
                return "Skye";

            case 9:
                return "Wally";

            case 10:
                return "Zuma";

            default:
               return "Chase";

        }
    }

    private int getImageFromIndex(int index){

        switch (index){

            case 0:
                return R.drawable.chase;

            case 1:
                return R.drawable.chickaletta;

            case 2:
                return R.drawable.everest;

            case 3:
                return R.drawable.jake;

            case 4:
                return R.drawable.marshall;

            case 5:
                return R.drawable.rocky;

            case 6:
                return R.drawable.rubble;

            case 7:
                return R.drawable.ryder;

            case 8:
                return R.drawable.skye;

            case 9:
                return R.drawable.wally;

            case 10:
                return R.drawable.zuma;

            default:
                return R.drawable.chase;

        }
    }
}
