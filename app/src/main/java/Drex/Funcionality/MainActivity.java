package Drex.Funcionality;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.drex.dashboard.R;

public class MainActivity extends AppCompatActivity {

    private LinearLayout lay_quiz, lay_achivement, lay_forum, lay_notification, lay_edit_profile, lay_rate_us;
    private TextView txt_quiz,txt_achivement,txt_forum,txt_notification,txt_edit_profile,txt_rate_us;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lay_quiz = findViewById(R.id.lay_quiz);
        lay_achivement = findViewById(R.id.lay_achivement);
        lay_forum = findViewById(R.id.lay_forum);
        lay_notification = findViewById(R.id.lay_notification);
        lay_edit_profile = findViewById(R.id.lay_edit_profile);
        lay_rate_us = findViewById(R.id.lay_rate_us);

        txt_quiz = findViewById(R.id.txt_quiz);
        txt_achivement = findViewById(R.id.txt_achivement);
        txt_forum = findViewById(R.id.txt_forum);
        txt_notification = findViewById(R.id.txt_notification);
        txt_edit_profile = findViewById(R.id.txt_edit_profile);
        txt_rate_us = findViewById(R.id.txt_rate_us);

        lay_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Quiz_type.class);
                intent.putExtra("lay_quiz",String.valueOf(txt_quiz));
                //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                //Quiz_type.this.finish();
            }
        });
    }
}