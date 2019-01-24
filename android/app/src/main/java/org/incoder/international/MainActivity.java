package org.incoder.international;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.incoder.international.base.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

/**
 * MainActivity
 *
 * @author : Jerry xu
 * @date : 2019/01/22  14:58
 */
public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private BottomNavigationView mNavigation;

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
        List<Fragment> mFragments = new ArrayList<>();
        mFragments.add(new FirebaseFragment());
        mFragments.add(new FacebookFragment());
        mFragments.add(new TwitterFragment());
        mFragments.add(new GoogleFragment());
        mViewPager = findViewById(R.id.vp_content);
        mNavigation = findViewById(R.id.navigation);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(), mFragments));
        mViewPager.setOffscreenPageLimit(mFragments.size());
        mViewPager.addOnPageChangeListener(mOnPageChangeListener);
        mNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
                startActivity(new Intent(this, SettingsActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
