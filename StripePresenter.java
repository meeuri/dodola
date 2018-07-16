package com.example.eery.dodola;

import android.util.Log;

import com.example.eery.dodola.entities.Forecast;

import java.util.ArrayList;
import java.util.List;

public class StripePresenter implements IStripeContract.Presenter
{
    private static final String TAG = "StripePresenterStory";

    private IStripeContract.View mStripeView;
    private IStripeContract.Model mModel;

    // тестовый список
    List<Integer> testData = new ArrayList<Integer>();

    public StripePresenter(IStripeContract.View stripeView, IStripeContract.Model model){
        mStripeView = stripeView;
        mModel = model;
    }

    @Override
    public void onItemClick() {

    }

    @Override
    public void onStripeViewCreate() {
        Log.d(TAG, "onViewCreate()");
        // тестовые данные
        testData.add(1); testData.add(3);

        mStripeView.updateData(testData);

        Forecast forecast = mModel.getWeekData();
        int i = 1;
    }

}
