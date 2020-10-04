package com.drex.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MainActivity_SAV extends AppCompatActivity {

    //view
    EditText mTitle,mNotice;
    Button mSaveBtn,mListBtn;
    //progress dialog
    ProgressDialog pd;
    //firestore instance
    FirebaseFirestore db;

    String pId,pTitle,pNotice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sav);

        //action bar and its title
        ActionBar actionBar = getSupportActionBar();

        //initialize views ids
        mTitle = findViewById(R.id.titleEt);
        mNotice = findViewById(R.id.noticeEt);
        mSaveBtn = findViewById(R.id.saveBtn);
        mListBtn = findViewById(R.id.listBtn);

        final Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            //Update data
            actionBar.setTitle("Update Data");
            mSaveBtn.setText("Update");
            pId = bundle.getString("pId");
            pTitle = bundle.getString("pTitle");
            pNotice = bundle.getString("pNotice");

            //set data
            mTitle.setText(pTitle);
            mNotice.setText(pNotice);

        }
        else{
            //New data
            actionBar.setTitle("Add data");
            mSaveBtn.setText("Save");
        }


        pd = new ProgressDialog(this);
        //fire store
        db = FirebaseFirestore.getInstance();

        mSaveBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {

                Bundle bundle1 = getIntent().getExtras();
                if(bundle != null){
                    //updating
                    //input data
                    String id = pId;
                    String title = mTitle.getText().toString().trim();
                    String notice = mNotice.getText().toString().trim();
                    //function call for update data
                    updateData(id, title, notice);
                }
                else{
                    //adding new
                    //input data
                    String title = mTitle.getText().toString().trim();
                    String notice = mNotice.getText().toString().trim();
                    //function call to upload data
                    uploadData(title,notice);
                }

            }
        });

        //click button to start activity
        mListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity_SAV.this, ListActivity_SAV.class));
                finish();
            }
        });
    }

    private void updateData(String id, String title, String notice) {
        //title of progress bar
        pd.setTitle("Updating Notice");
        //show progress bar when user click save button
        pd.show();

        db.collection("Documents").document(id)
                .update("title",title,"notice",notice)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        //called when a successful updating process
                        pd.dismiss();
                        Toast.makeText(MainActivity_SAV.this, "Updated", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //called when updating failed
                        pd.dismiss();
                        //get and show error message
                        Toast.makeText(MainActivity_SAV.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void uploadData(String title, String notice) {
        //title of progress bar
        pd.setTitle("Notice Uploading");
        //show progress bar when user click save button
        pd.show();
        String id = UUID.randomUUID().toString();
        Map<String, Object> doc = new HashMap<>();
        doc.put("id",id);
        doc.put("title",title);
        doc.put("notice",notice);

        db.collection("Documents").document(id).set(doc)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        pd.dismiss();
                        Toast.makeText(MainActivity_SAV.this, "Uploaded", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        pd.dismiss();
                        Toast.makeText(MainActivity_SAV.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }


}