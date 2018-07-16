package com.example.eery.dodola;

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
        void getWeekData();
        void getDailyData();
    }
}
