package com.example.prashanjeet.firebase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class QueueListAdapter extends ArrayAdapter<QueueDataModel>{
    public QueueListAdapter(@NonNull Context context, QueueDataModel queueDataModel[]) {
        super(context,R.layout.queue_list_row,queueDataModel);
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
