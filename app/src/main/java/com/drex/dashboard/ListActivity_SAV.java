package com.drex.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ListActivity_SAV extends AppCompatActivity {

    List<Model_SAV> modelList = new ArrayList<>();
    RecyclerView mRecyclerView;

    //layout manager for recycler view
    RecyclerView.LayoutManager layoutManager;

    FloatingActionButton mAddbtn;

    //firestore instance
    FirebaseFirestore db;

    CustomAdapter_SAV adapter;

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sav);

        //action bar and its title
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("List Data");

        //initialize firestore
        db = FirebaseFirestore.getInstance();

        //initialize views
        mRecyclerView = findViewById(R.id.recycler);
        mAddbtn = findViewById(R.id.addBtn);

        //setting recycler vie properties
        mRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        //initialize progress dialog
        pd= new ProgressDialog(this);

        //show data in recyclerView
        showData();

        mAddbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListActivity_SAV.this, MainActivity_SAV.class));
                finish();
            }
        });

    }

    private void showData() {
        //set title of progress dialog
        pd.setTitle("Loading data");
        //show progress dialog
        pd.show();

        db.collection("Documents")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        modelList.clear();
                        //called when data is retrieved
                        pd.dismiss();
                        //show data
                        for(DocumentSnapshot doc: task.getResult()){

                            Model_SAV model = new Model_SAV(doc.getString("id"),
                                    doc.getString("title"),
                                    doc.getString("notice"));
                            modelList.add(model);

                        }
                        //adapter
                        adapter = new CustomAdapter_SAV(ListActivity_SAV.this, modelList);
                        //set Adapeter to recyclerView
                        mRecyclerView.setAdapter(adapter);


                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //called when data is not retrieved
                        pd.dismiss();
                        Toast.makeText(ListActivity_SAV.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void deleteData(int index){

        //set title of progress dialog
        pd.setTitle("Deleting data");
        //show progress dialog
        pd.show();

        db.collection("Documents").document(modelList.get(index).getId())
                .delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        //called when successfully deleted
                        Toast.makeText(ListActivity_SAV.this, "Deleted", Toast.LENGTH_SHORT).show();
                        //update data
                        showData();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //called when there is any kind on error
                        pd.dismiss();
                        //error message
                        Toast.makeText(ListActivity_SAV.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }

}