package com.example.prashanjeet.firebase;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BussinessListAdapter extends ArrayAdapter<SubService>{
    public BussinessListAdapter(@NonNull Context context, ArrayList<SubService> adminArrayList) {
        super(context,R.layout.queue_list_row,adminArrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater myCustomInflater = LayoutInflater.from(getContext());
        View customView = myCustomInflater.inflate(R.layout.queue_list_row, parent, false);
        TextView textView = (TextView) customView.findViewById(R.id.textView);
        textView.setText("Hello");
        return customView;
    }
}