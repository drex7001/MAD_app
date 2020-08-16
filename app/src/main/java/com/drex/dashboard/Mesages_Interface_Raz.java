package com.drex.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Mesages_Interface_Raz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesages__interface__raz);

        TextView Mesages_Interface_Header = findViewById(R.id.Mesages_Interface_HeaderTV);
        Mesages_Interface_Header.setText(R.string.Mesages_Interface_Header);

        TextView Sender_name1 = findViewById(R.id.Sender_Name_1TV);
        Sender_name1.setText(R.string.sender_name);
        TextView Sender_msg1 = findViewById(R.id.MSG_Preview_1TV);
        Sender_msg1.setText(R.string.sender_msg);

        TextView Sender_name2 = findViewById(R.id.Sender_Name_2TV);
        Sender_name2.setText(R.string.sender_name);
        TextView Sender_msg2 = findViewById(R.id.MSG_Preview_2TV);
        Sender_msg2.setText(R.string.sender_msg);

        TextView Sender_name3 = findViewById(R.id.Sender_Name_3TV);
        Sender_name3.setText(R.string.sender_name);
        TextView Sender_msg3 = findViewById(R.id.MSG_Preview_3TV);
        Sender_msg3.setText(R.string.sender_msg);

        TextView Sender_name4 = findViewById(R.id.Sender_Name_4TV);
        Sender_name4.setText(R.string.sender_name);
        TextView Sender_msg4 = findViewById(R.id.MSG_Preview_4TV);
        Sender_msg4.setText(R.string.sender_msg);

        TextView Sender_name5 = findViewById(R.id.Sender_Name_5TV);
        Sender_name5.setText(R.string.sender_name);
        TextView Sender_msg5 = findViewById(R.id.MSG_Preview_5TV);
        Sender_msg5.setText(R.string.sender_msg);



    }
}