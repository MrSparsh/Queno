package com.example.prashanjeet.firebase;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class BussinessListAdapter extends ArrayAdapter<SubService> implements View.OnClickListener{
    private Activity context;
    private List<SubService> servList;
    public BussinessListAdapter(Activity context, List<SubService> adminArrayList) {
        super(context,R.layout.activity_business_list,adminArrayList);
        this.context=context;
        this.servList = adminArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){

        }
        LayoutInflater myCustomInflater = LayoutInflater.from(getContext());
        convertView = myCustomInflater.inflate(R.layout.activity_business_list, parent, false);
        TextView textView = (TextView) convertView.findViewById(R.id.textViewBusinessList);

        SubService appo = servList.get(position);
        textView.setText(appo.getName());
        return convertView;
    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        SubService subService = (SubService) object;
    }

    private static class ViewHolder {
        TextView subject_name;
        TextView time;
        TextView venue_name;
    }

}
