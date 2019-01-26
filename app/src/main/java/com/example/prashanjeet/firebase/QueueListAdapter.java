package com.example.prashanjeet.firebase;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class QueueListAdapter extends ArrayAdapter<QueueDataModel>{
//    public QueueListAdapter(@NonNull Context context, QueueDataModel queueDataModel[]) {
//        super(context,R.layout.queue_list_row,queueDataModel);
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        LayoutInflater myCustomInflater = LayoutInflater.from(getContext());
//        View customView = myCustomInflater.inflate(R.layout.queue_list_row, parent, false);
//        TextView time= (TextView) customView.findViewById(R.id.timeq);
//        TextView details= (TextView) customView.findViewById(R.id.detailsq);
//        SubService appo = servList.get(position);
//        textView.setText(appo.getName());
//        return convertView;
//        time.setText();
//        return customView;
//    }


    private Activity context;
    private List<QueueDataModel> queueList;
    public QueueListAdapter(Activity context, List<QueueDataModel> qlist) {
        super(context,R.layout.queue_list_row,qlist);
        this.context=context;
        this.queueList = qlist;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){

        }
        LayoutInflater myCustomInflater = LayoutInflater.from(getContext());
        convertView = myCustomInflater.inflate(R.layout.queue_list_row, parent, false);
        //TextView  time = (TextView) convertView.findViewById(R.id.timeq);



        TextView time= (TextView) convertView.findViewById(R.id.timeq);
        TextView details= (TextView) convertView.findViewById(R.id.detailsq);
        QueueDataModel appo = queueList.get(position);
        time.setText(appo.getTime());

        details.setText(appo.getName());
        return convertView;
    }

}
