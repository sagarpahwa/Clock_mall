package com.clocksoft.indoormap.clock_mall.fragment;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import com.clocksoft.indoormap.clock_mall.R;


import java.util.ArrayList;
import java.util.List;

public class DirectoryFragment extends Fragment {
    private TabLayout tabLayout = null;
    private ViewPager viewPager = null;
    private  View view;
    Adapter adapter;
    public DirectoryFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_directory, container, false);
        TextView textView = (TextView) view.findViewById(R.id.DirectoryText);
        Typeface face = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/roboto_bold.ttf");
        textView.setTypeface(face);

        viewPager = (ViewPager)view.findViewById(R.id.my_viewpager_directory);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) view.findViewById(R.id.my_tab_layout_directory);
        tabLayout.setupWithViewPager(viewPager);
        //setEvents();
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageSelected(int position){
                DirFragmentInterface fragment = (DirFragmentInterface) adapter.instantiateItem(viewPager, position);
                if (fragment != null) {
                    fragment.fragmentBecameVisible();
                }

                viewPager.setCurrentItem(position);

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2){
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
        viewPager.setCurrentItem(0);

        return view;
    }
    private void setupViewPager(ViewPager viewPager) {


        adapter = new Adapter(getChildFragmentManager());
        adapter.addFragment(new DirectoryFragmentList(), "List");
        adapter.addFragment(new DirectoryFragmentMap(), "Map");
        viewPager.setAdapter(adapter);
    }
    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
    public interface DirFragmentInterface {
        void fragmentBecameVisible();
    }
}