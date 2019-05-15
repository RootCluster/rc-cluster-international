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

package org.incoder.international.google;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.incoder.international.R;
import org.incoder.international.google.places.GeolocationActivity;

/**
 * PlacesFragment.
 *
 * @author : Jerry xu
 * @date : 2019/3/25 00:12
 */
public class PlacesFragment extends Fragment implements View.OnClickListener {


    public PlacesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_places, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button mPlaceDetails = view.findViewById(R.id.btn_place_details);
        Button mCurrentPlace = view.findViewById(R.id.btn_current_place);
        Button mFindPlace = view.findViewById(R.id.btn_find_place);
        Button mAutocomplete = view.findViewById(R.id.btn_autocomplete);
        Button mGeocoding = view.findViewById(R.id.btn_geocoding);
        Button mGeolocation = view.findViewById(R.id.btn_geolocation);
        Button mTimeZone = view.findViewById(R.id.btn_time_zone);
        mPlaceDetails.setOnClickListener(this);
        mCurrentPlace.setOnClickListener(this);
        mFindPlace.setOnClickListener(this);
        mAutocomplete.setOnClickListener(this);
        mGeocoding.setOnClickListener(this);
        mGeolocation.setOnClickListener(this);
        mTimeZone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_place_details:
                break;
            case R.id.btn_current_place:
                break;
            case R.id.btn_find_place:
                break;
            case R.id.btn_autocomplete:
                break;
            case R.id.btn_geocoding:
                break;
            case R.id.btn_geolocation:
                startActivity(new Intent(getContext(), GeolocationActivity.class));
                break;
            case R.id.btn_time_zone:
                break;
            default:
                break;
        }
    }
}
