package com.example.prashanjeet.firebase;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import java.util.List;

public class MainScreenUser extends AppCompatActivity {

    FloatingActionButton addBtn;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main_screen_user);
//        addBtn = (FloatingActionButton)findViewById(R.id.addBtn);
//        businessList = new ArrayList<SubService>();
//        addBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainScreenUser.this, Bussiness.class));
//            }
//        });
//    }
//
    ListView businessListView;
    ArrayList<SubService> businessList;

    private FirebaseAuth firebaseAuth;
    private List<SubService> servList;
    private SubService serv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen_user);
        businessListView = (ListView)findViewById(R.id.mainScreenListView);
        businessList = new ArrayList<SubService>();
        firebaseAuth=FirebaseAuth.getInstance();
        addBtn = (FloatingActionButton)findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainScreenUser.this, Bussiness.class));
            }
        });



        businessList = new ArrayList<SubService>();

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

        DatabaseReference adminsRef = FirebaseDatabase.getInstance().getReference("usersQueue").child(userId);

        try {

//            adminsRef = FirebaseDatabase.getInstance().getReference("users").child(userId);

            adminsRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    businessList.clear();

                    for (DataSnapshot mealSnapshot : dataSnapshot.getChildren()) {
                        SubService a = (SubService)mealSnapshot.getValue(SubService.class);
                        businessList.add(a);
//
//                        Date c = Calendar.getInstance().getTime();
//                        //System.out.println("Current time => " + c);
//
//                        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//                        String formattedDate = df.format(c);
//
//                        if (formattedDate.compareTo(a.date) <= 0 && a.getRegistration().compareTo("open") == 0) {
//                            mealList.add(a);
//                        }


                    }

//                    Collections.sort(mealList, new Comparator() {
//                        @Override
//                        public int compare(Object o1, Object o2) {
//                            Meal a1 = (Meal) o1;
//                            Meal a2 = (Meal) o2;
//                            return a1.date.compareToIgnoreCase(a2.date);
//                        }
//                    });




                    //progressDialog.dismiss();
                    if (businessList.size() == 0) {
                        Toast.makeText(getApplicationContext(), "No queues joined", Toast.LENGTH_SHORT).show();
                        // progressDialog.dismiss();
                    }else{
                        try {
                            ListAdapter customListAdapter = new BussinessListAdapter(MainScreenUser.this, businessList);
                            businessListView.setAdapter(customListAdapter);
                        }
                        catch (Exception e){
                            Toast.makeText(MainScreenUser.this, "null", Toast.LENGTH_SHORT).show();
                        }
                    }

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
