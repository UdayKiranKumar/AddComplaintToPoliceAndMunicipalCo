package com.example.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewCollectorcomplaint extends AppCompatActivity {
    CollectorSqlHelprt SQLITEHELPER;
    SQLiteDatabase SQLITEDATABASE;
    Cursor cursor;
    collectoradapter ListAdapter ;

    ArrayList<String> ID_ArrayList = new ArrayList<String>();
    ArrayList<String> NAME_ArrayList = new ArrayList<String>();
    ArrayList<String> PHONE_NUMBER_ArrayList = new ArrayList<String>();
    ArrayList<String> ADDRESS_ArrayList = new ArrayList<String>();
    ArrayList<String> COMPLAINT_ArrayList = new ArrayList<String>();

    ListView LISTVIEW;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_collectorcomplaint);
        LISTVIEW = (ListView) findViewById(R.id.listview);

        SQLITEHELPER = new CollectorSqlHelprt(this);

    }

    @Override
    protected void onResume() {

        ShowSQLiteDBdata() ;

        super.onResume();
    }

    private void ShowSQLiteDBdata() {

        SQLITEDATABASE = SQLITEHELPER.getWritableDatabase();

        cursor = SQLITEDATABASE.rawQuery("SELECT * FROM collectorTable", null);

        ID_ArrayList.clear();
        NAME_ArrayList.clear();
        PHONE_NUMBER_ArrayList.clear();
        ADDRESS_ArrayList.clear();
        COMPLAINT_ArrayList.clear();

        if (cursor.moveToFirst()) {
            do {
                ID_ArrayList.add(cursor.getString(cursor.getColumnIndex(PoliceSqlHelper.KEY_ID)));

                NAME_ArrayList.add(cursor.getString(cursor.getColumnIndex(PoliceSqlHelper.KEY_Name)));

                PHONE_NUMBER_ArrayList.add(cursor.getString(cursor.getColumnIndex(PoliceSqlHelper.KEY_PhoneNumber)));

                ADDRESS_ArrayList.add(cursor.getString(cursor.getColumnIndex(PoliceSqlHelper.KEY_Address)));
                COMPLAINT_ArrayList.add(cursor.getString(cursor.getColumnIndex(PoliceSqlHelper.KEY_Complaint)));

            } while (cursor.moveToNext());
        }

        ListAdapter = new collectoradapter(ViewCollectorcomplaint.this, ID_ArrayList, NAME_ArrayList, PHONE_NUMBER_ArrayList, ADDRESS_ArrayList,COMPLAINT_ArrayList);

        LISTVIEW.setAdapter(ListAdapter);

        cursor.close();
    }

}
