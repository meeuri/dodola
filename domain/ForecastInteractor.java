package com.example.eery.dodola.domain;

import com.example.eery.dodola.data.repositories.IForecastRepository;
import com.example.eery.dodola.entities.Forecast;

import javax.inject.Inject;

public class ForecastInteractor implements IForecastInteractor {

    IForecastRepository mRepository;

    public ForecastInteractor(IForecastRepository repository){
        mRepository = repository;
    }

    @Override
    public Forecast getWeekForecast() {
        return mRepository.getForecast();
    }
}
