package com.example.eery.dodola.data.repositories;

import com.example.eery.dodola.Vessel;
import com.example.eery.dodola.data.sources.ForecastMapper;
import com.example.eery.dodola.data.sources.RetrofitHelper;
import com.example.eery.dodola.entities.Day;
import com.example.eery.dodola.entities.Forecast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ForecastRepository implements IForecastRepository {
    public static final String TAG = "ForecastRepositoryStory";

    // предполагается получать координаты в этом же репозитории из SharedPreference
    private static final float TST_LAT = (float) 55.7558;
    private static final float TST_LON = (float) 37.6173;

    private ForecastMapper mMapper;

    public ForecastRepository(ForecastMapper mapper){
        mMapper = mapper;
    }


    // получить прогноз на неделю
    @Override
    public Forecast getForecast() {
        Forecast forecast = null;
        try {
            forecast =  mMapper.getDataSync(TST_LAT, TST_LON);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return forecast;
    }


}
