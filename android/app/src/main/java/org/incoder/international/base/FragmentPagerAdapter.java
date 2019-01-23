package org.incoder.international.base;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

/**
 * FragmentPagerAdapter
 *
 * @author Jerry xu
 * @date 2018-06-11 13:00
 */
public class FragmentPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragments;
    private List<String> mTitles;

    public FragmentPagerAdapter(FragmentManager fm,
                                List<Fragment> fragments) {
        super(fm);
        this.mFragments = fragments;
    }

    public FragmentPagerAdapter(FragmentManager fm,
                                List<Fragment> fragments, List<String> titles) {
        super(fm);
        this.mFragments = fragments;
        this.mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (mTitles == null || mTitles.size() == 0) {
            return super.getPageTitle(position);
        } else {
            return mTitles.get(position);
        }
    }
}
