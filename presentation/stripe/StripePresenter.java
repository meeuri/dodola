package com.example.eery.dodola.presentation.stripe;

import android.os.AsyncTask;
import android.util.Log;

import com.example.eery.dodola.App;
import com.example.eery.dodola.DaggerAppComponent;
import com.example.eery.dodola.data.repositories.ForecastRepository;
import com.example.eery.dodola.domain.ForecastInteractor;
import com.example.eery.dodola.entities.Forecast;

import javax.inject.Inject;

public class StripePresenter implements IStripeContract.Presenter
{
    private static final String TAG = "StripePresenterStory";

    private IStripeContract.View mStripeView;

    @Inject
    public ForecastInteractor mInteractor;

    public StripePresenter(IStripeContract.View stripeView) {
        mStripeView = stripeView;
        init();
    }

    private void init(){
        App.getComponent().inject(this);
    }

    @Override
    public void onItemClick() {
    }

    @Override
    public void onStripeViewCreate() {
        Log.d(TAG, "onViewCreate()");
        RequestWeekForecast task = new RequestWeekForecast();
        task.execute();
    }

    @Override
    public void onStripeViewDestroy() {

    }

    @Override
    public void onDataUpdated() {
        Log.d(TAG, "onDataUpdated()");
        mStripeView.stopRefresh();
        mStripeView.showStripe();

    }

    @Override
    public void onPullRefresh() {
        Log.d(TAG, "onPullRefresh()");
        RequestWeekForecast task = new RequestWeekForecast();
        task.execute();
    }

    // получение прогноза не неделю
    private class RequestWeekForecast extends AsyncTask<Void, Void, Forecast>{

        @Override
        protected void onPreExecute() {
            mStripeView.hideStripe();
        }

        @Override
        protected Forecast doInBackground(Void... voids) {
            return mInteractor.getWeekForecast();
        }

        @Override
        protected void onPostExecute(Forecast forecast) {

            mStripeView.updateData(forecast);

        }
    }

}
