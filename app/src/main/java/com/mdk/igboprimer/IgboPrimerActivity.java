/*
 * Author: Maduka Attamah
 * Copyright (c) 2017 Maduka Attamah.
 */

package com.mdk.igboprimer;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;

import com.mdk.igboprimer.uihelpers.CategoriesPagerAdapter;

/**
 * Created by Maduka Attamah on 03/02/2017.
 */

public class IgboPrimerActivity extends AppCompatActivity {


    private CategoriesPagerAdapter categoriesPagerAdapter;

    /**
     * The {@link ViewPager} that will host the categories contents.
     */
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_igbo_primer);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        categoriesPagerAdapter = new CategoriesPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(categoriesPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_igbo_primer, menu);
        return true;
    }


}
