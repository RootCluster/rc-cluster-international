package org.incoder.international;

import android.os.Bundle;
import android.preference.PreferenceActivity;


/**
 * SettingsActivity
 *
 * @author : Jerry xu
 * @date : 2019/01/22  14:58
 */
public class SettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_settings);
//        setContentView(R.layout.activity_settings);
    }
}
