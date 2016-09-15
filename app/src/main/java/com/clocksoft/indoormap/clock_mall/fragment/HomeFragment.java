package com.clocksoft.indoormap.clock_mall.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Adapter;
import android.widget.TextView;

import com.clocksoft.indoormap.clock_mall.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private TabLayout tabLayout = null;
    private ViewPager viewPager = null;
    Adapter adapter;
    //    private ViewPagerAdapter adapter = null;
    private View view;

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.my_viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) view.findViewById(R.id.my_tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        //setEvents();
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageSelected(int position){
                FragmentInterface fragment = (FragmentInterface) adapter.instantiateItem(viewPager, position);
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
//        setupTabLayout();
        return view;
    }

    private void setupViewPager(ViewPager viewPager) {


        adapter = new Adapter(getChildFragmentManager());
        adapter.addFragment(new HomeFragmentFeatures(), "Offers");
        adapter.addFragment(new HomeFragmentEvents(), "Events");
        adapter.addFragment(new HomeFragmentMovies(), "Movies");
        adapter.addFragment(new HomeFragmentDinning(), "Dining");
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
    public interface FragmentInterface {
        void fragmentBecameVisible();
    }
}