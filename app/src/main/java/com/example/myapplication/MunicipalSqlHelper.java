package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MunicipalSqlHelper   extends SQLiteOpenHelper {

    static String DATABASE_NAME = "projectDataBase";

    public static final String KEY_ID = "id";

    public static final String TABLE_NAME = "municipalTable";

    public static final String KEY_Name = "name";

    public static final String KEY_PhoneNumber = "phone_number";

    public static final String KEY_Address = "address";
    public static final String KEY_Complaint = "complaint";

    public MunicipalSqlHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_Name + " VARCHAR, " + KEY_PhoneNumber + " VARCHAR, " + KEY_Address + " VARCHAR," + KEY_Complaint + " VARCHAR)";
        try {
            database.execSQL(CREATE_TABLE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
}
