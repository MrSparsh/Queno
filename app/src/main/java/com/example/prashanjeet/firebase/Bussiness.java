package com.example.prashanjeet.firebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Bussiness extends AppCompatActivity {

    ListView businessListView;
    ArrayList<SubService> businessList;
    ArrayList<Boolean> selectedList;
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

        businessList = new ArrayList<SubService>();
        selectedList = new ArrayList<Boolean>();
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

            adminsRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    businessList.clear();

                    for (DataSnapshot mealSnapshot : dataSnapshot.getChildren()) {
                        SubService a = mealSnapshot.getValue(SubService.class);
                        businessList.add(a);
                        selectedList.add(false);

                    }


                    ListAdapter customListAdapter = new BussinessListAdapter(Bussiness.this,businessList);
                    businessListView.setAdapter(customListAdapter);
                    //progressDialog.dismiss();
                    if (businessList.size() == 0) {
                        Toast.makeText(getApplicationContext(), "No Services found", Toast.LENGTH_SHORT).show();
                        // progressDialog.dismiss();
                    }
                    businessListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Toast.makeText(Bussiness.this,"1"+position,Toast.LENGTH_SHORT).show();
                            TextView nameTextView = (TextView) view.findViewById(R.id.nameTextField);
                            TextView durationTextView = (TextView) view.findViewById(R.id.durationTextField);
                            TextView descriptionTextView = (TextView) view.findViewById(R.id.descriptionTextField);
                            ImageView checkBoxImageView = (ImageView) view.findViewById(R.id.checkBoxImageView);
                            if(selectedList.get(position)==false){
                                checkBoxImageView.setImageResource(R.drawable.checkboxicon);
                                selectedList.set(position,true);
                            }else{
                                checkBoxImageView.setImageResource(R.drawable.checkbox_empty);
                                selectedList.set(position,false);
                            }

                        }
                    });

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
    }
}
