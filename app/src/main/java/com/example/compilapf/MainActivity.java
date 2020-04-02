package com.example.compilapf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.text.DateFormat;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpView();
        setUpViewPagerAdapter();

        /**
         * Determines what day it is and sets the text view in the app to that value
         */
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        TextView date_field = findViewById(R.id.date);
        date_field.setText(currentDate);

    }

    private void setUpView() {
        ImageView imageView = findViewById(R.id.imageMenu);
        tabLayout = findViewById(R.id.tabLayout);
        AppBarLayout appBarLayout = findViewById(R.id.appBarLayout);
        viewPager = findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
    }

    private void setUpViewPagerAdapter() {
        viewPagerAdapter.addFragment(new Goals(), "GOALS");
        viewPagerAdapter.addFragment(new Calendar(), "CALENDAR");
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        Log.d("TagGOAL", "Position: " + tabLayout.getSelectedTabPosition() + " Title: " + viewPagerAdapter.getPageTitle(tabLayout.getSelectedTabPosition()));
                        break;
                    case 1:
                        Log.d("TagCALENDAR", "Position: " + tabLayout.getSelectedTabPosition() + " Title: " + viewPagerAdapter.getPageTitle(tabLayout.getSelectedTabPosition()));
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


}
