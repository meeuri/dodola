package com.example.eery.dodola.presentation.stripe;

import com.example.eery.dodola.entities.Forecast;

public interface IStripeContract {
    interface View {
        void updateData(Forecast forecast);
        // показать детализацию
        void showDepth();
        void showProgressBar();
        void hideProgressBar();
        void showStripe();
        void hideStripe();
    }

    interface Presenter {
        void onItemClick();
        void onStripeViewCreate();
        void onStripeViewDestroy();
    }

}
