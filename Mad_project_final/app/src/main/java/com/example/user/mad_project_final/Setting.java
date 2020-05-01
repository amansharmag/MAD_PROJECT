package com.example.user.mad_project_final;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Arrays;

import android.util.Log;

public class Setting extends AppCompatActivity {
EditText e1;
ImageView i1,i3;
ImageView i2;
    DatabasHelper myDb;
    int n,z,s;
    String y,n5,n6;
    int n2;
    TextView t1;
    int n4;
 int n3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        e1=(EditText)findViewById(R.id.s1);

        i1=(ImageView)findViewById(R.id.s2);
        i2=(ImageView)findViewById(R.id.s4);
        i3=(ImageView)findViewById(R.id.s7);
        t1=(TextView)findViewById(R.id.s6);
        myDb = new DatabasHelper(this);
        ArrayList array_list = myDb.getAllCotacts();
        int z=array_list.size();
        if(z==0){
            t1.setText("0");
        }else {
            String y = (String) array_list.get(z-1);
            t1.setText(y);
        }

        //String y = (String) array_list.get(z-1);
        AddData();
        getamount();
        delete();
      //int x=getamount();

    }
    public void AddData() {
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString().equals("")){
                    Toast.makeText(Setting.this,"ENTER THE AMOUNT",Toast.LENGTH_LONG).show();

                }
                else{
                    int n = Integer.parseInt(e1.getText().toString());
                    boolean insertData=myDb.insertData2(n);
                    if(insertData == true){
                        n6=String.valueOf(n);
                        t1.setText(n6);
                        Toast.makeText(Setting.this,"Money Inserted",Toast.LENGTH_LONG).show();
                    }

                    else
                        Toast.makeText(Setting.this,"Data not Inserted",Toast.LENGTH_LONG).show();

                }


            }
        });
    }

    public void getamount(){
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList array_list = myDb.getAllCotacts();
                int z = array_list.size();
                if (z == 0) {
                    t1.setText("0");
                } else {
                    String y = (String) array_list.get(z - 1);
                    int n3 = Integer.parseInt(y);
                    if(e1.getText().toString().equals("")){
                        Toast.makeText(Setting.this,"ENTER THE AMOUNT",Toast.LENGTH_LONG).show();

                    }else{

                        int n2 = Integer.parseInt(e1.getText().toString());
                        int n4 = n2 + n3;
                        boolean insertData = myDb.insertData2(n4);
                        if (insertData == true)
                            Toast.makeText(Setting.this, "Money Added", Toast.LENGTH_LONG).show();
                        Log.i("hhh", String.valueOf(n3));
                        String n5=String.valueOf(n4);
                        t1.setText(n5);
                        //s = n4;

                    }


                }

            }
        });
    }


    public void delete(){
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDb.reload();
            }
        });

    }
}



