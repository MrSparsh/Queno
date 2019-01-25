package com.example.prashanjeet.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    DatabaseReference myRef;
    Button btn;

    public void btnClicked(View v){
        startActivity(new Intent(MainActivity.this,LiveQueue.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        myRef = database.getReference("message");
        myRef.setValue("Hello, World!");
        btn = (Button)findViewById(R.id.btn);

       // startActivity(new Intent(MainActivity.this,LiveQueue.class));
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

}
