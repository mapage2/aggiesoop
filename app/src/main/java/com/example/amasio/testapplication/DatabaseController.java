package com.example.amasio.testapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

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

    public static final String TABLE_NAME_2 = "Job";
    public static final String JOB_COL_1 = "TITLE";
    public static final String JOB_COL_2 = "DESCRIPTION";
    public static final String JOB_COL_3 = "PREREQUISITES";
    public static final String JOB_COL_4 = "MAJOR";
    public static final String JOB_COL_5 = "LOCATION";
    public static final String JOB_COL_6 = "CONTACT";

    Student s;
    Job j;

    public DatabaseController(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, BANNER_ID INTEGER, " +
                "FIRST_NAME TEXT, LAST_NAME TEXT, EMAIL TEXT, PASSWORD TEXT, GPA DOUBLE, CLASSIFICATION TEXT, MAJOR TEXT);");
        db.execSQL("CREATE TABLE " + TABLE_NAME_2 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, TITLE TEXT, " +
                "DESCRIPTION TEXT, PREREQUISITES TEXT, MAJOR TEXT, LOCATION TEXT, CONTACT TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_2);
        onCreate(db);
    }

    public boolean insertStudent(Student student){

        s = student;
        ContentValues cv = new ContentValues();

        cv.put(COL_2, s.getBannerId());
        cv.put(COL_3, s.getFirstName());
        cv.put(COL_4, s.getLastName());
        cv.put(COL_5, s.getEmail());
        cv.put(COL_6, s.getPassword());
        cv.put(COL_7, s.getGpa());
        cv.put(COL_8, s.getClassification());
        cv.put(COL_9, s.getMajor());
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.insert(TABLE_NAME, null, cv);
        db.close();

        if(result == -1){
            return false;
        } else{
            return true;
        }
    }

    public boolean insertJob(Job job){

        j = job;
        ContentValues cv = new ContentValues();

        cv.put(JOB_COL_1, j.getTitle());
        cv.put(JOB_COL_2, j.getDescription());
        cv.put(JOB_COL_3, j.getPrerequisites());
        cv.put(JOB_COL_4, j.getMajor());
        cv.put(JOB_COL_5, j.getLocation());
        cv.put(JOB_COL_6, j.getContact());
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.insert(TABLE_NAME_2, null, cv);
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
    public Cursor getAllJobs(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME_2, null);
        return res;
    }

    public String login(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT EMAIL, PASSWORD FROM " + TABLE_NAME, null);
        String dbEmail;
        String password = "Incorrect Password";

        if(res.getCount() == 0){
            password = "Incorrect E-Mail";
            return password;
        }
        while(res.moveToNext()){
            dbEmail = res.getString(0);

            if(dbEmail.equals(email)){
                password = res.getString(1);
                return password;
            }
        }
        return password;
    }

    public Student getStudent(String email){

        Student student = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT BANNER_ID, FIRST_NAME, LAST_NAME, EMAIL, GPA, CLASSIFICATION," +
                " MAJOR FROM " + TABLE_NAME, null);
        String dbEmail;

        if(res.getCount() == 0){
            return student;
        }
        while(res.moveToNext()){
            dbEmail = res.getString(3);

            if(dbEmail.equals(email)){
                student = new Student(res.getInt(0), res.getString(1), res.getString(2), dbEmail,
                        res.getDouble(4), res.getString(5), res.getString(6));
                return student;

            }
        }
        return student;
    }

    public ArrayList<Job> getRelatedJobs(String major){

        ArrayList<Job> jobList = new ArrayList<Job>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT TITLE, DESCRIPTION, PREREQUISITES, MAJOR, LOCATION, CONTACT " +
                 " FROM "+ TABLE_NAME_2, null);

        String dbMajor;

        if(res.getCount() == 0){
            return jobList;
        }
        int count = 0;
        while(res.moveToNext() && count<5){
            dbMajor = res.getString(3);

            if(dbMajor.equals(major)){
                j = new Job(res.getString(0), res.getString(1), res.getString(2), dbMajor,
                        res.getString(4), res.getString(5));
                jobList.add(j);
                count++;
            }
        }
        return jobList;
    }


}
