package com.example.eery.dodola.presentation.stripe;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.eery.dodola.App;
import com.example.eery.dodola.R;
import com.example.eery.dodola.entities.Forecast;

import javax.inject.Inject;

public class StripeActivity extends AppCompatActivity implements IStripeContract.View{

    private static final String TAG = "StripeActivityStory";
    public static final String DATE_FORMAT = "dd/MM";
    // Условный разделитель для значений температору
    public static final String TEMP_SEPARATOR = " ... ";

    @Inject
    protected IStripeContract.Presenter mStripePresenter;



    public static final String DEGREE_ICON_NAME = "ic_degree";

    private RecyclerView mStripeRecyclerView;
    private StripeItemAdapter mStripeAdapter;
    private LinearLayoutManager mStripeManager;


    SwipeRefreshLayout mRefresher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stripe);

        App.getComponent().injectStripeActivity(this);
        mStripePresenter.attachView(this);

        init();
    }

    private void init(){
        initAppComponent();
        initPresenter();
        initStripe();
        initRefresher();
        mStripePresenter.onStripeViewCreate();
    }

    private void initAppComponent() {

    }

    private void initPresenter() {
       // mStripePresenter = new StripePresenter();

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
    }

    private void initRefresher(){
        mRefresher = findViewById(R.id.pullRefresh);
        mRefresher.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.d(TAG, "onRefresh()");
                mStripePresenter.onPullRefresh();
            }
        });
        mRefresher.setRefreshing(true);
    }

    @Override
    public void updateData(Forecast forecast) {
        mStripeAdapter.setData(forecast);
        mStripeAdapter.notifyDataSetChanged();
        mStripePresenter.onDataUpdated();
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
    public void stopRefresh() {
        Log.d(TAG, "stopRefresh()");
        mRefresher.setRefreshing(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mStripePresenter.onStripeViewDestroy();
    }

    @Override
    public void showDepth() {

    }


}
