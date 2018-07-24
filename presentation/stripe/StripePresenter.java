package com.example.eery.dodola.presentation.stripe;

import android.os.AsyncTask;
import android.util.Log;

import com.example.eery.dodola.data.repositories.ForecastRepository;
import com.example.eery.dodola.domain.ForecastInteractor;
import com.example.eery.dodola.entities.Forecast;

import javax.inject.Inject;

public class StripePresenter implements IStripeContract.Presenter
{
    private static final String TAG = "StripePresenterStory";

    private IStripeContract.View mStripeView;
    private ForecastInteractor mInteractor;

    public StripePresenter(){
        //тест Dagger2
        //mStripeView = stripeView;
    }

    public void attachView(IStripeContract.View view){
        this.mStripeView = view;
        initLayers();
    }

    private  void initLayers(){
        // предполагается, что здесь не должно быть прямой связи с репозиторием
        mInteractor = new ForecastInteractor(new ForecastRepository());
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
