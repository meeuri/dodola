package com.example.eery.dodola.presentation.stripe;

import com.example.eery.dodola.entities.Forecast;

public interface IStripeContract {
    interface View {
        void updateData(Forecast forecast);
        // показать детализацию
        void showDepth();
        void showStripe();
        void hideStripe();
        void stopRefresh();
    }

    interface Presenter {
        void onItemClick();
        void onStripeViewCreate();
        void onStripeViewDestroy();
        void onDataUpdated();
        void onPullRefresh();
        void attachView(IStripeContract.View view);
    }

}
