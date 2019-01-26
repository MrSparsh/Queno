package com.example.prashanjeet.firebase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prajjwal-ubuntu on 27/1/19.
 */

public class CustomQ {
    int start, end;
    int time;
    public ArrayList<User> list;

    CustomQ(){
        this.list =new ArrayList<User>();
//        list.add(new ArrayList<Integer>());

        //List<Integer> list1 = new ArrayList<Integer>();
        User u =new User("none");
        for(int i=0;i<=42;i++){
            list.add(u);
        }
    }

    CustomQ(int start,int end,int time){
        this.start=start;
        this.end=end;
        this.time=time;
        this.list =new ArrayList<User>();
        User u =new User("none");
        for(int i=0;i<=42;i++){
            list.add(u);
        }
    }

    public void reset(int end, int time){
        start=0;
        this.end=end;
        this.time= time;
        this.list.clear();

        User u =new User("none");
        for(int i=0;i<=42;i++){
            list.add(u);
        }
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
