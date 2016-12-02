package com.surf.education.surfeducation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    private String tabTitles[] = new String[] { "Tab1", "Tab2", "Tab3" };
    BlockFragment tab1 = new BlockFragment();
    BlockFragment tab2 = new BlockFragment();
    BlockFragment tab3 = new BlockFragment();

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return tab1;
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

}
