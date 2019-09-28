package com.example.myapplication;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Registration extends AppCompatActivity {
    TextView txt1_reg,txt2_regis;
    EditText ed1_fullname,ed2_email,ed3_password,ed4_phone_number;
    Button btn_register;
    SQLiteDatabase db;
    SQLiteDBHelper openhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        btn_register=(Button)findViewById(R.id.register_button);
        ed1_fullname=(EditText)findViewById(R.id.fullname_reg);
        ed2_email=(EditText)findViewById(R.id.enter_email_reg);
        ed3_password=(EditText)findViewById(R.id.password_reg);
        ed4_phone_number=(EditText)findViewById(R.id.mobilenumber);
        txt1_reg=(TextView)findViewById(R.id.txt4_create);
        txt2_regis=(TextView)findViewById(R.id.txt5_registerAlready);
        openhelper=new SQLiteDBHelper(this);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=openhelper.getWritableDatabase();
                String fullname=ed1_fullname.getText().toString();
                String email=ed2_email.getText().toString();
                String password=ed3_password.getText().toString();
                String mobile=ed4_phone_number.getText().toString();
                InsertData(fullname,email,password,mobile);
                final AlertDialog.Builder builder=new AlertDialog.Builder(Registration.this);
                builder.setTitle("Information");
                builder.setMessage("Your Account is Sucessfully created");
                builder.setPositiveButton("OKAY", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
            }


        });
        txt2_regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(Registration.this,MainActivity.class);
                startActivity(i2);
            }
        });
    }
    private void InsertData(String fullname, String email, String password, String mobile) {
        ContentValues contentValues=new ContentValues();
        contentValues.put(SQLiteDBHelper.COLUMN_FULLNAME,fullname);
        contentValues.put(SQLiteDBHelper.COLUMN_EMAIL,email);
        contentValues.put(SQLiteDBHelper.COLUMN_PASSWORD,password);
        contentValues.put(SQLiteDBHelper.COLUMN_MOBILE,mobile);
        long id=db.insert(SQLiteDBHelper.TABLE_NAME,null,contentValues);

    }
}
