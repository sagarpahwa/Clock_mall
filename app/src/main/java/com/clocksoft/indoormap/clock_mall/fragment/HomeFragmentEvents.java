package com.clocksoft.indoormap.clock_mall.fragment;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.clocksoft.indoormap.clock_mall.R;
import com.clocksoft.indoormap.clock_mall.adapter.CustomListAdapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;


public class HomeFragmentEvents extends Fragment implements HomeFragment.FragmentInterface {
    private static final String url = "jdbc:mysql://192.168.1.149:3306/clock_mall";
    private boolean _hasLoadedOnce= false;
    private ListView mListView;
    ResultSet rs = null;
    private CustomListAdapter adapter;
    ProgressDialog prgsDlg;
    SwipeRefreshLayout swipeRefreshLayout;
    private ArrayList<String> listname = new ArrayList<String>();
    private ArrayList<String> listadd = new ArrayList<String>();
    private ArrayList<String> listphone = new ArrayList<String>();
    public HomeFragmentEvents(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_events, container, false);
        mListView = (ListView) view.findViewById(R.id.HomeEventList);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.events_swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                new Fetch().execute();
            }
        });

        new Fetch().execute();
        return view;
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(true);
        if (this.isVisible()) {
            Log.e("Offers","visible");
            // we check that the fragment is becoming visible
            if (isVisibleToUser && !_hasLoadedOnce) {
                new Fetch().execute();
                _hasLoadedOnce = true;
            }
        }
    }
    @Override
    public void fragmentBecameVisible() {

    }

    class Fetch extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            Log.e("kya hua??","pre");
            super.onPreExecute();
            swipeRefreshLayout.setRefreshing(true);
            /*prgsDlg=new ProgressDialog(getActivity());
            prgsDlg.setProgressStyle(prgsDlg.STYLE_HORIZONTAL);
            prgsDlg.setIndeterminate(true);
            prgsDlg.setMessage("Connexion au serveur MySQL ...");
            prgsDlg.show();*/
        }

        @Override
        protected String doInBackground(String... strings) {

            try {
                Class.forName("com.mysql.jdbc.Driver");

                Connection con = (Connection) DriverManager.getConnection(
                        url, "clock", "@indian"); // nom utilisateur ="root" mot de
                // passe =

                Statement st = (Statement) con.createStatement();
                Log.e("kya hua2222??",con.toString());
                rs = (ResultSet) st.executeQuery("SELECT str_name,str_add,str_phone from store_details"/*SELECT mall_details.*,states.state_name FROM mall_details left join states on states.id=mall_details.mall_state"*/);
                ResultSetMetaData rsmd = (ResultSetMetaData) rs
                        .getMetaData();
                Log.e("kya hua3333333333??",rs.toString());
                listname.clear();
                listadd.clear();
                listphone.clear();
            /*    while (rs.next()) {
                    listname.add(rs.getString(1));
                    listadd.add(rs.getString(2));
                    listphone.add(rs.getString(3));

                }*/
            } catch (Exception e) {
                e.printStackTrace();

            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            adapter = new CustomListAdapter(1,getActivity(),listname,listadd,listphone,2);
            mListView.setAdapter(adapter);
            swipeRefreshLayout.setRefreshing(false);
            //prgsDlg.dismiss();
        }
    }
}