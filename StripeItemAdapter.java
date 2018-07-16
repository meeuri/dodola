package com.example.eery.dodola;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StripeItemAdapter extends RecyclerView.Adapter<StripeItemAdapter.StripeItemViewHolder>
{
    List<Integer> mData = new ArrayList<>();

    public StripeItemAdapter(List<Integer> data){
        if (data == null){
            mData.add(0);
        }
        else{
            mData = data;
        }
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
        return mData.size();
    }

    public void setData(List<Integer> data){
        mData = data;
    }

    @Override
    public void onBindViewHolder(@NonNull StripeItemViewHolder stripeItemViewHolder, int i) {
        stripeItemViewHolder.mDateView.setText(String.valueOf(mData.get(i)));
    }

    public class StripeItemViewHolder extends RecyclerView.ViewHolder{

        public TextView mDateView;

        public StripeItemViewHolder(@NonNull View itemView) {
            super(itemView);
            mDateView = itemView.findViewById(R.id.dateView);
        }

    }

}
