package com.example.eery.dodola.presentation.stripe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.eery.dodola.R;
import com.example.eery.dodola.entities.Forecast;

public class StripeActivity extends AppCompatActivity implements IStripeContract.View {

    private static final String TAG = "StripeActivityStory";
    private IStripeContract.Presenter mStripePresenter;

    private ProgressBar mProgressBar;
    private RecyclerView mStripeRecyclerView;
    private StripeItemAdapter mStripeAdapter;
    private LinearLayoutManager mStripeManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stripe);
        initPresenter();
    }

    private void init(){
        initStripe();
        init();
        mProgressBar = findViewById(R.id.progressBar);
    }

    private void initPresenter() {
        mStripePresenter = new StripePresenter(this);
    }


    private void initStripe(){
        mStripeRecyclerView = findViewById(R.id.stripe);
        mStripeManager = new LinearLayoutManager(
                    this,
                    LinearLayoutManager.VERTICAL,
                    false);
        mStripeAdapter = new StripeItemAdapter(null, this);
        mStripeRecyclerView.setLayoutManager(mStripeManager);
        mStripeRecyclerView.setAdapter(mStripeAdapter);

        mStripePresenter.onStripeViewCreate();
    }

    @Override
    public void updateData(Forecast forecast) {
        mStripeAdapter.setData(forecast);
        mStripeAdapter.notifyDataSetChanged();
    }

    @Override
    public void showDepth() {

    }

    @Override
    public void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showStripe() {
        mStripeRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideStripe() {
        mStripeRecyclerView.setVisibility(View.INVISIBLE);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mStripePresenter.onStripeViewDestroy();
    }
}
