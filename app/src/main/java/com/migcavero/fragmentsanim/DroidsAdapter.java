package com.migcavero.fragmentsanim;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

class DroidsAdapter extends RecyclerView.Adapter<DroidsAdapter.CardAdapterViewHolder> {

    private OnClickCallback mOnClickCallback;
    private List<Integer> mDroidsList = new ArrayList<>();

    DroidsAdapter(Context onClickCallback, List<Integer> mDroisList) {
        this.mOnClickCallback = (OnClickCallback) onClickCallback;
        this.mDroidsList = mDroisList;
    }

    @Override
    public CardAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_recycler_view, parent, false);

        return new CardAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CardAdapterViewHolder holder, int position) {
        holder.mDroidImageView.setImageResource(mDroidsList.get(position));
    }

    @Override
    public int getItemCount() {
        if (mDroidsList != null){
            return mDroidsList.size();
        }
        return 0;
    }

    class CardAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView mDroidImageView;

        CardAdapterViewHolder(View itemView) {
            super(itemView);
            mDroidImageView = itemView.findViewById(R.id.droid_image_view);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int id = mDroidsList.get(getAdapterPosition());
            mOnClickCallback.OnClick(id);
        }
    }

    interface OnClickCallback{
        void OnClick(int id);
    }

}
