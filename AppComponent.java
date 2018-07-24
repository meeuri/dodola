package com.example.eery.dodola;

import com.example.eery.dodola.presentation.stripe.IStripeContract;
import com.example.eery.dodola.presentation.stripe.StripeActivity;

import dagger.Component;

@Component(modules = ForecastModule.class)
public interface AppComponent {

    //IStripeContract.Presenter getStripePresenter();

    void injectStripeActivity(StripeActivity stripeActivity);
}
