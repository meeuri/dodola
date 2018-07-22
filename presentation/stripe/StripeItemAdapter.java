package com.example.eery.dodola.presentation.stripe;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eery.dodola.R;
import com.example.eery.dodola.Vessel;
import com.example.eery.dodola.entities.Day;
import com.example.eery.dodola.entities.Forecast;

import java.util.List;

public class StripeItemAdapter extends RecyclerView.Adapter<StripeItemAdapter.StripeItemViewHolder>
{
    Forecast mForecast;
    Context mContext;

    public StripeItemAdapter(Forecast forecast,
                             Context context){
        mForecast = forecast;
        mContext = context;
    }

    @NonNull
    @Override
    public StripeItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view = LayoutInflater.from(viewGroup.getContext())
               .inflate(R.layout.stripe_item, viewGroup, false);
        return new StripeItemViewHolder(view);
    }

    @Override
    public int getItemCount() {
        if (mForecast != null) {
            return mForecast.getDays().size();
        }
        else {
            return 0;
        }
    }

    public void setData(Forecast forecast){
        mForecast = forecast;
    }

    @Override
    public void onBindViewHolder(@NonNull StripeItemViewHolder stripeItemViewHolder, int i) {
        Day day = mForecast.getDays().get(i);
        String date = Vessel.getDate(day.getTime(), "dd/MM");
        stripeItemViewHolder.mDateView.setText(date);

        int imageId = mContext.getResources()
                    .getIdentifier(Vessel.convertIconName(day.getIconName()),
                            "drawable",
                            mContext.getPackageName());

        Log.d("ICON", imageId + " " + day.getIconName());

        stripeItemViewHolder.mIconView.setImageResource(imageId);

        stripeItemViewHolder.mLowTempView.setText(String.valueOf((int)day.getTempLow()));
        stripeItemViewHolder.mHighTempView.setText(String.valueOf((int)day.getTempHigh()));

    }

    public class StripeItemViewHolder extends RecyclerView.ViewHolder{

        public TextView mDateView;
        public TextView mHighTempView;
        public TextView mLowTempView;
        public ImageView mIconView;

        public StripeItemViewHolder(@NonNull View itemView) {
            super(itemView);
            mDateView = itemView.findViewById(R.id.dateView);
            mIconView = itemView.findViewById(R.id.iconView);
            mHighTempView = itemView.findViewById(R.id.highTempView);
            mLowTempView = itemView.findViewById(R.id.lowTempView);
        }

    }

}
