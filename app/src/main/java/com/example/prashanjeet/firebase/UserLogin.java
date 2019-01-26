package com.example.prashanjeet.firebase;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserLogin extends AppCompatActivity {
    public Button loginUser,signupUser;
    public EditText emailUser,passwordUser;
    private  FirebaseAuth firebaseAuth;
    public  FirebaseUser firebaseUser;
    public TextView forgot;
    private ProgressDialog progressDialog;
    String name;
    String stat;
    String testString;
    Boolean emailflag,flag;
    int y;
    User user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        loginUser = (Button)findViewById(R.id.LoginButton);
        signupUser = (Button)findViewById(R.id.SignupButton);
        emailUser = (EditText)findViewById(R.id.username);
        forgot = (TextView)findViewById(R.id.forgetpasswordTextView);
        passwordUser = (EditText)findViewById(R.id.password);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(UserLogin.this);
        loginUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate1()){
                    validate(emailUser.getText().toString(),passwordUser.getText().toString());
                }
            }
        });
        signupUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(UserLogin.this,UserSignup.class);
                startActivity(intent);
            }
        });
    }

    public Boolean validate1(){
        Boolean result = false;
        String name = emailUser.getText().toString();
        String passWord = passwordUser.getText().toString();
        // String userEmail = user_name.getText().toString();
        if(name.isEmpty()||passWord.isEmpty())
        {
            Toast.makeText(this,"Please fill all details",Toast.LENGTH_SHORT).show();
        }
        else{
            result = true;
        }
        return result;
    }
    private void validate(String userEmail,String userPassword){

        progressDialog.setMessage("Checking your credintials!!");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(userEmail,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){

                    //Toast.makeText(MainActivity.this, "Login Successful   !!", Toast.LENGTH_SHORT).show();
                    // Intent intent = new Intent(MainActivity.this,Second.class);
                    //   startActivity(intent);
                    checkEmailVerification();


                }
                else{

                    Toast.makeText(UserLogin.this, "Login failed !!", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
        });

    }


    private void checkEmailVerification(){
        Log.d("res", "in check email verify");
        firebaseUser = firebaseAuth.getInstance().getCurrentUser();
        emailflag = firebaseUser.isEmailVerified();
        if(emailflag)
        {

            Toast.makeText(UserLogin.this, "Login successfull!!", Toast.LENGTH_SHORT).show();
            //progressDialog.dismiss();
            emailUser.setText("");
            passwordUser.setText("");
            //Intent intent = new Intent(UserLogin.this, UserHome.class);
            //String mealId = user.getMealId();
            //intent.putExtra("mealId",mealId);
            // intent.putExtra("user_name",user.getName());
            //startActivity(intent);
            finish();
        }
        else{
            Toast.makeText(UserLogin.this,"Please get you email verified!!",Toast.LENGTH_SHORT).show();
            emailUser.setText("");
            passwordUser.setText("");
            firebaseAuth.signOut();
        }


    }

//    public void generateQRCode(){
//        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
//        try {
//            BitMatrix bitMatrix = multiFormatWriter.encode(firebaseAuth.getInstance().getCurrentUser().getUid(), BarcodeFormat.QR_CODE,200,200);
//            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
//            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
//
//
//        }
//        catch (Exception e){
//            e.printStackTrace();;
//        }
//
//    }

}
