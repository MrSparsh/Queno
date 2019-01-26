package com.example.prashanjeet.firebase;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class UserHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);
//        Button button=(Button) findViewById(R.id.button2);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                sendNotification();
//            }
//        });
    }



//    private void sendNotification()
//    {
//
//        Toast.makeText(this, "Current Recipients is : user1@gmail.com ( Just For Demo )", Toast.LENGTH_SHORT).show();
//
//        AsyncTask.execute(new Runnable() {
//            @Override
//            public void run() {
//                int SDK_INT = android.os.Build.VERSION.SDK_INT;
//                if (SDK_INT > 8) {
//                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
//                            .permitAll().build();
//                    StrictMode.setThreadPolicy(policy);
//                    String send_email;
//
//                    //This is a Simple Logic to Send Notification different Device Programmatically....
//
//                    send_email = "mayankrana00@gmail.com";
//
//
//                    try {
//                        String jsonResponse;
//
//                        URL url = new URL("https://onesignal.com/api/v1/notifications");
//                        HttpURLConnection con = (HttpURLConnection) url.openConnection();
//                        con.setUseCaches(false);
//                        con.setDoOutput(true);
//                        con.setDoInput(true);
//
//                        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
//                        con.setRequestProperty("Authorization", "Basic MGRjOWI0OTItYTJjZS00NGU4LThjYjYtOWMzYjVhNzZiZTQ5");
//                        con.setRequestMethod("POST");
//
//                        String strJsonBody = "{"
//                                + "\"app_id\": \"1dae7217-1ba0-410f-88b7-61d034120d60\","
//
//                                + "\"filters\": [{\"field\": \"tag\", \"key\": \"User_ID\", \"relation\": \"=\", \"value\": \"" + send_email + "\"}],"
//
//                                + "\"data\": {\"foo\": \"bar\"},"
//                                + "\"contents\": {\"en\": \"English Message\"}"
//                                + "}";
//
//
//                        System.out.println("strJsonBody:\n" + strJsonBody);
//
//                        byte[] sendBytes = strJsonBody.getBytes("UTF-8");
//                        con.setFixedLengthStreamingMode(sendBytes.length);
//
//                        OutputStream outputStream = con.getOutputStream();
//                        outputStream.write(sendBytes);
//
//                        int httpResponse = con.getResponseCode();
//                        System.out.println("httpResponse: " + httpResponse);
//
//                        if (httpResponse >= HttpURLConnection.HTTP_OK
//                                && httpResponse < HttpURLConnection.HTTP_BAD_REQUEST) {
//                            Scanner scanner = new Scanner(con.getInputStream(), "UTF-8");
//                            jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
//                            scanner.close();
//                        } else {
//                            Scanner scanner = new Scanner(con.getErrorStream(), "UTF-8");
//                            jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
//                            scanner.close();
//                        }
//                        System.out.println("jsonResponse:\n" + jsonResponse);
//
//                    } catch (Throwable t) {
//                        t.printStackTrace();
//                    }
//                }
//            }
//        });
//    }
}
