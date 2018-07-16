package com.example.eery.dodola;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class StripePresenter implements IStripeContract.Presenter
{
    private static final String TAG = "StripePresenterStory";

    private IStripeContract.View mStripeView;

    // тестовый список
    List<Integer> testData = new ArrayList<Integer>();

    public StripePresenter(IStripeContract.View stripeView){
        mStripeView = stripeView;
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
    }

}
