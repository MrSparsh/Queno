package com.example.prashanjeet.firebase;

/**
 * Created by prajjwal-ubuntu on 27/1/19.
 */

public class QueueDataModel {
    String time, name;
    QueueDataModel(){

    }
    QueueDataModel(String time,String name){
        this.name=name;
        this.time=time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
