package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDBHelper  extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "project.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "profile";
    public static final String COLUMN_ID = "userid";
    public static final String COLUMN_FULLNAME = "fullname";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_MOBILE = "mobile";

    public SQLiteDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME +"(userid INTEGER PRIMARY KEY AUTOINCREMENT,fullname TEXT,email TEXT,password TEXT,mobile TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean inserted(String fullname, String email, String password, String mobile) {

        SQLiteDatabase  db=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN_FULLNAME,fullname);
        contentValues.put(COLUMN_EMAIL,email);
        contentValues.put(COLUMN_PASSWORD,password);
        contentValues.put(COLUMN_MOBILE,mobile);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result==-1) {
            return false;
        }
        else {
            return true;
        }
    }
    public Cursor AllData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
    public Integer Deleted(String userid)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME,"ID=?",new String[]{userid});
    }

    public boolean updated(String userid,String fullname,String email,String password,String mobile)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN_FULLNAME,fullname);
        contentValues.put(COLUMN_EMAIL,email);
        contentValues.put(COLUMN_PASSWORD,password);
        contentValues.put(COLUMN_MOBILE,mobile);
        db.update(TABLE_NAME,contentValues,"ID=?",new String[]{userid});
        return true;
    }

}
