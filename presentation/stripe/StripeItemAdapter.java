package com.example.eery.dodola.presentation.stripe;

import android.content.Context;
import android.content.res.Resources;
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
        String date = Vessel.convertDate(day.getTime(), StripeActivity.DATE_FORMAT);
        stripeItemViewHolder.mDateView.setText(date);

        Resources resources = mContext.getResources();

        int iconImageId = resources.getIdentifier(Vessel.convertIconName(day.getIconName()),
                            "drawable",
                            mContext.getPackageName());

        Log.d("ICON", iconImageId + " " + day.getIconName());

        stripeItemViewHolder.mIconView.setImageResource(iconImageId);

        String temp = String.valueOf((int)day.getTempLow()) + StripeActivity.TEMP_SEPARATOR
                + String.valueOf((int)day.getTempHigh());

        stripeItemViewHolder.mTempView.setText(temp);

        int degreeImageId = resources.getIdentifier(
                            StripeActivity.DEGREE_ICON_NAME,
                            "drawable",
                            mContext.getPackageName());

        stripeItemViewHolder.mDegreeView.setImageResource(degreeImageId);



    }

    public class StripeItemViewHolder extends RecyclerView.ViewHolder{

        public TextView mDateView;
        public TextView mTempView;
        public ImageView mIconView;
        public ImageView mDegreeView;

        public StripeItemViewHolder(@NonNull View itemView) {
            super(itemView);
            mDateView = itemView.findViewById(R.id.dateView);
            mIconView = itemView.findViewById(R.id.iconView);
            mTempView = itemView.findViewById(R.id.tempView);
            mDegreeView = itemView.findViewById(R.id.degreeView);
        }

    }

}
