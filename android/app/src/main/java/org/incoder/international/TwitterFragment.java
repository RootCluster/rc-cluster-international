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
