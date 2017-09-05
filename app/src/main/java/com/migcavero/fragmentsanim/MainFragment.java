package com.migcavero.fragmentsanim;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment {

    private static final int NUM_COLS = 3;

    View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);

        RecyclerView mMainRecyclerView = rootView.findViewById(R.id.main_recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(rootView.getContext(), NUM_COLS, LinearLayoutManager.VERTICAL, false);
        mMainRecyclerView.setLayoutManager(gridLayoutManager);

        DroidsAdapter mDroidsAdapter = new DroidsAdapter(AndroidImageAssets.getHeads());
        mMainRecyclerView.setAdapter(mDroidsAdapter);

        return rootView;
    }
}
