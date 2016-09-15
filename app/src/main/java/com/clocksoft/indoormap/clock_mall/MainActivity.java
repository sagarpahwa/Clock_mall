package com.clocksoft.indoormap.clock_mall;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.clocksoft.indoormap.clock_mall.fragment.DirectoryFragment;
import com.clocksoft.indoormap.clock_mall.fragment.GondolaFragment;
import com.clocksoft.indoormap.clock_mall.fragment.HomeFragment;
import com.clocksoft.indoormap.clock_mall.fragment.MoreFragment;
import com.clocksoft.indoormap.clock_mall.fragment.ParkingFragment;

public class MainActivity extends AppCompatActivity {
    private Button buttonHome,buttonDirectory,buttonGondola,buttonParking,buttonMore;
    private int state = 1;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonHome = (Button)findViewById(R.id.Home);
        buttonDirectory = (Button)findViewById(R.id.Directory);
        buttonGondola = (Button)findViewById(R.id.Gondola);
        buttonParking = (Button)findViewById(R.id.Parking);
        buttonMore = (Button)findViewById(R.id.More);
        selectButton(state);
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer,new HomeFragment(),null).commit();
    }

    private void selectButton(int i) {
        switch(i){
            case 1:
                buttonHome.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.home_selected, 0, 0);
                buttonHome.setBackgroundColor(0xffE3B456);
                break;
            case 2:
                buttonDirectory.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.directory_selected, 0, 0);
                buttonDirectory.setBackgroundColor(0xffE3B456);
                break;
            case 3:
                buttonGondola.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.gandola_selected, 0, 0);
                buttonGondola.setBackgroundColor(0xffE3B456);
                break;
            case 4:
                buttonParking.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.parking_selected, 0, 0);
                buttonParking.setBackgroundColor(0xffE3B456);
                break;
            case 5:
                buttonMore.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.more_selected, 0, 0);
                buttonMore.setBackgroundColor(0xffE3B456);
                break;
        }
    }
    private void deselectButton(int i) {
        switch(i){
            case 1:
                buttonHome.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.home, 0, 0);
                buttonHome.setBackgroundColor(Color.TRANSPARENT);
                break;
            case 2:
                buttonDirectory.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.directory, 0, 0);
                buttonDirectory.setBackgroundColor(Color.TRANSPARENT);
                break;
            case 3:
                buttonGondola.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.gondola, 0, 0);
                buttonGondola.setBackgroundColor(Color.TRANSPARENT);
                break;
            case 4:
                buttonParking.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.parking, 0, 0);
                buttonParking.setBackgroundColor(Color.TRANSPARENT);
                break;
            case 5:
                buttonMore.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.more_24dp, 0, 0);
                buttonMore.setBackgroundColor(Color.TRANSPARENT);
                break;
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        return;
    }
    public void onHomeClicked(View view){
        if(state != 1){
            deselectButton(state);
            state = 1;
            selectButton(state);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new HomeFragment(),null).commit();
        }

    }
    public void onDirectoryClicked(View view){
        if(state != 2) {
            deselectButton(state);
            state = 2;
            selectButton(state);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new DirectoryFragment(), null).commit();
        }

    }
    public void onGondolaClicked(View view){
        if(state != 3) {
            deselectButton(state);
            state = 3;
            selectButton(state);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new GondolaFragment(), null).commit();
        }

    }
    public void onParkingClicked(View view){
        if(state != 4) {
            deselectButton(state);
            state = 4;
            selectButton(state);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new ParkingFragment(), null).commit();
        }

    }
    public void onMoreClicked(View view){
        if(state != 5) {
            deselectButton(state);
            state = 5;
            selectButton(state);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new MoreFragment(), null).commit();
        }
    }
}
