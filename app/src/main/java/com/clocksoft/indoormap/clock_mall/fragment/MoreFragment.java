package com.clocksoft.indoormap.clock_mall.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.clocksoft.indoormap.clock_mall.R;



public class MoreFragment extends Fragment {
    public MoreFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more, container, false);
        TextView textView = (TextView) view.findViewById(R.id.moreText);
        Typeface face = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/roboto_bold.ttf");
        textView.setTypeface(face);

        RelativeLayout relativeLayout = (RelativeLayout)view.findViewById(R.id.mallInfo);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           //     Intent myIntent = new Intent(getActivity(), MallInfoActivity.class);
             //   startActivity(myIntent);
            }
        });
        return view;
    }
}