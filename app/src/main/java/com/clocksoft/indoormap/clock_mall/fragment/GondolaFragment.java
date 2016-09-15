package com.clocksoft.indoormap.clock_mall.fragment;


import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.clocksoft.indoormap.clock_mall.R;



public class GondolaFragment extends Fragment {
    WebView webview;
    ProgressBar pbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gondola, container, false);
        TextView textView = (TextView) view.findViewById(R.id.GondolaText);
        Typeface face = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/roboto_bold.ttf");
        textView.setTypeface(face);
        webview = (WebView)view.findViewById(R.id.webView1);
        pbar = (ProgressBar)view.findViewById(R.id.progressBar1);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("http://192.168.1.149/clock_gandola/booknow");
        return view;
    }
    public class WebViewClient extends android.webkit.WebViewClient
    {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {

            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            // TODO Auto-generated method stub
            view.loadUrl(url);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {

            // TODO Auto-generated method stub

            super.onPageFinished(view, url);
            pbar.setVisibility(View.GONE);

        }

    }


}