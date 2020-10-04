package com.drex.dashboard;


import android.widget.TextView;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ViewHolder_SAV extends RecyclerView.ViewHolder {

    TextView mTitle,mNotice;
    View mView;

    public ViewHolder_SAV(@NonNull View itemView) {
        super(itemView);
        mView = itemView;

        //itemClick
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onItemClick(view,getAdapterPosition());
            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mClickListener.onItemLongClick(view, getAdapterPosition());
                return false;
            }
        });

        //initialize views with model_layout.xml

        mTitle = itemView.findViewById(R.id.rTitle1);
        mNotice = itemView.findViewById(R.id.rNotice1);


    }

    //interface for click listener

    private ViewHolder_SAV.ClickListener mClickListener;
    public interface ClickListener{
        void onItemClick(View view,int position);
        void onItemLongClick(View view, int position);

    }
    public void setOnClickListener(ViewHolder_SAV.ClickListener clickListener){
        mClickListener = clickListener;
    }

}
