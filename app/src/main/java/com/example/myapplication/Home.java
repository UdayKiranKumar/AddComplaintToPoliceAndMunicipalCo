package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
    Button view_police_complaintss
            ,view_municipal_complaintss,view_collector;
    String username,password;
    CardView policecomplaints,municipal_complaintt,collector_complainttss;

    String pswd = "";
    String email = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        policecomplaints=(CardView)findViewById(R.id.police_complaint);
        collector_complainttss = (CardView) findViewById(R.id.collector_complaints);
        view_collector = (Button) findViewById(R.id.view_collcetor_complaints);
        municipal_complaintt=(CardView)findViewById(R.id.municipal_complaints);
        view_municipal_complaintss=(Button)findViewById(R.id.view_municipal_complaints);
        view_police_complaintss=(Button)findViewById(R.id.view_police_complaint);

        pswd = getIntent().getStringExtra("password");
        email = getIntent().getStringExtra("email");


        if (pswd.equals("admin") && email.equals("admin")){
            policecomplaints.setVisibility(View.GONE);
            municipal_complaintt.setVisibility(View.GONE);
            collector_complainttss.setVisibility(View.GONE);
            view_police_complaintss.setVisibility(View.VISIBLE);
            view_municipal_complaintss.setVisibility(View.VISIBLE);
            view_collector.setVisibility(View.VISIBLE);

        }else {
            view_police_complaintss.setVisibility(View.GONE);
            view_municipal_complaintss.setVisibility(View.GONE);
            view_collector.setVisibility(View.GONE);
            policecomplaints.setVisibility(View.VISIBLE);
            municipal_complaintt.setVisibility(View.VISIBLE);

            collector_complainttss.setVisibility(View.VISIBLE);


        }
       /* btn1_usercomplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent8=new Intent(Home.this,ActivityMain.class);
                startActivity(intent8);
            }
        });
        btn2_adminviewcomplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,ListViewActivity.class);
                startActivity(intent);
            }
        });*/
        policecomplaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,Addpolicecomplain.class);
                startActivity(intent);
            }
        });

        view_police_complaintss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,ViewPolicecomplaint.class);
                startActivity(intent);
            }
        });
       view_municipal_complaintss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,ViewMuniplality.class);
                startActivity(intent);
            }
        });
        municipal_complaintt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,Addmunicipality.class);
                startActivity(intent);
            }
        });






       collector_complainttss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,AddCollectorComp.class);
                startActivity(intent);
            }
        });
        view_collector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,ViewCollectorcomplaint.class);
                startActivity(intent);
            }
        });













/*
        Intent intent4=getIntent();

        Log.v("username1 ",intent4.getStringExtra("k1"));
        Log.v("password1 ",intent4.getStringExtra("k2"));

        username=intent4.getStringExtra("k1");
        password=intent4.getStringExtra("k2");
        startActivity(intent4);

        Log.v("username ",username);
        Log.v("password ",password);



        if (username.equalsIgnoreCase("admin")&& password.equalsIgnoreCase("admin")){


            btn2_adminviewcomplaint.setVisibility(View.VISIBLE);
            btn1_usercomplaint.setVisibility(View.GONE);

        }
        else {
            btn1_usercomplaint.setVisibility(View.VISIBLE);
            btn2_adminviewcomplaint.setVisibility(View.GONE);
        }
btn2_adminviewcomplaint.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent6=new Intent(Home.this,ViewAdaminData.class);
        startActivity(intent6);
    }
});
        btn1_usercomplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent8=new Intent(Home.this,AddusersComplaint.class);
                startActivity(intent8);
            }
        });

    }
*/


    }
}
