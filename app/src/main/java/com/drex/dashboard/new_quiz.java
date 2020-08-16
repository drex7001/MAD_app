package com.drex.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class new_quiz extends AppCompatActivity {

    String quiztitle,question,answer1,answer2,answer3,answer4;

    EditText titleInput;
    EditText questionInput;
    EditText answer1Input;
    EditText answer2Input;
    EditText answer3Input;
    EditText answer4Input;

    Button addquestionButton;
    Button publishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_quiz);


        titleInput = (EditText) findViewById(R.id.quiztitle);
        questionInput = (EditText) findViewById(R.id.question);
        answer1Input = (EditText) findViewById(R.id.answer1);
        answer2Input = (EditText) findViewById(R.id.answer2);
        answer3Input = (EditText) findViewById(R.id.answer3);
        answer4Input = (EditText) findViewById(R.id.answer4);


        publishButton = (Button) findViewById(R.id.publishbutton);
        publishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quiztitle = titleInput.getText().toString();
            }

        });

        addquestionButton = (Button) findViewById(R.id.addquestionButton);
        addquestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //add a new question
            }

        });


    }




}