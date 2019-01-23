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
 * QualityFragment
 *
 * @author : Jerry xu
 * @date : 2019/01/23  10:28
 */
public class QualityFragment extends Fragment implements View.OnClickListener {

    private Button mCrashlytics;
    private Button mPerformance;
    private Button mTestLab;

    public QualityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quality, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mCrashlytics = view.findViewById(R.id.btn_crashlytics);
        mPerformance = view.findViewById(R.id.btn_performance);
        mTestLab = view.findViewById(R.id.btn_test_lab);

        mCrashlytics.setOnClickListener(this);
        mPerformance.setOnClickListener(this);
        mTestLab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_crashlytics:
                break;
            case R.id.btn_performance:
                break;
            case R.id.btn_test_lab:
                break;
            default:
                break;
        }
    }
}
