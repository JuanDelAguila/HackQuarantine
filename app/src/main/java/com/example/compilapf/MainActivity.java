package com.example.compilapf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import java.text.DateFormat;

public class MainActivity extends AppCompatActivity {

    /** Constants used in the Tabs*/
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    /** Constants used in the Goals Adder Fab*/
    private TextView textSetGoal;
    private FloatingActionButton fabGoalAdder;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        *  Set the tabs in the main fragment
        */
        setUpView();
        setUpViewPagerAdapter();

        /*
        *  Set the text to the actual date in AppBarLayout
        */
        setDateText();

        /*
        *  Set the new Goal
        */
        setNewGoal();

        openMenu();


    }

    /**
     * Helper function to set the variables necessary to set the tabs
     */
    private void setUpView() {
        ImageView imageView = findViewById(R.id.imageMenu);
        tabLayout = findViewById(R.id.tabLayout);
        AppBarLayout appBarLayout = findViewById(R.id.appBarLayout);
        viewPager = findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
    }

    /**
     * Helper function which add the tabs the the main screem
     */
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

    /**
     *  This is a helper function to set the date in the actual date in AppBarLayout
     */
    private void setDateText() {
        /**
         * Determines what day it is and sets the text view in the app to that value
         */
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        TextView date_field = findViewById(R.id.date);
        date_field.setText(currentDate);
    }

    private void setNewGoal() {
        View view = getLayoutInflater().inflate(R.layout.fragment_goals, null);
        textSetGoal = view.findViewById(R.id.goalAddedText);
        fabGoalAdder = view.findViewById(R.id.addFab);
        fabGoalAdder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    public void openDialog(){
        GoalAdderDialog goalAdderDialog = new GoalAdderDialog();
        goalAdderDialog.show(getSupportFragmentManager(), "Goal Adder Dialog");
    }

    public void openMenu() {

        ImageView menuButton = findViewById(R.id.imageMenu);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

    }

}
