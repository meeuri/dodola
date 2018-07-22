package com.example.eery.dodola.entities;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Day implements Serializable {
    private final static String TAG = "DayStory";

    @SerializedName("temperatureHigh")
    @Expose
    private double tempHigh;

    @SerializedName("temperatureLow")
    @Expose
    private double tempLow;

    @SerializedName("time")
    @Expose
    private long time;

    @SerializedName("icon")
    @Expose
    private String iconName;

    public Day(){
        return;
    }

    public Day(double temperatureLow,
               double temperatureHigh,
               long time,
               String iconName){
        this.tempHigh = temperatureHigh;
        this.tempLow = temperatureLow;
        this.time = time;
        this.iconName = iconName;

        Log.d(TAG, "time: " + time);
    }

    public String getIconName(){
        return  iconName;
    }

    public void setIconName(String iconName){
        this.iconName = iconName;
    }

    public long getTime(){
        return time;
    }

    public double getTempHigh() {
        return tempHigh;
    }

    public double getTempLow() {
        return tempLow;
    }


}