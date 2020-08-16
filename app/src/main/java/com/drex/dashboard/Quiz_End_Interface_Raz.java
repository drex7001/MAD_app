package com.drex.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Quiz_End_Interface_Raz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz__end__interface__raz);


        //text views
        TextView textViewHeader = findViewById(R.id.QuizEndHeaderTV);
        textViewHeader.setText(R.string.end_quiz);

        TextView youGot = findViewById(R.id.YouGotTV);
        youGot.setText(R.string.you_got);

        TextView correct_Percentage = findViewById(R.id.CorrectPercentageTV);
        correct_Percentage.setText(R.string.percentage_correct);

        TextView correct = findViewById(R.id.correctTV);
        correct.setText(R.string.correct_ans);

        TextView home_button = findViewById(R.id.HomeBut);
        home_button.setText(R.string.home_button);

        TextView contact_lect_button = findViewById(R.id.ContactLecturerBut);
        contact_lect_button.setText(R.string.contact_lecturer);


    }


}