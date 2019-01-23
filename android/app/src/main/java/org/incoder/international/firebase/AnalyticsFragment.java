package org.incoder.international.firebase;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.incoder.international.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * AnalyticsFragment
 *
 * @author : Jerry xu
 * @date : 2019/01/23  10:28
 */
public class AnalyticsFragment extends Fragment implements View.OnClickListener {

    private Button mDashboard;
    private Button mEvents;
    private Button mConversions;
    private Button mAudiences;
    private Button mFunnels;
    private Button mUserProperties;
    private Button mLatestRelease;
    private Button mRetention;
    private Button mStreamView;
    private Button mDebugView;

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
        mDashboard = view.findViewById(R.id.btn_dashboard);
        mEvents = view.findViewById(R.id.btn_events);
        mConversions = view.findViewById(R.id.btn_conversions);
        mAudiences = view.findViewById(R.id.btn_audiences);
        mFunnels = view.findViewById(R.id.btn_funnels);
        mUserProperties = view.findViewById(R.id.btn_user_properties);
        mLatestRelease = view.findViewById(R.id.btn_latest_release);
        mRetention = view.findViewById(R.id.btn_retention);
        mStreamView = view.findViewById(R.id.btn_stream_view);
        mDebugView = view.findViewById(R.id.btn_debug_view);

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
