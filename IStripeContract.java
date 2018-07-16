package com.example.eery.dodola;

import com.example.eery.dodola.entities.Forecast;

import java.util.List;

public interface IStripeContract {
    interface View {
        void updateData(List<Integer> data);
        void showDetails();
    }

    interface Presenter {
        void onItemClick();
        void onStripeViewCreate();
    }

    interface Model{
        Forecast getWeekData();
    }
}
