package com.example.prashanjeet.firebase;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminSignup extends AppCompatActivity {
    public EditText serviceName,serviceDomain,adminName,adminEmail,adminPassword,adminCont;
    public Button signupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_signup);
        serviceName  = (EditText)findViewById(R.id.ServiceName);
        serviceDomain = (EditText)findViewById(R.id.ServiceDomain);
        adminName = (EditText)findViewById(R.id.Name);
        adminEmail = (EditText)findViewById(R.id.Email);
        adminPassword = (EditText)findViewById(R.id.Signuppassword);
        adminCont = (EditText)findViewById(R.id.Contact);
        signupBtn = (Button)findViewById(R.id.SignupButton);
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate())
                {

                }
            }
        });
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

}