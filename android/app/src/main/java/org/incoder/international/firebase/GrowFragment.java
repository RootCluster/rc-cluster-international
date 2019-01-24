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
 * GrowFragment
 *
 * @author : Jerry xu
 * @date : 2019/01/23  10:28
 */
public class GrowFragment extends Fragment implements View.OnClickListener {

    public GrowFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_grow, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button mPredictions = view.findViewById(R.id.btn_predictions);
        Button mTesting = view.findViewById(R.id.btn_testing);
        Button mCloudMessaging = view.findViewById(R.id.btn_cloud_messaging);
        Button mInAppMessaging = view.findViewById(R.id.btn_in_app_messaging);
        Button mRemoteConfig = view.findViewById(R.id.btn_remote_config);
        Button mDynamicLinks = view.findViewById(R.id.btn_dynamic_links);
        Button mAdMob = view.findViewById(R.id.btn_admob);

        mPredictions.setOnClickListener(this);
        mTesting.setOnClickListener(this);
        mCloudMessaging.setOnClickListener(this);
        mInAppMessaging.setOnClickListener(this);
        mRemoteConfig.setOnClickListener(this);
        mDynamicLinks.setOnClickListener(this);
        mAdMob.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_predictions:
                break;
            case R.id.btn_testing:
                break;
            case R.id.btn_cloud_messaging:
                break;
            case R.id.btn_in_app_messaging:
                break;
            case R.id.btn_remote_config:
                break;
            case R.id.btn_dynamic_links:
                break;
            case R.id.btn_admob:
                break;
            default:
                break;
        }
    }
}
