package com.example.eery.dodola;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

public class StripeActivity extends AppCompatActivity implements IStripeContract.View {

    private static final String TAG = "StripeActivityStory";
    private IStripeContract.Presenter mStripePresenter;

    private RecyclerView mStripeRecyclerView;
    private StripeItemAdapter mStripeAdapter;
    private LinearLayoutManager mStripeManager;
    private Model mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stripe);
        initLayers();
        initStripe();
    }

    private void initLayers() {
        mModel = new Model();
        mStripePresenter = new StripePresenter(this, mModel);
    }


    private void initStripe(){

        mStripeRecyclerView = findViewById(R.id.stripe);
        mStripeManager = new LinearLayoutManager(
                    this,
                    LinearLayoutManager.VERTICAL,
                    false);
        mStripeAdapter = new StripeItemAdapter(null);
        mStripeRecyclerView.setLayoutManager(mStripeManager);
        mStripeRecyclerView.setAdapter(mStripeAdapter);

        mStripePresenter.onStripeViewCreate();

    }

    @Override
    public void updateData(List<Integer> data) {
        mStripeAdapter.setData(data);
        mStripeAdapter.notifyDataSetChanged();
    }

    @Override
    public void showDetails() {

    }
}
