package org.incoder.international;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.incoder.international.google.MapsActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/**
 * GoogleFragment
 *
 * @author : Jerry xu
 * @date : 2019/01/22  14:58
 */
public class GoogleFragment extends Fragment implements View.OnClickListener {


    public GoogleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_google, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button mMaps = view.findViewById(R.id.btn_maps);
        Button mRoutes = view.findViewById(R.id.btn_routes);
        Button mPlaces = view.findViewById(R.id.btn_places);
        Button mFont = view.findViewById(R.id.btn_font);

        mMaps.setOnClickListener(this);
        mRoutes.setOnClickListener(this);
        mPlaces.setOnClickListener(this);
        mFont.setOnClickListener(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_maps:
                startActivity(new Intent(getContext(), MapsActivity.class));
                break;
            case R.id.btn_routes:
                break;
            case R.id.btn_places:
                break;
            case R.id.btn_font:
                break;
            default:
                break;
        }
    }
}
