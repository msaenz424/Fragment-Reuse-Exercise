package com.migcavero.fragmentsanim;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class DroidsAdapter extends RecyclerView.Adapter<DroidsAdapter.CardAdapterViewHolder> {

    List<Integer> mDroisList = new ArrayList<>();

    public DroidsAdapter(List<Integer> mDroisList) {
        this.mDroisList = mDroisList;
    }

    @Override
    public CardAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_recycler_view, parent, false);

        return new CardAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CardAdapterViewHolder holder, int position) {
        holder.mDroidImageView.setImageResource(mDroisList.get(position));
    }

    @Override
    public int getItemCount() {
        if (mDroisList != null){
            return mDroisList.size();
        }
        return 0;
    }

    public class CardAdapterViewHolder extends RecyclerView.ViewHolder {

        ImageView mDroidImageView;

        public CardAdapterViewHolder(View itemView) {
            super(itemView);
            mDroidImageView = itemView.findViewById(R.id.droid_image_view);
        }
    }
}
