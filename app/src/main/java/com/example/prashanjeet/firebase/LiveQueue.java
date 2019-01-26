package com.example.prashanjeet.firebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LiveQueue extends AppCompatActivity {

    DatabaseReference myRef;
    ListView queueListView;

    QueueDataModel queueData;


    ArrayList<QueueDataModel> queueDataList;


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_live_queue);
//        queueListView =(ListView) findViewById(R.id.queueListView);
//        queueData = new QueueDataModel[5];
//        ListAdapter customListAdapter = new QueueListAdapter(this,queueData);
//        queueListView.setAdapter(customListAdapter);
//
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_queue);
        queueListView = (ListView)findViewById(R.id.queueListView);
        queueDataList = new ArrayList<QueueDataModel>();
        FirebaseAuth firebaseAuth= FirebaseAuth.getInstance();



//        businessListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
//                serv =businessList.get(i);
//                joinqueue(serv);
//            }
//        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        String userId = firebaseAuth.getCurrentUser().getUid();
        //progressDialog.setMessage("Fetching Details!!");

        DatabaseReference adminsRef = FirebaseDatabase.getInstance().getReference("serviceQ").child(userId).child("list");

        try {

            adminsRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    queueDataList.clear();

                    for (DataSnapshot mealSnapshot : dataSnapshot.getChildren()) {
                        User us = mealSnapshot.getValue(User.class);
                        // add only when user is not none
                        QueueDataModel a =new QueueDataModel("9:00",us.getName());
                        queueDataList.add(a);

                    }


                    ListAdapter customListAdapter = new QueueListAdapter(LiveQueue.this,queueDataList);
                    queueListView.setAdapter(customListAdapter);
                    //progressDialog.dismiss();
                    if (queueDataList.size() == 0) {
                        Toast.makeText(getApplicationContext(), "No one found", Toast.LENGTH_SHORT).show();
                        // progressDialog.dismiss();
                    }
//                    businessListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                        @Override
//                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                            CheckBox checkBox = (CheckBox)view.findViewById(R.id.checkBox3);
//                            if(checkBox.isChecked()){
//                                Toast.makeText(Bussiness.this,"1"+position,Toast.LENGTH_SHORT).show();
//                            }
//                            Toast.makeText(Bussiness.this,"1"+position,Toast.LENGTH_SHORT).show();
//                        }
//                    });

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.w("res", databaseError.toException());
                    Toast.makeText(getApplicationContext(), "Network Error", Toast.LENGTH_SHORT).show();
                }
            });
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
