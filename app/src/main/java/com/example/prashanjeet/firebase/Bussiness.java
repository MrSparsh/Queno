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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Bussiness extends AppCompatActivity {

    ListView businessListView;
    ArrayList<SubService> businessList;

    private FirebaseAuth firebaseAuth;
    private List<SubService> servList;
    private SubService serv;

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

        businessListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                serv =businessList.get(i);
                joinqueue(serv);
            }
        });

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

    public void joinqueue(SubService serv){
        firebaseAuth = FirebaseAuth.getInstance();
        String userId = firebaseAuth.getCurrentUser().getUid();
//        DatabaseReference adminsRef = FirebaseDatabase.getInstance().getReference("usersQueue").child(userId).child(serv.getId());
        DatabaseReference adminsRef = FirebaseDatabase.getInstance().getReference("usersQueue");
        adminsRef.child(userId).child(serv.getId()).setValue(serv);
        CustomQ q =new CustomQ(0,42,10);

        DatabaseReference qu = FirebaseDatabase.getInstance().getReference("serviceQ");
        qu.child(serv.getId()).setValue(q);
    }
}
