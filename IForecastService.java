package com.example.eery.dodola;

import com.example.eery.dodola.entities.Forecast;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IForecastService {

    @GET("{latitude},{longitude}")
    Call<Forecast> getForecast(@Path("latitude") double lat,
                               @Path("longitude") double lon,
                               @Query("lang") String lang,
                               @Query("exclude") String exclude,
                               @Query("units") String units);

}
