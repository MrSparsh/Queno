package com.example.prashanjeet.firebase;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class AdminSignup extends AppCompatActivity {
    public EditText serviceName, serviceDomain, adminName, adminEmail, adminPassword, adminCont;
    public Button signupBtn;
    public FirebaseAuth firebaseAuth;
    // private DatabaseReference databaseUserMeals;
    public DatabaseReference databaseAdmins;
    String userLati;
    String userLongi;
    private FusedLocationProviderClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseAdmins = FirebaseDatabase.getInstance().getReference("admins");
        firebaseAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_admin_signup);
        serviceName = (EditText) findViewById(R.id.ServiceName);
        serviceDomain = (EditText) findViewById(R.id.ServiceDomain);
        adminName = (EditText) findViewById(R.id.Name);
        adminEmail = (EditText) findViewById(R.id.Email);
        adminPassword = (EditText) findViewById(R.id.Signuppassword);
        adminCont = (EditText) findViewById(R.id.Contact);
        signupBtn = (Button) findViewById(R.id.SignupButton);

        requestPermissions();

        //Get Self Location
        client = LocationServices.getFusedLocationProviderClient(this);

        if (ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        client.getLastLocation().addOnSuccessListener(AdminSignup.this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location != null){
                    userLati = "" + location.getLatitude();
                    userLongi = ""  + location.getLongitude();
                    System.out.println(userLati + " " + userLongi);
                    return;
                }
            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate())
                {
                    final String sname,sdomain,aName,aEmail,aPassword,aContact;
                    sname = serviceName.getText().toString();
                    sdomain= serviceDomain.getText().toString();
                    aName = adminName.getText().toString();
                    aEmail = adminEmail.getText().toString();
                    aPassword = adminPassword.getText().toString();
                    aContact = adminCont.getText().toString();
                    //final String lati,longi ;


                    firebaseAuth.createUserWithEmailAndPassword(aEmail,aPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                //progressDialog.dismiss();
                                String id = firebaseAuth.getCurrentUser().getUid();
                                //String id1 = databaseUserMeals.push().getKey();
                                //UserMeal userMeal = new UserMeal(studentN,studentRegn);

                                Admin admin =new Admin(sname,sdomain,aName, aEmail, aPassword,aContact,id,userLati,userLongi);

                                try {
                                    //databaseAdmins.child(id).setValue(admin);
                                    //databaseUserMeals.child(id).setValue(userMeal);
                                    sendEmailVerification();
                                }
                                catch (Exception e){
                                    e.printStackTrace();
                                    Toast.makeText(AdminSignup.this,"Network error please try later",Toast.LENGTH_SHORT).show();
                                }

//                                SharedPreferences sharedPreferences =getSharedPreferences("myFile", Context.MODE_PRIVATE);
//                                SharedPreferences.Editor editor =sharedPreferences.edit();
//                                editor.putString("name", userN);
//                                editor.putString("id", id);
//                               // editor.putString("mealId",id1);
//                                editor.putString("email", userE);
//                                editor.putString("mobile", userC);
//                                editor.putString("username"))
//                                editor.commit();
                            }
                            else{
                                //progressDialog.dismiss();
                                Toast.makeText(AdminSignup.this,"Registration Failed",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
                else{
                    Toast.makeText(AdminSignup.this,"Fill all details",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void requestPermissions()
    {
        ActivityCompat.requestPermissions(this,new String[]{ACCESS_FINE_LOCATION},1);
    }

    public boolean validate(){
        boolean flag=false;
        String sname,sdomain,aName,aEmail,aPassword,aContact;
        sname = serviceName.getText().toString();
        sdomain= serviceDomain.getText().toString();
        aName = adminName.getText().toString();
        aEmail = adminEmail.getText().toString();
        aPassword = adminPassword.getText().toString();
        aContact = adminCont.getText().toString();
        if(sname.isEmpty()||sdomain.isEmpty()||aName.isEmpty()||aEmail.isEmpty()||aPassword.isEmpty()||aContact.isEmpty())
        {
            Toast.makeText(AdminSignup.this,"Fill All Details",Toast.LENGTH_SHORT).show();
            return flag;
        }
        flag=true;
        return  flag;

    }

    private void sendEmailVerification(){
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        String email2 = firebaseUser.getEmail();
        // Toast.makeText(StudentSignUp.this,email2,Toast.LENGTH_SHORT).show();
        if(firebaseUser != null){
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                    if(task.isSuccessful()){
                        Toast.makeText(AdminSignup.this,"Successfully Registered and Email send !!",Toast.LENGTH_SHORT).show();
                        firebaseAuth.signOut();
                        //progressDialog.dismiss();

                        Intent intent = new Intent(AdminSignup.this,MainActivity.class);
                        startActivity(intent);
                        finish();

                    }
                    else{
                        Toast.makeText(AdminSignup.this,"Verification mail not send ",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}