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


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import org.incoder.international.base.FragmentPagerAdapter;
import org.incoder.international.google.FontFragment;
import org.incoder.international.google.MapsFragment;
import org.incoder.international.google.PlacesFragment;
import org.incoder.international.google.RoutesFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * GoogleFragment
 *
 * @author : Jerry xu
 * @date : 2019/01/22  14:58
 */
public class GoogleFragment extends Fragment {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> mFragments;
    private List<String> mTitles = new ArrayList<>();

    private String maps;
    private String routes;
    private String places;
    private String font;

    public GoogleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.tab_view_pager_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTabLayout = view.findViewById(R.id.tabs);
        mViewPager = view.findViewById(R.id.container);
        maps = getResources().getString(R.string.tab_maps);
        routes = getResources().getString(R.string.tab_routes);
        places = getResources().getString(R.string.tab_places);
        font = getResources().getString(R.string.tab_font);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setTopTab();
    }

    private void setTopTab() {
        if (mFragments == null) {
            mFragments = new ArrayList<>();
            mTitles.add(maps);
            mTitles.add(routes);
            mTitles.add(places);
            mTitles.add(font);
            mFragments.add(new MapsFragment());
            mFragments.add(new RoutesFragment());
            mFragments.add(new PlacesFragment());
            mFragments.add(new FontFragment());
            // 设置viewPager适配器
            mViewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager(), mFragments, mTitles));
            mViewPager.setOffscreenPageLimit(mFragments.size());
            mTabLayout.setupWithViewPager(mViewPager);
            mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
