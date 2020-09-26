package com.drex.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.rengwuxian.materialedittext.MaterialEditText;


public class new_quiz_bim extends AppCompatActivity {



    MaterialEditText qtitle, answer1,answer2,answer3,answer4,answer5;
    Button btn_addquestion;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_raz);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Login");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        auth = FirebaseAuth.getInstance();

        qtitle = findViewById(R.id.qtitle);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);
        answer5 = findViewById(R.id.answer5);
        btn_addquestion = findViewById(R.id.btn_addquestion);

        btn_addquestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String txt_qtitle = qtitle.getText().toString();
                String txt_answer1 = answer1.getText().toString();
                String txt_answer2 = answer2.getText().toString();
                String txt_answer3 = answer3.getText().toString();
                String txt_answer4 = answer4.getText().toString();
                String txt_answer5 = answer5.getText().toString();

                if(TextUtils.isEmpty(txt_qtitle)||TextUtils.isEmpty(txt_answer1)||TextUtils.isEmpty(txt_answer2)||TextUtils.isEmpty(txt_answer3)||TextUtils.isEmpty(txt_answer4)||TextUtils.isEmpty(txt_answer5)){
                    Toast.makeText(new_quiz_bim.this, "Please complete the question", Toast.LENGTH_SHORT).show();
                }else {




                    };
                }

        });

    }


}