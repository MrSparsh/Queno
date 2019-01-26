package com.example.prashanjeet.firebase;

/**
 * Created by prajjwal-ubuntu on 26/1/19.
 */

public class SubService {
    boolean isOn;
    String name, counters, startTime, handlingTime, details;

    public SubService(String name, String counters, String startTime, String handlingTime, String details) {
        this.name = name;
        this.counters = counters;
        this.startTime = startTime;
        this.handlingTime = handlingTime;
        this.details = details;
        this.isOn = false;
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
