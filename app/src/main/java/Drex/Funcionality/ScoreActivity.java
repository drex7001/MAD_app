package Drex.Funcionality;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.drex.dashboard.R;

public class ScoreActivity extends AppCompatActivity {

    private TextView score;
    private Button done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_drex);

        score = findViewById(R.id.sa_score);
        done = findViewById(R.id.sa_done);

        String score_str = getIntent().getStringExtra("SCORE");
        score.setText(score_str);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScoreActivity.this,MainActivity.class);
                ScoreActivity.this.startActivity(intent);
                ScoreActivity.this.finish();
            }
        });
    }
}