package com.example.prashanjeet.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button gotoLogin,gotoAdminLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gotoLogin=(Button)findViewById(R.id.GotouserLogin);
        gotoAdminLogin=(Button)findViewById(R.id.GotoAdminLogin);
        gotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent  = new  Intent(MainActivity.this,UserLogin.class);
                startActivity(intent);
                finish();
            }
        });
        gotoAdminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent  = new  Intent(MainActivity.this,UserSignup.class);
                startActivity(intent);
                finish();
            }
        });
    }
}