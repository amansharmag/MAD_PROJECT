package com.example.user.mad_project_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.*;

public class record extends AppCompatActivity {

    DatabasHelper database;
    RecyclerView r;
    ProgrammingAdapter recycler;
    java.util.List<DataModel> datamodel;
    int i;
    String n6;
    TextView xx1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        xx1=(TextView)findViewById(R.id.xx);

        final String TempHolder = getIntent().getStringExtra("item");


        RecyclerView r=(RecyclerView) findViewById(R.id.re);

        database = new DatabasHelper(this);


        if(TempHolder.equals("CLOTH SHOPPING")){
            datamodel=  database.getcloth();
            i=database.getclothamount();
            String n6=String.valueOf(i);
            xx1.setText(n6);
            recycler = new ProgrammingAdapter( datamodel);
            RecyclerView.LayoutManager reLayoutManager =new LinearLayoutManager(getApplicationContext());
            r.setLayoutManager(reLayoutManager);
            r.setAdapter(recycler);
        }
        if(TempHolder.equals("FOOD")){
            datamodel=  database.getfood();
            i=database.getfoodamount();
            String n6=String.valueOf(i);
            xx1.setText(n6);
            recycler = new ProgrammingAdapter( datamodel);
            RecyclerView.LayoutManager reLayoutManager =new LinearLayoutManager(getApplicationContext());
            r.setLayoutManager(reLayoutManager);
            r.setAdapter(recycler);
        }


        if(TempHolder.equals("ELECTRONIC DEVICES")){
            datamodel=  database.getelectronicdevice();
            i=database.geteamount();
            String n6=String.valueOf(i);
            xx1.setText(n6);
            recycler = new ProgrammingAdapter( datamodel);
            RecyclerView.LayoutManager reLayoutManager =new LinearLayoutManager(getApplicationContext());
            r.setLayoutManager(reLayoutManager);
            r.setAdapter(recycler);
        }



        if(TempHolder.equals("MONTHLY EXPENDITURE")){
            datamodel=  database.getME();
            i=database.getmeamount();
            String n6=String.valueOf(i);
            xx1.setText(n6);
            recycler = new ProgrammingAdapter( datamodel);
            RecyclerView.LayoutManager reLayoutManager =new LinearLayoutManager(getApplicationContext());
            r.setLayoutManager(reLayoutManager);
            r.setAdapter(recycler);
        }

        if(TempHolder.equals("OTHERS")){
            datamodel=  database.getother();
            i=database.getotheramount();
            String n6=String.valueOf(i);
            xx1.setText(n6);
            recycler = new ProgrammingAdapter( datamodel);
            RecyclerView.LayoutManager reLayoutManager =new LinearLayoutManager(getApplicationContext());
            r.setLayoutManager(reLayoutManager);
            r.setAdapter(recycler);
        }


    }
}
