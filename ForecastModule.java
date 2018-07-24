package com.example.eery.dodola;

import android.support.annotation.NonNull;

import com.example.eery.dodola.presentation.stripe.IStripeContract;
import com.example.eery.dodola.presentation.stripe.StripeActivity;
import com.example.eery.dodola.presentation.stripe.StripePresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ForecastModule {

    @Provides
    public IStripeContract.Presenter provideStripePresenter(){
        return new StripePresenter();
    }
}
