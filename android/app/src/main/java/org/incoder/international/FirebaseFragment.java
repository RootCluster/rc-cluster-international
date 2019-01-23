package org.incoder.international;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import org.incoder.international.base.FragmentPagerAdapter;
import org.incoder.international.firebase.AnalyticsFragment;
import org.incoder.international.firebase.DevelopFragment;
import org.incoder.international.firebase.GrowFragment;
import org.incoder.international.firebase.QualityFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


/**
 * FirebaseFragment
 *
 * @author : Jerry xu
 * @date : 2019/01/22  14:58
 */
public class FirebaseFragment extends Fragment {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> mFragments;
    private List<String> mTitles = new ArrayList<>();
    private String analytics;
    private String develop;
    private String grow;
    private String quality;

    public FirebaseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_firebase, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTabLayout = view.findViewById(R.id.tabs);
        mViewPager = view.findViewById(R.id.container);
        analytics = getResources().getString(R.string.tab_analytics);
        develop = getResources().getString(R.string.tab_develop);
        grow = getResources().getString(R.string.tab_grow);
        quality = getResources().getString(R.string.tab_quality);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setTopTab();
    }

    private void setTopTab() {
        if (mFragments == null) {
            mFragments = new ArrayList<>();
            mTitles.add(analytics);
            mTitles.add(develop);
            mTitles.add(grow);
            mTitles.add(quality);
            mFragments.add(new AnalyticsFragment());
            mFragments.add(new DevelopFragment());
            mFragments.add(new GrowFragment());
            mFragments.add(new QualityFragment());
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
