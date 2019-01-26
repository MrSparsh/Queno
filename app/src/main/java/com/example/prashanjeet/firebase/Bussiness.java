package com.example.prashanjeet.firebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class Bussiness extends AppCompatActivity {

    ListView businessListView;
    ArrayList<SubService> businessList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bussiness);
        businessListView = (ListView)findViewById(R.id.bussinessListView);
        businessList = new ArrayList<SubService>();

        DatabaseReference adminsRef = FirebaseDatabase.getInstance().getReference("admins");
        adminsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()){
                    System.out.println(childDataSnapshot.getValue(Map.class).get("companyName"));

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        businessList = new ArrayList<SubService>();
        ListAdapter customListAdapter = new BussinessListAdapter(this,businessList);
        businessListView.setAdapter(customListAdapter);

    }
}
