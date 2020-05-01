package com.example.user.mad_project_final;

/**
 * Created by user on 19-04-2019.
 *
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import android.util.Log;

import java.util.*;

/**
 * Created by ProgrammingKnowledge on 4/3/2015.
 */

public class DatabasHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "User.db";
    public static final String TABLE_NAME = "user_table";
    public static final String TABLE_NAME2 = "TOTAL_AMOUNT";
    public static final String COL_1 = "DATE";
    public static final String COL_2 = "CATEGORY";
    public static final String COL_3 = "REMARK";
    public static final String COL_4 = "AMOUNT";
    public static final String COL_5 = "INITIAL_AMOUNT";
    public static final String COL_6 = "rowid";
    public static final String TABLE_1 = ("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,DATE TEXT,CATEGORY TEXT,REMARK TEXT, AMOUNT TEXT)");
    public static final String TABLE_2 = ("create table " + TABLE_NAME2 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, INITIAL_AMOUNT INTEGER)");

    public DatabasHelper(Context context) {
        super(context, DATABASE_NAME, null, 3);
        SQLiteDatabase db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_1);
        db.execSQL(TABLE_2);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate(db);
    }

    public boolean insertData(String Date, String Category, String Remark, String amount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, Date);
        contentValues.put(COL_2, Category);
        contentValues.put(COL_3, Remark);
        contentValues.put(COL_4, amount);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean insertData2(int amount2) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_5, amount2);
        long result = db.insert(TABLE_NAME2, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }

    public int get() {
        String[] columns = new String[]{COL_5};
        SQLiteDatabase db1 = this.getWritableDatabase();
        Cursor c = db1.rawQuery("SELECT * FROM TOTAL_AMOUNT WHERE ID=(SELECT MAX(ID) FROM TOTAL_AMOUNT);", new String[]{});
        //int a2 = c.getColumnIndex(COL_5);
        if (c == null) {
            return 5;
        } else {

            c.moveToFirst();
            while (c.moveToLast()) {
                c.moveToNext();
            }
            int result = c.getInt(0);
            return result;

        }
    }


    public void reload() {
       // String[] columns = new String[]{COL_5};
        SQLiteDatabase db1 = this.getWritableDatabase();
         db1.execSQL("DELETE FROM user_table;", new String[]{});
        //int a2 = c.getColumnIndex(COL_5);

    }

    //int a2 = c.getColumnIndex(COL_5);
    //c.moveToLast();
    //int result=c.getInt(a2);
    //int c1=a2+2;

    //return a2;
    public ArrayList<String> getAllCotacts() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from TOTAL_AMOUNT", null);
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            array_list.add(res.getString(res.getColumnIndex(COL_5)));
            res.moveToNext();
        }
        return array_list;
    }

    public int gettotalamount() {
        int sum = 0;
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from user_table", null);
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            array_list.add(res.getString(res.getColumnIndex(COL_4)));
            res.moveToNext();
        }


        for (int i = 0; i < array_list.size(); i++) {
            if (array_list.get(i).equals("")) {
                sum = sum + 0;
            } else {
                int n3 = Integer.parseInt(array_list.get(i));
                sum = sum + n3;

            }

        }
        return sum;

    }


    public java.util.List<DataModel> getcloth() {
        // DataModel dataModel = new DataModel();
        java.util.List<DataModel> data = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user_table WHERE CATEGORY='CLOTH SHOPPING';", null);
        StringBuffer stringBuffer = new StringBuffer();
        DataModel dataModel = null;
        while (cursor.moveToNext()) {
            dataModel = new DataModel();
            String DATE = cursor.getString(cursor.getColumnIndexOrThrow("DATE"));
            String REMARK = cursor.getString(cursor.getColumnIndexOrThrow("REMARK"));
            String SPEND = cursor.getString(cursor.getColumnIndexOrThrow("AMOUNT"));
            dataModel.setDate(DATE);
            dataModel.setRemark(REMARK);
            dataModel.setSpend(SPEND);
            stringBuffer.append(dataModel);
            // stringBuffer.append(dataModel);
            data.add(dataModel);
        }

        for (DataModel mo : data) {

            Log.i("Hellomo", "" + mo.getDate());
        }
        return data;
    }



    public int getclothamount() {
        int sum = 0;
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT AMOUNT FROM user_table WHERE CATEGORY='CLOTH SHOPPING';", null);
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            array_list.add(res.getString(res.getColumnIndex(COL_4)));
            res.moveToNext();
        }


        for (int i = 0; i < array_list.size(); i++) {
            if (array_list.get(i).equals("")) {
                sum = sum + 0;
            } else {
                int n3 = Integer.parseInt(array_list.get(i));
                sum = sum + n3;

            }

        }
        return sum;

    }

    public java.util.List<DataModel> getfood() {
        // DataModel dataModel = new DataModel();
        java.util.List<DataModel> data = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user_table WHERE CATEGORY='FOOD';", null);
        StringBuffer stringBuffer = new StringBuffer();
        DataModel dataModel = null;
        while (cursor.moveToNext()) {
            dataModel = new DataModel();
            String DATE = cursor.getString(cursor.getColumnIndexOrThrow("DATE"));
            String REMARK = cursor.getString(cursor.getColumnIndexOrThrow("REMARK"));
            String SPEND = cursor.getString(cursor.getColumnIndexOrThrow("AMOUNT"));
            dataModel.setDate(DATE);
            dataModel.setRemark(REMARK);
            dataModel.setSpend(SPEND);
            stringBuffer.append(dataModel);
            // stringBuffer.append(dataModel);
            data.add(dataModel);
        }

        for (DataModel mo : data) {

            Log.i("Hellomo", "" + mo.getDate());
        }
        return data;
    }



    public int getfoodamount() {
        int sum = 0;
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT AMOUNT FROM user_table WHERE CATEGORY='FOOD';", null);
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            array_list.add(res.getString(res.getColumnIndex(COL_4)));
            res.moveToNext();
        }


        for (int i = 0; i < array_list.size(); i++) {
            if (array_list.get(i).equals("")) {
                sum = sum + 0;
            } else {
                int n3 = Integer.parseInt(array_list.get(i));
                sum = sum + n3;

            }

        }
        return sum;

    }




    public java.util.List<DataModel> getelectronicdevice() {
        // DataModel dataModel = new DataModel();
        java.util.List<DataModel> data = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user_table WHERE CATEGORY='ELECTRONIC DEVICES';", null);
        StringBuffer stringBuffer = new StringBuffer();
        DataModel dataModel = null;
        while (cursor.moveToNext()) {
            dataModel = new DataModel();
            String DATE = cursor.getString(cursor.getColumnIndexOrThrow("DATE"));
            String REMARK = cursor.getString(cursor.getColumnIndexOrThrow("REMARK"));
            String SPEND = cursor.getString(cursor.getColumnIndexOrThrow("AMOUNT"));
            dataModel.setDate(DATE);
            dataModel.setRemark(REMARK);
            dataModel.setSpend(SPEND);
            stringBuffer.append(dataModel);
            // stringBuffer.append(dataModel);
            data.add(dataModel);
        }

        for (DataModel mo : data) {

            Log.i("Hellomo", "" + mo.getDate());
        }
        return data;
    }



    public int geteamount() {
        int sum = 0;
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT AMOUNT FROM user_table WHERE CATEGORY='ELECTRONIC DEVICES';", null);
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            array_list.add(res.getString(res.getColumnIndex(COL_4)));
            res.moveToNext();
        }


        for (int i = 0; i < array_list.size(); i++) {
            if (array_list.get(i).equals("")) {
                sum = sum + 0;
            } else {
                int n3 = Integer.parseInt(array_list.get(i));
                sum = sum + n3;

            }

        }
        return sum;

    }
    public java.util.List<DataModel> getME() {
        // DataModel dataModel = new DataModel();
        java.util.List<DataModel> data = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user_table WHERE CATEGORY='MONTHLY EXPENDITURE';", null);
        StringBuffer stringBuffer = new StringBuffer();
        DataModel dataModel = null;
        while (cursor.moveToNext()) {
            dataModel = new DataModel();
            String DATE = cursor.getString(cursor.getColumnIndexOrThrow("DATE"));
            String REMARK = cursor.getString(cursor.getColumnIndexOrThrow("REMARK"));
            String SPEND = cursor.getString(cursor.getColumnIndexOrThrow("AMOUNT"));
            dataModel.setDate(DATE);
            dataModel.setRemark(REMARK);
            dataModel.setSpend(SPEND);
            stringBuffer.append(dataModel);
            // stringBuffer.append(dataModel);
            data.add(dataModel);
        }

        for (DataModel mo : data) {

            Log.i("Hellomo", "" + mo.getDate());
        }
        return data;
    }



    public int getmeamount() {
        int sum = 0;
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT AMOUNT FROM user_table WHERE CATEGORY='MONTHLY EXPENDITURE';", null);
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            array_list.add(res.getString(res.getColumnIndex(COL_4)));
            res.moveToNext();
        }


        for (int i = 0; i < array_list.size(); i++) {
            if (array_list.get(i).equals("")) {
                sum = sum + 0;
            } else {
                int n3 = Integer.parseInt(array_list.get(i));
                sum = sum + n3;

            }

        }
        return sum;

    }


    public java.util.List<DataModel> getother() {
        // DataModel dataModel = new DataModel();
        java.util.List<DataModel> data = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user_table WHERE CATEGORY='OTHERS';", null);
        StringBuffer stringBuffer = new StringBuffer();
        DataModel dataModel = null;
        while (cursor.moveToNext()) {
            dataModel = new DataModel();
            String DATE = cursor.getString(cursor.getColumnIndexOrThrow("DATE"));
            String REMARK = cursor.getString(cursor.getColumnIndexOrThrow("REMARK"));
            String SPEND = cursor.getString(cursor.getColumnIndexOrThrow("AMOUNT"));
            dataModel.setDate(DATE);
            dataModel.setRemark(REMARK);
            dataModel.setSpend(SPEND);
            stringBuffer.append(dataModel);
            // stringBuffer.append(dataModel);
            data.add(dataModel);
        }

        for (DataModel mo : data) {

            Log.i("Hellomo", "" + mo.getDate());
        }
        return data;
    }



    public int getotheramount() {
        int sum = 0;
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT AMOUNT FROM user_table WHERE CATEGORY='OTHERS';", null);
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            array_list.add(res.getString(res.getColumnIndex(COL_4)));
            res.moveToNext();
        }


        for (int i = 0; i < array_list.size(); i++) {
            if (array_list.get(i).equals("")) {
                sum = sum + 0;
            } else {
                int n3 = Integer.parseInt(array_list.get(i));
                sum = sum + n3;

            }

        }
        return sum;

    }


}









// SELECT * FROM TOTAL_AMOUNT WHERE ID=(SELECT MAX(ID) FROM TOTAL_AMOUNT);