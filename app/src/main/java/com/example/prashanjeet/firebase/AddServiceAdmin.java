package com.example.prashanjeet.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class AddServiceAdmin extends AppCompatActivity {

    String [] nameOfService = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service_admin);

        ListView listView = (ListView) findViewById(R.id.list);
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
            return null;
        }
    }

}
