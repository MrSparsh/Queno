package com.example.prashanjeet.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ServiceInfoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_info);

        Button addLoc = (Button)findViewById(R.id.SignupButton);

        addLoc.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ServiceInfoActivity.this,MapsActivity.class);
                String servicename,servicedomain,expectedtime,besttime;
//                uname = getIntent().getStringExtra("Name");
//                uemail = getIntent().getStringExtra("Email");
                TextView ServiceName = (TextView)findViewById(R.id.SubServiceName);
                TextView counters = (TextView)findViewById(R.id.NoOfCounters);
                TextView handlingTime = (TextView)findViewById(R.id.HandlingTime);
                TextView startTime = (TextView)findViewById(R.id.StartTime);
                TextView details = (TextView)findViewById(R.id.Details);



                if(ServiceName.getText().equals("") || counters.getText().equals("")||  handlingTime.getText().equals("")
                        || startTime.getText().equals("") || details.getText().equals("")){
                    Toast.makeText(ServiceInfoActivity.this,"All info Needed!!!",Toast.LENGTH_LONG);
                    return;
                }


                intent.putExtra("ServiceName",ServiceName.getText().toString());
                intent.putExtra("couters",counters.getText().toString());
                intent.putExtra("handlingTime",handlingTime.getText().toString());
                intent.putExtra("startTime", startTime.getText().toString());
                intent.putExtra("details", details.getText().toString());

                startActivity(intent);
            }

        });

    }

}
