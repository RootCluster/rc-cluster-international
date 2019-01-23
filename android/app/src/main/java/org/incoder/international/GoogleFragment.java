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
 * GoogleFragment
 *
 * @author : Jerry xu
 * @date : 2019/01/22  14:58
 */
public class GoogleFragment extends Fragment implements View.OnClickListener {

    private Button mMap;
    private Button mFont;

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
        mMap = view.findViewById(R.id.btn_map);
        mFont = view.findViewById(R.id.btn_font);

        mMap.setOnClickListener(this);
        mFont.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_map:
                break;
            case R.id.btn_font:
                break;
            default:
                break;
        }
    }
}
