package com.example.prashanjeet.firebase;


import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BussinessListAdapter extends ArrayAdapter<SubService>{
    private Activity context;
    private List<SubService> servList;
    public BussinessListAdapter(Activity context, List<SubService> adminArrayList) {
        super(context,R.layout.activity_business_list,adminArrayList);
        this.context=context;
        this.servList = adminArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater myCustomInflater = LayoutInflater.from(getContext());
        View customView = myCustomInflater.inflate(R.layout.activity_business_list, parent, false);
        TextView textView = (TextView) customView.findViewById(R.id.textViewBusinessList);
        textView.setText("Hello");
        SubService appo = servList.get(position);
        textView.setText(appo.getName());
        return customView;
    }
}
//
//public class AppoArrayList extends ArrayAdapter<Student> {
//
//    private Activity context;
//    private List<Student> appoList;
//
//    public AppoArrayList(Activity context, List<Student> appoList){
//        super(context, R.layout.appointment_list_layout, appoList);
//        this.context=context;
//        this.appoList=appoList;
//
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        LayoutInflater inflater = context.getLayoutInflater();
//        View listViewItem = inflater.inflate(R.layout.appointment_list_layout, null, true);
//
//        TextView textViewTitle = (TextView) listViewItem.findViewById(R.id.textViewTilte);
//        TextView textViewDate = (TextView) listViewItem.findViewById(R.id.textViewDate);
//
//        Student appo = appoList.get(position);
//        textViewTitle.setText(appo.getName());
//        textViewDate.setText(appo.getHostel());
//
//        return listViewItem;
//    }
//}