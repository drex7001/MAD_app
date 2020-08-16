package com.drex.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Contact_Lecturer_Interface_Raz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact__lecturer__interface__raz);

        TextView Contact_Lecturer_Header = findViewById(R.id.Contact_Lecturer_HeaderTV);
        Contact_Lecturer_Header.setText(R.string.Contact_Lecturer_Header);

        TextView Contact_Lecturer_msg1 = findViewById(R.id.Contact_Lecturer_msg1TV);
        Contact_Lecturer_msg1.setText(R.string.Contact_Lecturer_msg1);

        TextView Contact_Lecturer_message_prompt = findViewById(R.id.message_promptTV);
        Contact_Lecturer_message_prompt.setText(R.string.message_prompt);

        TextView Contact_Lecturer_btn1 = findViewById(R.id.Contact_Lecturer_btn1TV);
        Contact_Lecturer_btn1.setText(R.string.Contact_Lecturer_btn1);

        TextView  Contact_Lecturer_btn2 = findViewById(R.id.Contact_Lecturer_btn2TV);
        Contact_Lecturer_btn2.setText(R.string.Contact_Lecturer_btn2);

    }


}