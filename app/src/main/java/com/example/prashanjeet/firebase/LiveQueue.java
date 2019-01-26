package com.example.prashanjeet.firebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;

public class LiveQueue extends AppCompatActivity {

    DatabaseReference myRef;
    ListView queueListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_queue);
        queueListView =(ListView) findViewById(R.id.queueListView);
//        queueData = new QueueDataModel[5];
//        ListAdapter customListAdapter = new QueueListAdapter(this,queueData);
//        queueListView.setAdapter(customListAdapter);

    }
}
