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

package org.incoder.international.manager;

import androidx.annotation.MenuRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

/**
 * ToolbarManager
 *
 * @author : Jerry xu
 * @date : 2019/1/29 21:05
 */
public class ToolbarManager {


    /***
     * 系统默认风格标题栏 include_toolbar
     *
     * @param toolbar  toolbar
     * @param title    标题
     */
    public static void setToolBarDefault(AppCompatActivity activity, Toolbar toolbar, String title) {
        // 设置主标题
        toolbar.setTitle(title);
    }

    /**
     * 系统默认风格标题栏 include_toolbar
     *
     * @param toolbar  toolbar
     * @param title    标题
     * @param resId    菜单
     * @param listener 菜单点击事件
     */
    public static void setToolBarDefault(AppCompatActivity activity, Toolbar toolbar, String title,
                                         @MenuRes int resId, Toolbar.OnMenuItemClickListener listener) {
        // 设置主标题
        setToolBarDefault(activity, toolbar, title);
        // 设置菜单
        toolbar.inflateMenu(resId);
        toolbar.setOnMenuItemClickListener(listener);
    }

    /***
     * 系统默认风格标题栏 include_toolbar
     *
     * @param activity activity
     * @param toolbar  toolbar
     * @param title    标题
     */
    public static void setToolBarBackDefault(AppCompatActivity activity, Toolbar toolbar, String title) {
        // 设置主标题
        toolbar.setTitle(title);
        activity.setSupportActionBar(toolbar);
        // 设置导航栏图标
        ActionBar actionBar = activity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> activity.finish());
    }

    /**
     * 系统默认风格标题栏 include_toolbar
     *
     * @param activity activity
     * @param toolbar  toolbar
     * @param title    标题
     * @param resId    菜单
     * @param listener 菜单点击事件
     */
    public static void setToolBarBackDefault(AppCompatActivity activity, Toolbar toolbar, String title,
                                             @MenuRes int resId, Toolbar.OnMenuItemClickListener listener) {
        setToolBarBackDefault(activity, toolbar, title);
        toolbar.inflateMenu(resId);
        toolbar.setOnMenuItemClickListener(listener);
    }


}
