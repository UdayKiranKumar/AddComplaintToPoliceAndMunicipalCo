package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1_email, ed2_password;
    Button bt1_login;
    TextView txt1, txt2_register;
    SQLiteDBHelper dbHelper;
    SQLiteDatabase db;
    Cursor cursor;
    CheckBox checkBox;
    private EmailValidator mEmailValidator;
    final String filename2 = "my_per";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1_email = findViewById(R.id.ed1username);
        ed2_password = findViewById(R.id.ed2password);
        bt1_login = findViewById(R.id.login);
        txt2_register = (TextView) findViewById(R.id.btnreg);
        txt1 = (TextView) findViewById(R.id.txt);
        mEmailValidator = new EmailValidator();
        ed1_email.addTextChangedListener(mEmailValidator);
        dbHelper = new SQLiteDBHelper(this);
        db = dbHelper.getWritableDatabase();
        bt1_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email1 = ed1_email.getText().toString().trim();
                String password2 = ed2_password.getText().toString().trim();

                if (email1.equalsIgnoreCase("admin") && (password2.equalsIgnoreCase("admin"))){

                    Intent intent = new Intent(MainActivity.this,Home.class);
                    intent.putExtra("email",email1);
                    intent.putExtra("password",password2);
                    startActivity(intent);

                }else {

                    cursor = db.rawQuery("select * from " + SQLiteDBHelper.TABLE_NAME + " WHERE " + SQLiteDBHelper.COLUMN_EMAIL + "=? " +
                            "and " + SQLiteDBHelper.COLUMN_PASSWORD + "=?", new String[]{email1, password2});
                    if (!mEmailValidator.isValid()) {
                        ed1_email.setError("Invalid email");
                        Toast.makeText(MainActivity.this, "Data not inserted: INVALID EMAIL", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (cursor != null) {

                        if (cursor.getCount() > 0) {
                            cursor.moveToFirst();

                            String femail = cursor.getString(cursor.getColumnIndex(SQLiteDBHelper.COLUMN_EMAIL));
                            String fpswd = cursor.getString(cursor.getColumnIndex(SQLiteDBHelper.COLUMN_PASSWORD));

                            Intent intent = new Intent(MainActivity.this,Home.class);

                            intent.putExtra("email",femail);
                            intent.putExtra("password",fpswd);
                            startActivity(intent);
                            Toast.makeText(MainActivity.this, "Login Sucessfully", Toast.LENGTH_SHORT).show();

                            finish();
                        } else {
                            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("Alert");
                            builder.setMessage("Username or Password is wrong");
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();


                        }

                    }
                }
            }


        });
        txt2_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Registration.class);
                startActivity(i);
            }
        });
    }

   /* protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences(filename2, Context.MODE_PRIVATE);
        String s1 = sharedPreferences.getString("k10", "");
        String a = sharedPreferences.getString("k20", "");
        ed1_email.setText(s1);
        ed2_password.setText(a);
    }

    public void onmethod(View view) {
        if ((checkBox = (CheckBox) view).isChecked()) {
            SharedPreferences sharedPreferences = getSharedPreferences(filename2, Context.MODE_PRIVATE);
            SharedPreferences.Editor spE = sharedPreferences.edit();
            spE.putString("k10", ed1_email.getText().toString());
            spE.putString("k20", ed2_password.getText().toString());
            spE.commit();

        }

    }*/

}

