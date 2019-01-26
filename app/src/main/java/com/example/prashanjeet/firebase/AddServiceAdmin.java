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
    Button addServiceButton ;
    String username = "Nitish Kumar Khatri";
    String email = "nitishkhatri161@gmail.com";
    String mobile = "7884955626";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service_admin);

        ListView listView = (ListView) findViewById(R.id.list);
        addServiceButton = (Button)findViewById(R.id.addServiceButton);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

        addServiceButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddServiceAdmin.this,ServiceInfoActivity.class);
                intent.putExtra("Name",username);
                intent.putExtra("Email",email);
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
