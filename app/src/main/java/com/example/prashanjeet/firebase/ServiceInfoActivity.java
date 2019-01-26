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

        Button signupbtn = (Button)findViewById(R.id.SignupButton);

        signupbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ServiceInfoActivity.this,MapsActivity.class);
                String uname,uemail,servicename,servicedomain,expectedtime,besttime;
                uname = getIntent().getStringExtra("Name");
                uemail = getIntent().getStringExtra("Email");
                TextView ServiceName = (TextView)findViewById(R.id.ServiceName);
                TextView ServiceDomain = (TextView)findViewById(R.id.ServiceDomain);
                TextView expected_time = (TextView)findViewById(R.id.expected_time);
                TextView best_time = (TextView)findViewById(R.id.best_time);
                if(ServiceName.getText() == "" || ServiceDomain.getText() == "" || expected_time.getText() == ""
                        || best_time.getText() == ""){
                    Toast.makeText(ServiceInfoActivity.this,"All Needed!!!",Toast.LENGTH_LONG);
                    return;
                }

                intent.putExtra("UName",uname);
                intent.putExtra("Email",uemail);
                intent.putExtra("ServiceName",ServiceName.getText().toString());
                intent.putExtra("ServiceDomain",ServiceDomain.getText().toString());
                intent.putExtra("expected_time",expected_time.getText().toString());
                intent.putExtra("best_time",best_time.getText().toString());

                startActivity(intent);
            }

        });

    }

}
