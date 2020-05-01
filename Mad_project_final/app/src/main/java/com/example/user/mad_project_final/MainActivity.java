package com.example.user.mad_project_final;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ImageView b1,b2;
    TextView x1, x3;
    DatabasHelper db;
    int ta,ta1;
    int n3,a2,a3;
    int a1;
    String n5,n6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        db = new DatabasHelper(this);
        x1 = (TextView) findViewById(R.id.x1);
        b1 = (ImageView) findViewById(R.id.t5);
        b2 = (ImageView) findViewById(R.id.t7);
        x3 = (TextView) findViewById(R.id.x3);

        refresh();
       // getamount();
        //getmoney();











        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // finish();
                Intent i = new Intent(MainActivity.this, Data.class);
                startActivity(i);

            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    public void refresh(){
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int ta=db.gettotalamount();
                String n5=String.valueOf(ta);
                x1.setText(n5);

                ArrayList array_list = db.getAllCotacts();
                int z=array_list.size();
                if(z==0){
                    x3.setText("0");

                }

                else{
                    int ta1=db.gettotalamount();
                    String y = (String) array_list.get(z-1);
                    int n3= Integer.parseInt(y);
                    int a3=n3-ta1;
                    String n6=String.valueOf(a3);
                    x3.setText(n6);
                }


            }
        });
    }







   // public int getamount() {
//
  //              int ta=db.gettotalamount();
    //           String n5=String.valueOf(ta);
      //         x1.setText(n5);
//
              //  return ta;
  //  }

   // public int getmoney(){

     //   ArrayList array_list = db.getAllCotacts();
       // int z=array_list.size();
        //if(z==0){
          // return 0;
        //}
        //else{
          //  int ta1=db.gettotalamount();
            //String y = (String) array_list.get(z-1);
            //int n3= Integer.parseInt(y);
            //int a3=n3-ta1;
            //String n6=String.valueOf(a3);
            //x3.setText(n6);
            //return n3;
        //}
    //}

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.filter) {
            // Handle the camera action

            Intent i = new Intent(MainActivity.this, List.class);
            startActivity(i);

        } else if (id == R.id.guide) {

            Intent i = new Intent(MainActivity.this, Guide.class);
            startActivity(i);

        } else if (id == R.id.setting) {
           // finish();
            Intent i = new Intent(MainActivity.this, Setting.class);
            startActivity(i);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
