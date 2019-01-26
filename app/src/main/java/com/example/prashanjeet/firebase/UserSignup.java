package com.example.prashanjeet.firebase;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class UserSignup extends AppCompatActivity {
    private Button UserSignUpbtn;
    public ProgressDialog progressDialog;
    public FirebaseAuth firebaseAuth;
    // private DatabaseReference databaseUserMeals;
    public DatabaseReference databaseUsers;
    private Spinner spinner,studentHostel;
    public EditText name,userEmail,userPassword,userContact,username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_signup);
        firebaseAuth = FirebaseAuth.getInstance();
        databaseUsers = FirebaseDatabase.getInstance().getReference("users");
        //databaseUserMeals = FirebaseDatabase.getInstance().getReference("userMeals");
        UserSignUpbtn = (Button)findViewById(R.id.UserSignupButton);
        name = (EditText)findViewById(R.id.Name);
        userEmail = (EditText)findViewById(R.id.UserEmail);
        userPassword = (EditText)findViewById(R.id.UserSignuppassword);
        //studentHostel = (EditText)findViewById(R.id.studentHost);
        // studentHostel = (Spinner)findViewById(R.id.studentHost);
        // studentRoom = (EditText)findViewById(R.id.studentRoom);
        userContact = (EditText)findViewById(R.id.UserContact);
        //studentReg = (EditText)findViewById(R.id.studentRegNo);
//        List<String> list  = new ArrayList<String>();
//        list.add("Select Hostel");
//        list.add("Tandon");
//        list.add("Malviya");
//        list.add("Tilak");
//        list.add("Patel");
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(StudentSignUp.this,android.R.layout.simple_spinner_item,list);
//        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        studentHostel.setAdapter(arrayAdapter);
//        studentHostel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                studentHostel.setSelection(position);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
        progressDialog = new ProgressDialog(UserSignup.this);
        UserSignUpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Uploading Details!!");
                progressDialog.show();
                if(validate()){
                    final  String userN = name.getText().toString();
                    final String userP = userPassword.getText().toString().trim();
                    final String userE = userEmail.getText().toString().trim();
                    final String username1 = name.getText().toString().trim();
                    final String userC = userContact.getText().toString().trim();
                    //final String studentRegn = studen.getText().toString();
                    //final String studentH = studentHostel.getC
                    // final String studentH = studentHostel.getSelectedItem().toString();
                    //Toast.makeText(StudentSignUp.this,studentH,Toast.LENGTH_SHORT).show();
                    firebaseAuth.createUserWithEmailAndPassword(userE,userP).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                //progressDialog.dismiss();
                                String id = firebaseAuth.getCurrentUser().getUid();
                                //String id1 = databaseUserMeals.push().getKey();
                                //UserMeal userMeal = new UserMeal(studentN,studentRegn);
                                User user =new User(userN,userC,userE,id,username1);
                                try {
                                    databaseUsers.child(id).setValue(user);
                                    //databaseUserMeals.child(id).setValue(userMeal);
                                    sendEmailVerification();
                                }
                                catch (Exception e){
                                    e.printStackTrace();
                                    Toast.makeText(UserSignup.this,"Network error please try later",Toast.LENGTH_SHORT).show();
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
                                progressDialog.dismiss();
                                Toast.makeText(UserSignup.this,"Registration Failed",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
                else
                {
                    Toast.makeText(UserSignup.this,"Fill all details",Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();

            }
        });

    }
    public Boolean validate(){
        Boolean result = false;
        String userN = name.getText().toString();
        String userP = userPassword.getText().toString();
        String userE = userEmail.getText().toString();
        String username1=username.getText().toString();
        //final String studentR = studentRoom.getText().toString().trim();
        final String userC = userContact.getText().toString().trim();
        //String studentRegn = studentReg.getText().toString();
        // String studentH = studentHostel.getText().toString();
        String studentH =studentHostel.getSelectedItem().toString();
        if(userN.isEmpty()||userP.isEmpty()||userE.isEmpty()|| userC.isEmpty()||username1.isEmpty())
        {
            //Toast.makeText(this,"Please fill all details",Toast.LENGTH_SHORT).show();
            // progressDialog.dismiss();
        }
        else{
            result = true;
        }
        return result;
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
                        Toast.makeText(UserSignup.this,"Successfully Registered and Email send !!",Toast.LENGTH_SHORT).show();
                        firebaseAuth.signOut();
                        progressDialog.dismiss();

                        Intent intent = new Intent(UserSignup.this,MainActivity.class);
                        startActivity(intent);
                        finish();

                    }
                    else{
                        Toast.makeText(UserSignup.this,"Verification mail not send ",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}