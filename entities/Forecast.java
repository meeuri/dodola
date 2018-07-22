package com.example.eery.dodola.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Forecast implements Serializable{
    private static final String TAG = "ForecastStory";
    private double longitude;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("daily")
    @Expose
    private Daily daily;

    public String getTimezone() {

        return timezone;
    }

    public List<Day> getDays(){

        return daily.getDays();
    }

    public class Daily implements Serializable{

        @SerializedName("summary")
        @Expose
        private String summary;
        @SerializedName("data")
        @Expose
        private List<Day> days = null;

        public List<Day> getDays() {
            return days;
        }
    }

}