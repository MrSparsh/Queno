package com.example.prashanjeet.firebase;

/**
 * Created by prajjwal-ubuntu on 26/1/19.
 */

public class SubService {
    boolean isOn;
    String name, counters, startTime, handlingTime, details, lati, longi, id;

    public SubService(){

    }

    public SubService(String name, String counters, String startTime, String handlingTime, String details,String lati, String longi,String id) {
        this.name = name;
        this.counters = counters;
        this.startTime = startTime;
        this.handlingTime = handlingTime;
        this.details = details;
        this.isOn = false;
        this.lati=lati;
        this.longi=longi;
        this.id=id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLati() {
        return lati;
    }

    public void setLati(String lati) {
        this.lati = lati;
    }

    public String getLongi() {
        return longi;
    }

    public void setLongi(String longi) {
        this.longi = longi;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCounters() {
        return counters;
    }

    public void setCounters(String counters) {
        this.counters = counters;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getHandlingTime() {
        return handlingTime;
    }

    public void setHandlingTime(String handlingTime) {
        this.handlingTime = handlingTime;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
