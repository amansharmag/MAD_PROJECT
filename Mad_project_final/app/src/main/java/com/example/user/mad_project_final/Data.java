package com.example.user.mad_project_final;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.AdapterView;
import java.util.Locale;
import java.util.Date;
import java.text.SimpleDateFormat;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.util.Log;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;



public class Data extends AppCompatActivity {
    Spinner spinner1;
    DatabasHelper myDb;

    EditText e1;
    Spinner spinner2;
    String i1;
    String i2;
    String remark[];
    String date;
    ImageView b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        spinner1=(Spinner)findViewById(R.id.d3);
        e1=(EditText)findViewById(R.id.d2);
        spinner2=(Spinner)findViewById(R.id.d4);
         date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
         b1=(ImageView)findViewById(R.id.t5);
        myDb = new DatabasHelper(this);
        String category[]=getResources().getStringArray(R.array.category);
        ArrayAdapter<String> a=new ArrayAdapter<String>(Data.this,android.R.layout.simple_spinner_item,category);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(a);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                i1 = (String) parent.getItemAtPosition(position);
                if(i1.equals("FOOD")){
                    remark=getResources().getStringArray(R.array.FOOD);
                }
                if(i1.equals("CLOTH SHOPPING")){
                    remark=getResources().getStringArray(R.array.CLOTH);
                }
                if(i1.equals("ELECTRONIC DEVICES")){
                    remark=getResources().getStringArray(R.array.ELECTRONIC);
                }
                if(i1.equals("MONTHLY EXPENDITURE")){
                    remark=getResources().getStringArray(R.array.MONTHLY);
                }
                if(i1.equals("OTHERS")){
                    remark=getResources().getStringArray(R.array.OTHERS);
                }
                ArrayAdapter<String> a2=new ArrayAdapter<String>(Data.this,android.R.layout.simple_spinner_item,remark);
                a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner2.setAdapter(a2);
                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        i2 = (String) parent.getItemAtPosition(position);
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        AddData();
    }
    public  void AddData() {
        b1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(e1.getText().toString().equals("")){
                            Toast.makeText(Data.this,"ENTER THE AMOUNT",Toast.LENGTH_LONG).show();

                        }
                        else {
                            boolean isInserted = myDb.insertData(date,
                                    i1,
                                    i2
                                    ,e1.getText().toString());
                            if (isInserted == true) {
                                Toast.makeText(Data.this, "Data Inserted", Toast.LENGTH_LONG).show();
                            } else
                                Toast.makeText(Data.this, "Data not Inserted", Toast.LENGTH_LONG).show();

                        }

                    }
                }
        );
    }
}
