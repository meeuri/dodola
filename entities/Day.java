package com.example.eery.dodola.entities;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Day implements Serializable {
    private final static String TAG = "DataItemStory";

    @SerializedName("temperatureHigh")
    @Expose
    private double temperatureHigh;

    @SerializedName("temperatureLow")
    @Expose
    private double temperatureLow;

    public Day( ){

    }

    public Day(double temperatureLow, double temperatureHigh){
        this.temperatureHigh = temperatureHigh;
        this.temperatureLow = temperatureLow;
        Log.d(TAG, "DataItem() temp_high: " + temperatureHigh + " DataItem() temp_low: " + temperatureLow);
    }

    public double getTemperatureHigh() {
        return temperatureHigh;
    }

    public double getTemperatureLow() {
        return temperatureLow;
    }
}