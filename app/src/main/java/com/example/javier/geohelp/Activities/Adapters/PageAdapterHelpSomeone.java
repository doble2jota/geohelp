package com.example.javier.geohelp.Activities.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by javier on 13/02/2016.
 */

public class PageAdapterHelpSomeone extends FragmentStatePagerAdapter {
        int mNumOfTabs;

        public PageAdapterHelpSomeone(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    TabFragmentList tab1 = new TabFragmentList();
                    return tab1;
                case 1:
                    TabFragmentMap tab2 = new TabFragmentMap();
                    return tab2;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }
