package Drex.Funcionality;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.drex.dashboard.R;

public class CategoryActivity extends AppCompatActivity {

    private LinearLayout lay_java, lay_python, lay_java_script, lay_r, lay_sql, lay_php, lay_c, lay_cpp;
    private TextView txt_java,txt_python,txt_java_script,txt_r,txt_sql,txt_php,txt_c,txt_cpp;
    public String java,python,java_script,r,c,cpp,php,sql;
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

        java = txt_java.getText().toString();
        python = txt_python.getText().toString();
        java_script = txt_java_script.getText().toString();
        r = txt_r.getText().toString();
        sql = txt_sql.getText().toString();
        php = txt_php.getText().toString();
        c = txt_c.getText().toString();
        cpp = txt_cpp.getText().toString();


        lay_java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, SetsActivity.class);
                intent.putExtra("name",java);
                intent.putExtra("image", R.drawable.java);
                startActivity(intent);
            }
        });

        lay_python.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, SetsActivity.class);
                intent.putExtra("name",python);
                intent.putExtra("image", R.drawable.python);
                startActivity(intent);
            }
        });

        lay_java_script.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, SetsActivity.class);
                intent.putExtra("name",java_script);
                intent.putExtra("image", R.drawable.java_script);
                startActivity(intent);
            }
        });

        lay_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, SetsActivity.class);
                intent.putExtra("name",r);
                intent.putExtra("image", R.drawable.ruby);
                startActivity(intent);
            }
        });

        lay_sql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, SetsActivity.class);
                intent.putExtra("name",sql);
                intent.putExtra("image", R.drawable.sql);
                startActivity(intent);
            }
        });

        lay_php.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, SetsActivity.class);
                intent.putExtra("name",php);
                intent.putExtra("image", R.drawable.php);
                startActivity(intent);
            }
        });

        lay_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, SetsActivity.class);
                intent.putExtra("name",c);
                intent.putExtra("image", R.drawable.c);
                startActivity(intent);
            }
        });

        lay_cpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, SetsActivity.class);
                intent.putExtra("name",cpp);
                intent.putExtra("image", R.drawable.cpp);
                startActivity(intent);
            }
        });

        
    }
}