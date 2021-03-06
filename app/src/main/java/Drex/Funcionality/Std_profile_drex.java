package Drex.Funcionality;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.drex.dashboard.R;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Rasitha.Functionality.RegisterActivityRaz;

public class Std_profile_drex extends AppCompatActivity {


    private EditText newf_name,newl_name,newmobile/*,newpassword*/;
    //private TextView newUsereemail,newpassword;
    private ImageView imageView;



    private Button save;
    private FirebaseAuth firebaseAuth;
    private  FirebaseDatabase firebaseDatabase;
    private List<Question> userdata;
    String id,l_name,f_name,mobile,imageURL;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_std_profile_drex);

        imageView = findViewById(R.id.back_button0);

        newf_name = findViewById(R.id.upname1);
        newmobile = findViewById(R.id.upaddress1);
        newl_name = findViewById(R.id.upemail1);
        save=findViewById(R.id.upbuttonup1);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        rootNode = FirebaseDatabase.getInstance();
        reference  = rootNode.getReference("Users/"+firebaseAuth.getUid());

        //DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("question"+"/"+name.toLowerCase()+"/"+type.toLowerCase());
        userdata = new ArrayList<>();


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                id = dataSnapshot.child("id").getValue(String.class);
                f_name = dataSnapshot.child("f_name").getValue(String.class);
                l_name = dataSnapshot.child("l_name").getValue(String.class);
                mobile = dataSnapshot.child("mobile").getValue(String.class);
                imageURL = dataSnapshot.child("imageURL").getValue(String.class);

                userprofile userprofile = new userprofile(f_name,l_name,mobile,id,imageURL);
                newf_name.setText(f_name);
                newmobile.setText(mobile);
                newl_name.setText(l_name);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Std_profile_drex.this, databaseError.getCode(), Toast.LENGTH_SHORT);
            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String aid = id;
                String fname = newf_name.getText().toString();
                String lname = newl_name.getText().toString();
                String mobile = newmobile.getText().toString();
                String aimageURL = imageURL;

                if(TextUtils.isEmpty((CharSequence) fname)||TextUtils.isEmpty((CharSequence) mobile)||TextUtils.isEmpty((CharSequence) lname)){
                    Toast.makeText(Std_profile_drex.this, "All fields are required", Toast.LENGTH_SHORT).show();
                }else if(!isStringInteger(mobile)){
                    Toast.makeText(Std_profile_drex.this, "mobile must be a number", Toast.LENGTH_SHORT).show();
                }else if(mobile.length()!= 10){
                    Toast.makeText(Std_profile_drex.this, "mobile must be 10 digits ", Toast.LENGTH_SHORT).show();
                }
                else{
                    userprofile Userprofile = new userprofile(fname,lname,mobile,aid,aimageURL);
                    reference.setValue(Userprofile);
                    finish();
                    Toast.makeText(Std_profile_drex.this,"Profile updated",Toast.LENGTH_SHORT ).show();
                }
            }
        });


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
       /* save.setOnClickListener(new View.OnClickListener() {
          @Override
           public void onClick(View view) {
              startActivity(new Intent(updateprofile.this,updateprofile.class));
        }
        });

        */
    }
    private boolean isStringInteger(String number ){
        try{
            Integer.parseInt(String.valueOf(number));
        }catch(Exception e ){
            return false;
        }
        return true;
    }
}
