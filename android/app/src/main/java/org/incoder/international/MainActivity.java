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

package org.incoder.international;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import org.incoder.international.base.BaseActivity;
import org.incoder.international.base.FragmentPagerAdapter;
import org.incoder.international.manager.ToolbarManager;

import java.util.ArrayList;
import java.util.List;

/**
 * MainActivity
 *
 * @author : Jerry xu
 * @date : 2019/01/22  14:58
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {

    private CoordinatorLayout mCoordinatorLayout;
    private ViewPager mViewPager;
    private BottomNavigationView mNavigation;
    private FloatingActionButton mActionButton;
    private Toolbar mToolbar;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_firebase:
                    mViewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_facebook:
                    mViewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_twitter:
                    mViewPager.setCurrentItem(2);
                    return true;
                case R.id.navigation_google:
                    mViewPager.setCurrentItem(3);
                    return true;
                default:
                    break;
            }
            return false;
        }
    };

    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (position == 0) {
                mNavigation.setSelectedItemId(R.id.navigation_firebase);
            } else if (position == 1) {
                mNavigation.setSelectedItemId(R.id.navigation_facebook);
            } else if (position == 2) {
                mNavigation.setSelectedItemId(R.id.navigation_twitter);
            } else if (position == 3) {
                mNavigation.setSelectedItemId(R.id.navigation_google);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = findViewById(R.id.toolbar);
        ToolbarManager.setToolBarDefault(this, mToolbar, getResources().getString(R.string.app_name), R.menu.settings, item -> {
            if (item.getItemId() == R.id.action_settings) {
                startActivity(new Intent(getBaseContext(), SettingsActivity.class));
            }
            return true;
        });

        List<Fragment> mFragments = new ArrayList<>();
        mFragments.add(new FirebaseFragment());
        mFragments.add(new FacebookFragment());
        mFragments.add(new TwitterFragment());
        mFragments.add(new GoogleFragment());
        mCoordinatorLayout = findViewById(R.id.container);
        mViewPager = findViewById(R.id.vp_content);
        mNavigation = findViewById(R.id.navigation);
        mActionButton = findViewById(R.id.fab);
        mActionButton.setOnClickListener(this);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(), mFragments));
        mViewPager.setOffscreenPageLimit(mFragments.size());
        mViewPager.addOnPageChangeListener(mOnPageChangeListener);
        mNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fab) {
//            startActivity(new Intent(this, TestActivity.class));
            Snackbar.make(mCoordinatorLayout, "test", Snackbar.LENGTH_SHORT)
                    .setAction("Action", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(MainActivity.this, "hi", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }
}
