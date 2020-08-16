package com.drex.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class leaderboard_sav extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard_sav);

        TextView textView001 = findViewById(R.id.txtvw1);
        textView001.setText(R.string.stdname);

        TextView textView002 = findViewById(R.id.txtvw2);
        textView002.setText(R.string.stdid);

        TextView textView003 = findViewById(R.id.txtvw3);
        textView003.setText(R.string.ps);

        TextView textView004 = findViewById(R.id.txtvw4);
        textView004.setText(R.string.psmark);

        TextView textView005 = findViewById(R.id.txtvw5);
        textView005.setText(R.string.dsa);

        TextView textView006 = findViewById(R.id.txtvw6);
        textView006.setText(R.string.dsamark);

        TextView textView007 = findViewById(R.id.txtvw7);
        textView007.setText(R.string.mad);

        TextView textView008 = findViewById(R.id.txtvw8);
        textView008.setText(R.string.madmark);

        TextView textView009 = findViewById(R.id.txtvw9);
        textView009.setText(R.string.average);

        TextView textView010 = findViewById(R.id.txtvw10);
        textView010.setText(R.string.averagevalue);



    }


}