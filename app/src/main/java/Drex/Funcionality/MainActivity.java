package Drex.Funcionality;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.drex.dashboard.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import Rasitha.Functionality.ForumChatMainActivityRaz;
import Rasitha.Functionality.Model.User;
import Rasitha.Functionality.RegisterActivityRaz;
import Rasitha.Functionality.StartActivityRaz;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout lay_quiz, lay_achivement, lay_forum, lay_notification, lay_edit_profile, lay_rate_us;
    private TextView  txt_quiz,txt_achivement,txt_forum,txt_notification,txt_edit_profile,txt_rate_us;

    //stuff Rasitha did

    CircleImageView profile_image;
    TextView username;

    FirebaseUser firebaseUser;
    DatabaseReference reference;

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

        //stuff Rasitha did
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        profile_image = findViewById(R.id.profile_image);
        username = findViewById(R.id.appbar_username);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)  {
                User user = dataSnapshot.getValue(User.class);
                username.setText(user.getUsername());
                //Toast.makeText(getApplicationContext(),"Already logged in as "+user.getUsername(),Toast.LENGTH_LONG).show();

                if(user.getImageURL().equals("default")){
                    profile_image.setImageResource(R.drawable.businessman);
                }else{
                    Glide.with(MainActivity.this).load(user.getImageURL()).into(profile_image);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        lay_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                intent.putExtra("lay_quiz",String.valueOf(txt_quiz));
                //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                //QuizActivity.this.finish();
            }
        });

        lay_forum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ForumChatMainActivityRaz.class);
                intent.putExtra("lay_quiz",String.valueOf(txt_quiz));
                //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                //QuizActivity.this.finish();
            }
        });

        lay_edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Std_profile_drex.class);
                intent.putExtra("username", String.valueOf(username));
                startActivity(intent);
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(MainActivity.this, StartActivityRaz.class));
            finish();
            return true;
        }
        return false;
    }
}