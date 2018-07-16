package com.example.eery.dodola;

import com.example.eery.dodola.entities.Forecast;

import java.io.IOException;

public class Model implements IStripeContract.Model {

    ForecastMapper mMapper;
    RetrofitHelper mHelper;

    public Model(){
        init();
    }

    private void init(){
        mHelper = new RetrofitHelper();
        mMapper = new ForecastMapper(mHelper);
    }

    @Override
    public Forecast getWeekData() {

        Forecast forecast = null;

        try {
            forecast = mMapper.getDataAsync(1,1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return forecast;
    }
}
