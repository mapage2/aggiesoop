package com.example.amasio.testapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Amasio on 11/9/15.
 */
public class DatabaseController extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "Student";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "BANNER_ID";
    public static final String COL_3 = "FIRST_NAME";
    public static final String COL_4 = "LAST_NAME";
    public static final String COL_5 = "EMAIL";
    public static final String COL_6 = "PASSWORD";
    public static final String COL_7 = "GPA";
    public static final String COL_8 = "CLASSIFICATION";
    public static final String COL_9 = "MAJOR";

    public DatabaseController(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, BANNER_ID INTEGER, " +
                "FIRST_NAME TEXT, LAST_NAME TEXT, EMAIL TEXT, PASSWORD TEXT, GPA DOUBLE, CLASSIFICATION TEXT, MAJOR TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertStudent(int bannerId, String firstName, String lastName, String email,
                                 String password, double gpa, String classification, String major){

        ContentValues cv = new ContentValues();
        cv.put(COL_2, bannerId);
        cv.put(COL_3, firstName);
        cv.put(COL_4, lastName);
        cv.put(COL_5, email);
        cv.put(COL_6, password);
        cv.put(COL_7, gpa);
        cv.put(COL_8, classification);
        cv.put(COL_9, major);
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.insert(TABLE_NAME, null, cv);
        db.close();

        if(result == -1){
            return false;
        } else{
            return true;
        }

    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

    public Cursor login(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT EMAIL, PASSWORD FROM "+TABLE_NAME+" WHERE EMAIL="+email+
                " AND PASSWORD= "+password, null);
        return res;
    }


}
