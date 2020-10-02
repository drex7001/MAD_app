package Drex.Funcionality;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.drex.dashboard.R;

public class CategoryActivity extends AppCompatActivity {

    private LinearLayout lay_java, lay_python, lay_java_script, lay_r, lay_sql, lay_php, lay_c, lay_cpp;
    private TextView txt_java,txt_python,txt_java_script,txt_r,txt_sql,txt_php,txt_c,txt_cpp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        lay_java = findViewById(R.id.lay_java);
        lay_python = findViewById(R.id.lay_python);
        lay_java_script = findViewById(R.id.lay_java_script);
        lay_r = findViewById(R.id.lay_r);
        lay_sql = findViewById(R.id.lay_sql);
        lay_php = findViewById(R.id.lay_php);
        lay_c = findViewById(R.id.lay_c);
        lay_cpp = findViewById(R.id.lay_cpp);

        txt_java = findViewById(R.id.txt_java);
        txt_python = findViewById(R.id.txt_python);
        txt_java_script = findViewById(R.id.txt_java_script);
        txt_r = findViewById(R.id.txt_r);
        txt_sql = findViewById(R.id.txt_sql);
        txt_php = findViewById(R.id.txt_php);
        txt_c = findViewById(R.id.txt_c);
        txt_cpp = findViewById(R.id.txt_cpp);


        lay_java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, QuizActivity.class);
                intent.putExtra("lay_java",String.valueOf(txt_java));
                //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                //QuizActivity.this.finish();
            }
        });

        
    }
}