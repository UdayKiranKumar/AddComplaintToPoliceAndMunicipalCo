package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Addpolicecomplain extends AppCompatActivity {
    EditText GetName,GetPhoneNumber,GetAddress,GetComplaint ;
    Button Submit;
    SQLiteDatabase SQLITEDATABASE;
    String Name, PhoneNumber, Address,Complaint ;
    Boolean CheckEditTextEmpty ;
    String SQLiteQuery ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpolicecomplain);
        GetName = (EditText)findViewById(R.id.editText1);

        GetPhoneNumber = (EditText)findViewById(R.id.editText2);

        GetAddress = (EditText)findViewById(R.id.editText3);
        GetComplaint=(EditText)findViewById(R.id.complaint_edit);

        Submit = (Button)findViewById(R.id.button1);


        Submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                DBCreate();

                SubmitData2SQLiteDB();

            }
        });


    }

    public void DBCreate(){

        SQLITEDATABASE = openOrCreateDatabase("projectDataBase", Context.MODE_PRIVATE, null);

        SQLITEDATABASE.execSQL("CREATE TABLE IF NOT EXISTS policeTable(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name VARCHAR, phone_number VARCHAR, address VARCHAR,complaint VARCHAR);");
    }

    public void SubmitData2SQLiteDB(){

        Name = GetName.getText().toString();

        PhoneNumber = GetPhoneNumber.getText().toString();

        Address = GetAddress.getText().toString();
        Complaint=GetComplaint.getText().toString();

        CheckEditTextIsEmptyOrNot( Name,PhoneNumber,Address,Complaint);

        if(CheckEditTextEmpty == true)
        {

            SQLiteQuery = "INSERT INTO policeTable (name,phone_number,address,complaint) VALUES('"+Name+"', '"+PhoneNumber+"', '"+Address+"','"+Complaint+"');";

            SQLITEDATABASE.execSQL(SQLiteQuery);

            Toast.makeText(Addpolicecomplain.this,"Data Submit Successfully", Toast.LENGTH_LONG).show();

            ClearEditTextAfterDoneTask();

        }
        else {

            Toast.makeText(Addpolicecomplain.this,"Please Fill All the Fields", Toast.LENGTH_LONG).show();
        }
    }

    public void CheckEditTextIsEmptyOrNot( String Name, String PhoneNumber, String Address,String Complaint){

        if(TextUtils.isEmpty(Name) || TextUtils.isEmpty(PhoneNumber) || TextUtils.isEmpty(Address) || TextUtils.isEmpty(Complaint)){

            CheckEditTextEmpty = false ;

        }
        else {
            CheckEditTextEmpty = true ;
        }
    }

    public void ClearEditTextAfterDoneTask(){

        GetName.getText().clear();
        GetPhoneNumber.getText().clear();
        GetAddress.getText().clear();
        GetComplaint.getText().clear();

    }
}
