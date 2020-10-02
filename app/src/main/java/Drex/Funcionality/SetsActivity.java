package Drex.Funcionality;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.drex.dashboard.R;

public class SetsActivity extends AppCompatActivity {

    private LinearLayout lay_beginner, lay_intermediate, lay_expert;
    private TextView txt_java,txt_python,txt_java_script,txt_r,txt_sql,txt_php,txt_c,txt_cpp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sets);

        lay_beginner = findViewById(R.id.lay_beginner);
        lay_intermediate = findViewById(R.id.lay_intermediate);
        lay_expert = findViewById(R.id.lay_expert);

        lay_beginner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetsActivity.this, QuizActivity.class);
                intent.putExtra("lay_java",String.valueOf(txt_java));
                //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                //QuizActivity.this.finish();
            }
        });
    }
}