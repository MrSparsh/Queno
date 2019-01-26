package com.example.prashanjeet.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GoogleMap extends AppCompatActivity {

    TextView lat,lon;
    Button mapbut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);

        lat = (TextView)findViewById(R.id.latitiude);
        lon = (TextView)findViewById(R.id.longitude);

        lat.setText( getIntent().getDoubleExtra("Latitude"));
        lon.setText( getIntent().getDoubleExtra("Longitude"));

        mapbut = (Button)findViewById(R.id.mapbut);

        mapbut.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GoogleMap.this,MapsActivity.class);
                startActivity(intent);
            }
        });
    }
}