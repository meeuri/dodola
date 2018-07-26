package com.example.eery.dodola;

import com.example.eery.dodola.domain.ForecastInteractor;
import com.example.eery.dodola.presentation.stripe.IStripeContract;
import com.example.eery.dodola.presentation.stripe.StripeActivity;
import com.example.eery.dodola.presentation.stripe.StripePresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ForecastModule.class)
public interface AppComponent {

    void inject(StripePresenter stripePresenter);

}
