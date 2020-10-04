package Rasitha.Functionality;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.drex.dashboard.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.HashMap;

public class RegisterActivityRaz extends AppCompatActivity {

    MaterialEditText username,email,password,f_name,l_name,mobile;
    Button btn_register;

    FirebaseAuth auth;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_raz);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Register");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        username =findViewById(R.id.username);
        email = findViewById(R.id.emailraz);
        password = findViewById(R.id.password);
        btn_register =findViewById(R.id.btn_register);
        f_name =findViewById(R.id.f_name);
        l_name =findViewById(R.id.l_name);
        mobile =findViewById(R.id.mobile);

        auth = FirebaseAuth.getInstance();

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_username =username.getText().toString();
                String txt_email = email.getText().toString();
                String txt_password =password.getText().toString();
                String txt_f_name =f_name.getText().toString();
                String txt_l_name =l_name.getText().toString();
                String txt_mobile =mobile.getText().toString();

                if(TextUtils.isEmpty(txt_username)||TextUtils.isEmpty(txt_email)||TextUtils.isEmpty(txt_password)){
                    Toast.makeText(RegisterActivityRaz.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else if(txt_password.length() < 6){
                    Toast.makeText(RegisterActivityRaz.this, "password must be at least 6 characters long", Toast.LENGTH_SHORT).show();
                } else{
                    register(txt_username,txt_email,txt_password,txt_f_name,txt_l_name,txt_mobile);
                }

            }
        });
    }

    private void register(final String username, String email, String password, final String f_name, final String l_name, final String mobile){

        auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            FirebaseUser firebaseUser = auth.getCurrentUser();
                            assert firebaseUser != null;
                            String userid =firebaseUser.getUid();

                            reference= FirebaseDatabase.getInstance().getReference("Users").child(userid);

                            HashMap<String,String> hashMap =new HashMap<>();
                            hashMap.put("id", userid);
                            hashMap.put("username", username);
                            hashMap.put("imageURL", "default");
                            hashMap.put("f_name", f_name);
                            hashMap.put("l_name", l_name);
                            hashMap.put("mobile", mobile);

                            reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Intent intent = new Intent(RegisterActivityRaz.this, StartActivityRaz.class);
                                        intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | intent. FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });

                        }else {
                            Toast.makeText(RegisterActivityRaz.this, "You can't register with this email or password" , Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }


}