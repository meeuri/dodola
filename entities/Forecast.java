package com.example.eery.dodola.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Forecast {
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

    public List<Day> getData(){

        return daily.getData();
    }

    public class Daily {

        @SerializedName("summary")
        @Expose
        private String summary;
        @SerializedName("data")
        @Expose
        private List<Day> data = null;

        public List<Day> getData() {

            return data;
        }
    }

}