package com.jda.hackquarantine.ui.home;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class TabPagerAdapter extends FragmentStatePagerAdapter {
    String[] tabArray = {"Goals", "Calendar"};

    public TabPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public CharSequence getPageTitle (int position){
        return tabArray[position];
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new GoalsTab();
            case 1:
                return new CalendarTab();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
