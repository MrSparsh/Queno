package com.example.prashanjeet.firebase;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class AddServiceAdmin extends AppCompatActivity {

    String [] nameOfService = {};
    Button addServiceButon ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service_admin);

        ListView listView = (ListView) findViewById(R.id.list);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        addServiceButon = (Button)findViewById(R.id.addServiceButton1);
        addServiceButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent  = new  Intent(AddServiceAdmin.this, ServiceInfoActivity.class);
                startActivity(intent);
            }
        });

    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return nameOfService.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            view = getLayoutInflater().inflate(R.layout.customlist,null);
            TextView tv = (TextView)view.findViewById(R.id.serviceText);
            tv.setText(nameOfService[i]);
            return null;

        }
    }

}
