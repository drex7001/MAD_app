package com.drex.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Quiz_End_Interface_Raz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz__end__interface__raz);


        TextView textViewHeader = findViewById(R.id.QuizEndHeaderTV);
        textViewHeader.setText(R.string.end_quiz);

        //TextView textViewHeader1 = findViewById(R.id.editTextTextPersonName);
        //textViewHeader1.setText(R.string.end_quiz);
    }


}