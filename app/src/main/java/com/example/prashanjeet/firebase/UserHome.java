package com.example.prashanjeet.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class UserHome extends AppCompatActivity {

    ArrayList<Double> Lati;
    ArrayList<Double> Longi;
    ArrayList<Double> distOfEveryServiceFromUser;
    ArrayList<Double> distBet2Services[];
    Double UserLati;
    Double UserLongi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        Lati = new ArrayList<Double>();
        Longi = new ArrayList<Double>();
        distOfEveryServiceFromUser = new ArrayList<Double>();

        for(int i=0;i<Lati.size();i++){
            double d = Math.sqrt(Math.pow(UserLati - Lati.get(i),2) + Math.pow(UserLongi - Longi.get(i),2));
            distOfEveryServiceFromUser.add(d);

            distBet2Services[i] = new ArrayList<Double>();
        }

        for(int i=0;i<Lati.size();i++){
            for(int j=i;j<Longi.size();i++){
                double d = Math.sqrt(Math.pow(Lati.get(i) - Lati.get(j),2) + Math.pow(Longi.get(i) - Longi.get(j),2));
                distBet2Services[i].add(d);
                distBet2Services[j].add(d);
            }
        }
    }
}
