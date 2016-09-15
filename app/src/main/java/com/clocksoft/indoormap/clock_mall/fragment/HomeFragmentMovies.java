package com.clocksoft.indoormap.clock_mall.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.clocksoft.indoormap.clock_mall.R;


public class HomeFragmentMovies extends Fragment implements HomeFragment.FragmentInterface {
    private boolean _hasLoadedOnce= false;
    SwipeRefreshLayout swipeRefreshLayout;
    public HomeFragmentMovies(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_movies, container, false);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.movies_swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
              //  new Fetch().execute();
            }
        });

        return view;
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(true);
        if (this.isVisible()) {
            Log.e("Offers","visible");
            // we check that the fragment is becoming visible
            if (isVisibleToUser ){//&& !_hasLoadedOnce) {
               // new Fetch().execute();
                _hasLoadedOnce = true;
            }
        }
    }
    @Override
    public void fragmentBecameVisible() {

    }
}