package com.example.eery.dodola;

import android.support.annotation.NonNull;

import com.example.eery.dodola.data.repositories.ForecastRepository;
import com.example.eery.dodola.data.sources.ForecastMapper;
import com.example.eery.dodola.data.sources.RetrofitHelper;
import com.example.eery.dodola.domain.ForecastInteractor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Singleton
@Module
public class ForecastModule {

    @Singleton
    @Provides
    public ForecastInteractor provideForecastInteractor(ForecastRepository forecastRepository){
        return new ForecastInteractor(forecastRepository);
    }

    @Singleton
    @Provides
    public ForecastRepository provideForecastRepository(ForecastMapper forecastMapper){
        return new ForecastRepository(forecastMapper);
    }

    @Singleton
    @Provides
    public ForecastMapper provideForecastMapper(RetrofitHelper retrofitHelper){
        return new ForecastMapper(retrofitHelper);
    }

    @Singleton
    @Provides
    public RetrofitHelper provideRetrofitHelper(){
        return new RetrofitHelper();
    }

}
