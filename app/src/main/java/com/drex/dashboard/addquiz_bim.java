package com.drex.dashboard;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class addquiz_bim extends AppCompatActivity {

    EditText q1title,q1answer1,q1answer2,q1answer3,q1answer4,q1answer5,
             q2title,q2answer1,q2answer2,q2answer3,q2answer4,q2answer5,
             q3title,q3answer1,q3answer2,q3answer3,q3answer4,q3answer5,
             q4title,q4answer1,q4answer2,q4answer3,q4answer4,q4answer5,
             q5title,q5answer1,q5answer2,q5answer3,q5answer4,q5answer5;

    Button insert;
    FirebaseDatabase database;
    DatabaseReference ref;
    Quiz quiz;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newquiz_bim2);

        q1title = (EditText) findViewById(R.id.q1title);
        q1answer1 = (EditText) findViewById(R.id.q1answer1);
        q1answer2 = (EditText) findViewById(R.id.q1answer2);
        q1answer3 = (EditText) findViewById(R.id.q1answer3);
        q1answer4 = (EditText) findViewById(R.id.q1answer4);
        q1answer5 = (EditText) findViewById(R.id.q1answer4);

        q2title = (EditText) findViewById(R.id.q2title);
        q2answer1 = (EditText) findViewById(R.id.q2answer1);
        q2answer2 = (EditText) findViewById(R.id.q2answer2);
        q2answer3 = (EditText) findViewById(R.id.q2answer3);
        q2answer4 = (EditText) findViewById(R.id.q2answer4);
        q2answer5 = (EditText) findViewById(R.id.q2answer4);

        q3title = (EditText) findViewById(R.id.q3title);
        q3answer1 = (EditText) findViewById(R.id.q3answer1);
        q3answer2 = (EditText) findViewById(R.id.q3answer2);
        q3answer3 = (EditText) findViewById(R.id.q3answer3);
        q3answer4 = (EditText) findViewById(R.id.q3answer4);
        q3answer5 = (EditText) findViewById(R.id.q3answer4);


        q4title = (EditText) findViewById(R.id.q4title);
        q4answer1 = (EditText) findViewById(R.id.q4answer1);
        q4answer2 = (EditText) findViewById(R.id.q4answer2);
        q4answer3 = (EditText) findViewById(R.id.q4answer3);
        q4answer4 = (EditText) findViewById(R.id.q4answer4);
        q4answer5 = (EditText) findViewById(R.id.q4answer4);

        q1title = (EditText) findViewById(R.id.q1title);
        q1answer1 = (EditText) findViewById(R.id.q1answer1);
        q1answer2 = (EditText) findViewById(R.id.q1answer2);
        q1answer3 = (EditText) findViewById(R.id.q1answer3);
        q1answer4 = (EditText) findViewById(R.id.q1answer4);
        q1answer5 = (EditText) findViewById(R.id.q1answer4);

        q5title = (EditText) findViewById(R.id.q5title);
        q5answer1 = (EditText) findViewById(R.id.q5answer1);
        q5answer2 = (EditText) findViewById(R.id.q5answer2);
        q5answer3 = (EditText) findViewById(R.id.q5answer3);
        q5answer4 = (EditText) findViewById(R.id.q5answer4);
        q5answer5 = (EditText) findViewById(R.id.q5answer4);
        insert = (Button) findViewById(R.id.btninsert);

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("quiz");
        quiz = new Quiz();

    }

    private void getValues (){

        quiz.setQ1title(q1title.getText().toString());
        quiz.setQ1answer1(q1answer1.getText().toString());
        quiz.setQ1answer1(q1answer1.getText().toString());
        quiz.setQ1answer1(q1answer1.getText().toString());
        quiz.setQ1answer1(q1answer1.getText().toString());
        quiz.setQ1answer1(q1answer1.getText().toString());

        quiz.setQ2title(q2title.getText().toString());
        quiz.setQ2answer1(q2answer1.getText().toString());
        quiz.setQ2answer1(q2answer1.getText().toString());
        quiz.setQ2answer1(q2answer1.getText().toString());
        quiz.setQ2answer1(q2answer1.getText().toString());
        quiz.setQ2answer1(q2answer1.getText().toString());

        quiz.setQ3title(q3title.getText().toString());
        quiz.setQ3answer1(q3answer1.getText().toString());
        quiz.setQ3answer1(q3answer1.getText().toString());
        quiz.setQ3answer1(q3answer1.getText().toString());
        quiz.setQ3answer1(q3answer1.getText().toString());
        quiz.setQ3answer1(q3answer1.getText().toString());

        quiz.setQ4title(q4title.getText().toString());
        quiz.setQ4answer1(q4answer1.getText().toString());
        quiz.setQ4answer1(q4answer1.getText().toString());
        quiz.setQ4answer1(q4answer1.getText().toString());
        quiz.setQ4answer1(q4answer1.getText().toString());
        quiz.setQ4answer1(q4answer1.getText().toString());

        quiz.setQ5title(q5title.getText().toString());
        quiz.setQ5answer1(q5answer1.getText().toString());
        quiz.setQ5answer1(q5answer1.getText().toString());
        quiz.setQ5answer1(q5answer1.getText().toString());
        quiz.setQ5answer1(q5answer1.getText().toString());
        quiz.setQ5answer1(q5answer1.getText().toString());



    }

    public void btnInsert (View view) {
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ref.child("Quiz01").setValue(quiz);
                Toast.makeText(addquiz_bim.this,"Quiz Published", Toast.LENGTH_LONG).show();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
