package com.example.user.mad_project_final;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.*;
import  android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import android.widget.Toast;
import java.util.ArrayList;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class ProgrammingAdapter extends RecyclerView.Adapter<ProgrammingAdapter.ProgrammingViewHolder> {
    DatabasHelper myDb;

    java.util.List<DataModel> dataModelArrayList;


    public ProgrammingAdapter(java.util.List<DataModel> dataModelArrayList) {
        this.dataModelArrayList = dataModelArrayList;
    }


    @Override
    public ProgrammingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card, parent, false);

        return new ProgrammingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProgrammingViewHolder holder, int position) {

        DataModel dataModel = dataModelArrayList.get(position);
        holder.t1.setText(dataModel.getDate());
        holder.t2.setText(dataModel.getRemark());
        holder.t3.setText(dataModel.getSpend());


    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }

    public class ProgrammingViewHolder extends RecyclerView.ViewHolder {
        TextView t1, t2, t3, t4;
       // ImageView i1;

        public ProgrammingViewHolder(View ItemView) {
            super(ItemView);
            t1 = (TextView) itemView.findViewById(R.id.v);
            t2 = (TextView) itemView.findViewById(R.id.v2);
            t3 = (TextView) itemView.findViewById(R.id.v3);
        }
    }
}
