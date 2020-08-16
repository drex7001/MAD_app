package com.drex.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Messages_Reply_Interface_Raz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages__reply__interface__raz);

        TextView Reply_Interface_Header1 = findViewById(R.id.Reply_Interface_Header1TV);
        Reply_Interface_Header1.setText(R.string.Reply_Interface_Header1);

        TextView Reply_Interface_Header2 = findViewById(R.id.Reply_Interface_Header2TV);
        Reply_Interface_Header2.setText(R.string.Reply_Interface_Header2);

        TextView Recived_MSG = findViewById(R.id.Recived_MSG_TV);
        Recived_MSG.setText(R.string.Recived_MSG);

        TextView Sent_MSG = findViewById(R.id.Sent_MSG_TV);
        Sent_MSG.setText(R.string.Sent_MSG);

        TextView Reply_MSG_Enter_Box = findViewById(R.id.Reply_MSG_Enter_BoxTV);
        Reply_MSG_Enter_Box.setText(R.string.Reply_MSG_Enter_Box);


    }
}