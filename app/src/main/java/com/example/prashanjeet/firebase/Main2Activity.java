package com.example.prashanjeet.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        System.out.println("Google " + getIntent().getStringExtra("Name") + "\n" + getIntent().getStringExtra("Email")
         + " " + getIntent().getStringExtra("servicename") + " " + getIntent().getStringExtra("servicedomain")
        + " " + getIntent().getStringExtra("expecttime") + " "  +
        getIntent().getStringExtra("besttime") +" "+getIntent().getStringExtra("LATI")+" "+getIntent().getStringExtra("LONGI"));

          //SubService subService=    SubService(getIntent().getStringExtra("servicename"), String counters, String startTime, String handlingTime, String details,String lati, String longi)


        Intent intent = new Intent(Main2Activity.this,AddServiceAdmin.class);
        startActivity(intent);

    }
}
