/*
 * Author: Maduka Attamah
 * Copyright (c) 2017 Maduka Attamah.
 */

package com.mdk.igboprimer.uihelpers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mdk.igboprimer.fragments.ColoursFragment;
import com.mdk.igboprimer.fragments.FamilyFragment;
import com.mdk.igboprimer.fragments.NumbersFragment;
import com.mdk.igboprimer.fragments.PhrasesFragment;

/**
 * Created by Maduka Attamah on 05/02/2017.
 */

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the categories.
 */
public class CategoriesPagerAdapter extends FragmentPagerAdapter {
    private static final int NUM_CATEGORIES = 4;
    public CategoriesPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return new NumbersFragment();
            case 1:
                return new FamilyFragment();
            case 2:
                return new ColoursFragment();
            case 3:
                return new PhrasesFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_CATEGORIES;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "NUMBERS";
            case 1:
                return "FAMILY";
            case 2:
                return "COLOURS";
            case 3:
                return "PHRASES";
        }
        return null;
    }
}
