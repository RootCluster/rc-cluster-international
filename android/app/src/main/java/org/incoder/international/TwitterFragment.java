package org.incoder.international;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/**
 * TwitterFragment
 *
 * @author : Jerry xu
 * @date : 2019/01/22  14:58
 */
public class TwitterFragment extends Fragment implements View.OnClickListener {

    public TwitterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_twitter, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button mAdvertise = view.findViewById(R.id.btn_advertise);
        Button mPublish = view.findViewById(R.id.btn_publish);
        Button mAnalyze = view.findViewById(R.id.btn_analyze);
        Button mEngage = view.findViewById(R.id.btn_engage);

        mAdvertise.setOnClickListener(this);
        mPublish.setOnClickListener(this);
        mAnalyze.setOnClickListener(this);
        mEngage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_advertise:
                break;
            case R.id.btn_publish:
                break;
            case R.id.btn_analyze:
                break;
            case R.id.btn_engage:
                break;
            default:
                break;
        }
    }
}
