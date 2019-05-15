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

package org.incoder.international.google.places.geolocation;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

import org.incoder.international.R;

import java.util.List;
import java.util.Objects;

/**
 * GpsFragment
 * Gps定位方案
 *
 * @author : Jerry xu
 * @date : 2019/01/28  14:58
 */
public class GpsFragment extends Fragment implements View.OnClickListener {


    private final int PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION = 1;
    private Button mGps;
    private TextView mGpsResout;
    private LocationManager mLocationManager;
    private String provider;

    LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            // 更新当前设备位置信息
            showTextViewInfo(location);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

    public GpsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gps, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mGps = view.findViewById(R.id.btn_gps);
        mGpsResout = view.findViewById(R.id.tv_gps);
        mGps.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_gps) {
            locationInfo(v);
        }
    }

    private void locationInfo(View v) {
        if (ActivityCompat.checkSelfPermission(Objects.requireNonNull(getContext()),
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestLocationPermission();
        } else {
            Snackbar.make(v, "已授权", Snackbar.LENGTH_LONG).show();
            mLocationManager = (LocationManager) Objects.requireNonNull(getContext()).getSystemService(Context.LOCATION_SERVICE);
            // 获取所有可用的位置提供器
            List<String> providerList = mLocationManager.getProviders(true);
            if (providerList.contains(LocationManager.GPS_PROVIDER)) {
                provider = LocationManager.GPS_PROVIDER;
            } else if (providerList.contains(LocationManager.NETWORK_PROVIDER)) {
                provider = LocationManager.NETWORK_PROVIDER;
            } else {
                // 当前没有可用的位置提供器
                Toast.makeText(getContext(), "No location provider to use", Toast.LENGTH_SHORT).show();
                return;
            }

            Location location = mLocationManager.getLastKnownLocation(provider);
            if (location != null) {
                // 显示当前设备位置信息
                showTextViewInfo(location);
            }

            mLocationManager.requestLocationUpdates(provider, 5000, 1, locationListener);
        }
    }

    private void requestLocationPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(Objects.requireNonNull(getActivity()),
                Manifest.permission.ACCESS_COARSE_LOCATION)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getContext()));
            builder.setTitle("应用授权");
            builder.setMessage("尚未开启定位服务");
            builder.setPositiveButton("开启", (dialog, which) -> {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                Objects.requireNonNull(getActivity()).startActivityForResult(intent, PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION);
            });
            builder.setNegativeButton("取消", (dialog, which) -> {

            });
            builder.show();
        } else {
            // 申请授权
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION);
        }
    }

    private void showTextViewInfo(Location location) {
        String currentPosition = "latitude is " + location.getLatitude() + "\nlongitude is" + location.getLongitude();
        Log.d("GpsFragment", currentPosition);
    }

    public static boolean isLocationServiceEnable(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        boolean gps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean network = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        return gps || network;
    }

}
