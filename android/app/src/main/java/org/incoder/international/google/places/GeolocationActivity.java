/*
 * Copyright (C) 2019 The Jerry xu Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.incoder.international.google.places;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import org.incoder.international.R;
import org.incoder.international.base.BaseActivity;
import org.incoder.international.base.FragmentPagerAdapter;
import org.incoder.international.google.places.geolocation.GpsFragment;
import org.incoder.international.google.places.geolocation.LocationFragment;
import org.incoder.international.google.places.geolocation.NetworkFragment;
import org.incoder.international.manager.ToolbarManager;

import java.util.ArrayList;
import java.util.List;


/**
 * GeolocationActivity
 *
 * @author : Jerry xu
 * @date : 2019/01/28  14:58
 */
public class GeolocationActivity extends BaseActivity {

    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> mFragments;
    private List<String> mTitles = new ArrayList<>();
    private String mGpsLocation;
    private String mNetworkLocation;
    private String mLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        mToolbar = findViewById(R.id.toolbar);
        mTabLayout = findViewById(R.id.tabs);
        mViewPager = findViewById(R.id.container);
        ToolbarManager.setToolBarBackDefault(this, mToolbar, "Location");
        mGpsLocation = getResources().getString(R.string.tab_gps);
        mNetworkLocation = getResources().getString(R.string.tab_network);
        mLocation = getResources().getString(R.string.tab_location);
        setTopTab();
    }

    private void setTopTab() {
        if (mFragments == null) {
            mFragments = new ArrayList<>();
            mTitles.add(mGpsLocation);
            mTitles.add(mNetworkLocation);
            mTitles.add(mLocation);
            mFragments.add(new GpsFragment());
            mFragments.add(new NetworkFragment());
            mFragments.add(new LocationFragment());
            // 设置viewPager适配器
            mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(), mFragments, mTitles));
            mViewPager.setOffscreenPageLimit(mFragments.size());
            mTabLayout.setupWithViewPager(mViewPager);
            mTabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    mViewPager.setCurrentItem(tab.getPosition());
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

}
