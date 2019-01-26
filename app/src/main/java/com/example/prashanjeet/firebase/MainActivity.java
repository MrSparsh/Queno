package com.example.prashanjeet.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.onesignal.OneSignal;
//
//public class MainActivity extends AppCompatActivity {
//
//    private FirebaseAuth mAuth;
//    private FirebaseAuth.AuthStateListener mAuthListener;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Intent inter = new Intent(MainActivity.this,GoogleMap.class);
//        startActivity(inter);
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message");
//
//        myRef.setValue("Hello, World!");
////        mAuth = FirebaseAuth.getInstance();
////        mAuthListener = new FirebaseAuth.AuthStateListener() {
////            @Override
////            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
////                FirebaseUser user = firebaseAuth.getCurrentUser();
////                if (user != null) {
////                    // User is signed in
////                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
////                } else {
////                    // User is signed out
////                    Log.d(TAG, "onAuthStateChanged:signed_out");
////                }
////            }
////        };
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        mAuth.addAuthStateListener(mAuthListener);
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        if (mAuthListener != null) {
//            mAuth.removeAuthStateListener(mAuthListener);
//        }
//    }
//
//}


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
                Intent  intent  = new  Intent(MainActivity.this,AdminLogin.class);
                startActivity(intent);
                finish();
            }
        });

    }
}