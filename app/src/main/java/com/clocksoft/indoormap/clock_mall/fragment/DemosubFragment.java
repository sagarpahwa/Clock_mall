package com.clocksoft.indoormap.clock_mall.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.clocksoft.indoormap.clock_mall.R;


@SuppressLint("ValidFragment")
public class DemosubFragment extends Fragment {
    public DemosubFragment(){}
    private int position = 0;
    @SuppressLint("ValidFragment")
    public DemosubFragment(int position) {
        this.position = position;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.subfragment_leave, container, false);
        return view;
    }
}