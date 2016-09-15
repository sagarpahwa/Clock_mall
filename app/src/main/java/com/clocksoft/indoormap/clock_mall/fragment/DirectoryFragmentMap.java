package com.clocksoft.indoormap.clock_mall.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.clocksoft.indoormap.clock_mall.R;


@SuppressLint("ValidFragment")
public class DirectoryFragmentMap extends Fragment implements DirectoryFragment.DirFragmentInterface{

    public DirectoryFragmentMap(){}
    private int position = 0;
    @SuppressLint("ValidFragment")
    public DirectoryFragmentMap(int position) {
        this.position = position;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_directory_map, container, false);

        return view;
    }

    @Override
    public void fragmentBecameVisible() {

    }
}