package com.example.eery.dodola.data.sources;

import android.util.Log;

import com.example.eery.dodola.entities.Forecast;

import java.io.IOException;

import retrofit2.Response;

public class ForecastMapper {
    private RetrofitHelper mHelper;
    private final String TAG = "ForecastMapperStory";

    public ForecastMapper(RetrofitHelper helper){
        mHelper = helper;
    }

    public Forecast getDataSync(double lat, double lon) throws IOException {
        String lang = "ru",
                exclude = "currently",
                //  exclude = "currently,minutely,hourly,alerts,flags",
                units = "si";

        Response<Forecast> response = mHelper.getService()
                    .getForecast( lat, lon, lang, exclude, units)
                    .execute();
        Log.d(TAG, response.toString() +  " " + response.body().getTimezone());
        return response.body();
    }

}
