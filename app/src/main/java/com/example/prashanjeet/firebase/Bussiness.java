package com.example.prashanjeet.firebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;

public class Bussiness extends AppCompatActivity {

    ListView businessListView;
    ArrayList<SubService> businessList;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bussiness);
        businessListView = (ListView)findViewById(R.id.bussinessListView);
        businessList = new ArrayList<SubService>();
        firebaseAuth=FirebaseAuth.getInstance();


//        adminsRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()){
//                    System.out.println(childDataSnapshot.getValue(Map.class).get("companyName"));
//
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

        businessList = new ArrayList<SubService>();



    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth = FirebaseAuth.getInstance();
        String userId = firebaseAuth.getCurrentUser().getUid();
        //progressDialog.setMessage("Fetching Details!!");

        DatabaseReference adminsRef = FirebaseDatabase.getInstance().getReference("subServices");

        try {

//            adminsRef = FirebaseDatabase.getInstance().getReference("users").child(userId);

            adminsRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    businessList.clear();

                    for (DataSnapshot mealSnapshot : dataSnapshot.getChildren()) {
                        SubService a = mealSnapshot.getValue(SubService.class);
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



                    ListAdapter customListAdapter = new BussinessListAdapter(Bussiness.this,businessList);
                    businessListView.setAdapter(customListAdapter);
                    //progressDialog.dismiss();
                    if (businessList.size() == 0) {
                        Toast.makeText(getApplicationContext(), "No Services found", Toast.LENGTH_SHORT).show();
                        // progressDialog.dismiss();
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
