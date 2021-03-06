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

package org.incoder.international.firebase;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.incoder.international.R;

/**
 * AnalyticsFragment
 *
 * @author : Jerry xu
 * @date : 2019/01/23  10:28
 */
public class AnalyticsFragment extends Fragment implements View.OnClickListener {

    public AnalyticsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_analytics, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button mDashboard = view.findViewById(R.id.btn_dashboard);
        Button mEvents = view.findViewById(R.id.btn_events);
        Button mConversions = view.findViewById(R.id.btn_conversions);
        Button mAudiences = view.findViewById(R.id.btn_audiences);
        Button mFunnels = view.findViewById(R.id.btn_funnels);
        Button mUserProperties = view.findViewById(R.id.btn_user_properties);
        Button mLatestRelease = view.findViewById(R.id.btn_latest_release);
        Button mRetention = view.findViewById(R.id.btn_retention);
        Button mStreamView = view.findViewById(R.id.btn_stream_view);
        Button mDebugView = view.findViewById(R.id.btn_debug_view);

        mDashboard.setOnClickListener(this);
        mEvents.setOnClickListener(this);
        mConversions.setOnClickListener(this);
        mAudiences.setOnClickListener(this);
        mFunnels.setOnClickListener(this);
        mUserProperties.setOnClickListener(this);
        mLatestRelease.setOnClickListener(this);
        mRetention.setOnClickListener(this);
        mStreamView.setOnClickListener(this);
        mDebugView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_dashboard:
                break;
            case R.id.btn_events:
                break;
            case R.id.btn_conversions:
                break;
            case R.id.btn_audiences:
                break;
            case R.id.btn_funnels:
                break;
            case R.id.btn_user_properties:
                break;
            case R.id.btn_latest_release:
                break;
            case R.id.btn_retention:
                break;
            case R.id.btn_stream_view:
                break;
            case R.id.btn_debug_view:
                break;
            default:
                break;
        }
    }
}
