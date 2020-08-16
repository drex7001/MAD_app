package com.drex.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class leaderboard_grid_sav extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard_grid_sav);

        TextView textViewledb = findViewById(R.id.txtvwlb);
        textViewledb.setText(R.string.leaderboardtxt);

        TextView textView011 = findViewById(R.id.txtvw11);
        textView011.setText(R.string.r1c1);

        TextView textView012 = findViewById(R.id.txtvw12);
        textView012.setText(R.string.r1c2);

        TextView textView013 = findViewById(R.id.txtvw13);
        textView013.setText(R.string.r1c3);

        TextView textView014 = findViewById(R.id.txtvw14);
        textView014.setText(R.string.r2c1);




    }
}