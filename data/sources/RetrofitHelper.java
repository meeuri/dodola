package com.example.eery.dodola.data.sources;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    private static final String TAG = "RetrofitHelperStory";
    private static String KEY = "/afc53e19fa3c002b9f8bb5a5ad6298a5/";
    private static String BASE_URL = "https://api.darksky.net/forecast";

    public IForecastService getService(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL + KEY)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.d(TAG, retrofit.baseUrl().toString());

        return retrofit.create(IForecastService.class);
    }

}