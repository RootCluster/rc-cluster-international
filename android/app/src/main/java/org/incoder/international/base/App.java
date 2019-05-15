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

package org.incoder.international.base;

import android.app.Application;

import java.util.Locale;

/**
 * App
 *
 * @author : Jerry xu
 * @date : 2019/2/2 10:57
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        Resources resources = App.getContext().getResources();
//        DisplayMetrics dm = resources.getDisplayMetrics();
//        Configuration config = resources.getConfiguration();
//        config.locale = getSetLocale();
//        resources.updateConfiguration(config, dm);
    }


    /**
     * Locale
     *
     * @return
     */
    private static Locale getSetLocale() {
        // 读取储存的语言设置信息
        return Locale.getDefault();
    }
}
