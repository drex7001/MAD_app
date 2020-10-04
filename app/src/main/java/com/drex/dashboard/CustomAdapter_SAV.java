package com.drex.dashboard;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter_SAV extends RecyclerView.Adapter<ViewHolder_SAV> {

    ListActivity_SAV listActivitySAV;
    List<Model_SAV> modelList;
    Context context;

    public CustomAdapter_SAV(ListActivity_SAV listActivitySAV, List<Model_SAV> modelList) {
        this.listActivitySAV = listActivitySAV;
        this.modelList = modelList;

    }

    @NonNull
    @Override
    public ViewHolder_SAV onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate layout

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.model_layout, parent,false);

        ViewHolder_SAV viewHolder = new ViewHolder_SAV(itemView);
        //handle item clicks here
        viewHolder.setOnClickListener(new ViewHolder_SAV.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String title = modelList.get(position).getTitle();
                String notice = modelList.get(position).getNotice();
                Toast.makeText(listActivitySAV, title+"\n"+notice, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, final int position) {
                //Creating AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(listActivitySAV);
                //options to display in dialog
                String[] options = {"Update","Delete"};
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(i == 0){
                            //update is clicked
                            //get data
                            String id = modelList.get(position).getId();
                            String title = modelList.get(position).getTitle();
                            String notice = modelList.get(position).getNotice();

                            //intent to start activity
                            Intent intent = new Intent(listActivitySAV, MainActivity_SAV.class);
                            //put data in intent
                            intent.putExtra("pId",id);
                            intent.putExtra("pTitle",title);
                            intent.putExtra("pNotice",notice);

                            //start Activity
                            listActivitySAV.startActivity(intent);
                        }
                        if(i==1){
                            //delete is clicked
                            listActivitySAV.deleteData(position);
                        }
                    }
                }).create().show();

            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder_SAV holder, int position) {
        //bind views / set data
        holder.mTitle.setText(modelList.get(position).getTitle());
        holder.mNotice.setText(modelList.get(position).getNotice());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}
