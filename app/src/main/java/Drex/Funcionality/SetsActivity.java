package Drex.Funcionality;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.drex.dashboard.R;

public class SetsActivity extends AppCompatActivity {

    private LinearLayout lay_beginner, lay_intermediate, lay_expert;
    private TextView txt_beginner,txt_intermediate,txt_expert,txt_type;
    public String st,beginner,intermediate,expert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sets);

        lay_beginner = findViewById(R.id.lay_beginner);
        lay_intermediate = findViewById(R.id.lay_intermediate);
        lay_expert = findViewById(R.id.lay_expert);

        txt_beginner = findViewById(R.id.txt_beginner);
        txt_intermediate = findViewById(R.id.txt_intermediate);
        txt_expert = findViewById(R.id.txt_expert);

        beginner = txt_beginner.getText().toString();
        intermediate = txt_intermediate.getText().toString();
        expert = txt_expert.getText().toString();

        ImageView imageView = (ImageView) findViewById(R.id.image);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            int res_img = bundle.getInt("image");
            imageView.setImageResource(res_img);
        }

        TextView name = (TextView) findViewById(R.id.txt_type);

        st = getIntent().getExtras().getString("name");
        name.setText(st);


        lay_beginner.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetsActivity.this, QuizActivity.class);
                Bundle extras = new Bundle();
                extras.putString("name",st);
                extras.putString("type",beginner);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

        lay_intermediate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetsActivity.this, QuizActivity.class);
                Bundle extras = new Bundle();
                extras.putString("name",st);
                extras.putString("type",intermediate);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

        lay_expert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetsActivity.this, QuizActivity.class);
                Bundle extras = new Bundle();
                extras.putString("name",st);
                extras.putString("type",expert);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }
}