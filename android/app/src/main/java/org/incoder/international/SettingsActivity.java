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

import androidx.appcompat.widget.Toolbar;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

import org.incoder.international.base.BaseActivity;
import org.incoder.international.manager.ToolbarManager;


/**
 * SettingsActivity
 *
 * @author : Jerry xu
 * @date : 2019/01/22  14:58
 */
public class SettingsActivity extends BaseActivity {

    private Toolbar mToolbar;
    private static final String LANGUAGE_LIST = "language_list";
    private static final String NOTIFICATION_STYLE_LIST = "notification_style_list";
    private static final String NOTIFICATIONS_NEW_MESSAGE_VIBRATE = "notifications_new_message_vibrate";
    private static final String PREF_KEY_CLEAN = "pref_key_clean";
    private static final String PREF_KEY_UPDATE = "pref_key_update";

    private static Preference.OnPreferenceChangeListener sOnPreferenceChangeListener = (preference, newValue) -> {
        String stringValue = newValue.toString();
        if (preference instanceof ListPreference) {
            ListPreference listPreference = (ListPreference) preference;
            int index = listPreference.findIndexOfValue(stringValue);

            // Set the summary to reflect the new value.
            preference.setSummary(index >= 0 ? listPreference.getEntries()[index] : null);

//            switch (preference.getKey()) {
//                // 语言选择
//                case LANGUAGE_LIST:
//                    changeAppLanguage(preference);
//                    break;
//                // 通知类型选择
//                case NOTIFICATION_LIST:
//                    setAppNotificationStyle(preference);
//                    break;
//                default:
//                    break;
//            }
        }
        return true;
    };


    private static Preference.OnPreferenceClickListener mClickListener = preference -> {
        switch (preference.getKey()) {
            // 清除缓存
            case PREF_KEY_CLEAN:
                // TODO: 2019/2/19 清除缓存
                return true;
            // 检查应用升级
            case PREF_KEY_UPDATE:
                // TODO: 2019/2/19 应用升级
                return true;
            default:
                break;
        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        mToolbar = findViewById(R.id.toolbar);
        ToolbarManager.setToolBarBackDefault(this, mToolbar, getResources().getString(R.string.action_title_settings));
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_content, new SettingsFragment()).commit();
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle bundle, String s) {
            addPreferencesFromResource(R.xml.pref_settings);
            bindPreferenceSummaryToValueForList(findPreference(LANGUAGE_LIST));
            bindPreferenceSummaryToValueForList(findPreference(NOTIFICATION_STYLE_LIST));
            bindPreferenceOnClick(findPreference(PREF_KEY_CLEAN));
            bindPreferenceOnClick(findPreference(PREF_KEY_UPDATE));
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
            if (id == android.R.id.home) {
                startActivity(new Intent(getActivity(), SettingsActivity.class));
                return true;
            }
            return super.onOptionsItemSelected(item);
        }
    }

    private static void bindPreferenceSummaryToValueForList(Preference preference) {

        preference.setOnPreferenceChangeListener(sOnPreferenceChangeListener);

        sOnPreferenceChangeListener.onPreferenceChange(preference,
                PreferenceManager
                        .getDefaultSharedPreferences(preference.getContext())
                        .getString(preference.getKey(), ""));
    }

    private static void bindPreferenceOnClick(Preference preference) {
        preference.setOnPreferenceClickListener(mClickListener);

    }

    private static void setAppNotificationStyle(Preference preference) {

    }

    private void changeAppLanguage(Preference summary) {

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        // 杀掉进程
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

}
