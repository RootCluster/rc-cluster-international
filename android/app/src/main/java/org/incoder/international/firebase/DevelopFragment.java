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
 * DevelopFragment
 *
 * @author : Jerry xu
 * @date : 2019/01/23  10:28
 */
public class DevelopFragment extends Fragment implements View.OnClickListener {

    private Button mAuthentication;
    private Button mDatabase;
    private Button mStorage;
    private Button mHosting;
    private Button mFunctions;
    private Button mMlKit;

    public DevelopFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_develop, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAuthentication = view.findViewById(R.id.btn_authentication);
        mDatabase = view.findViewById(R.id.btn_database);
        mStorage = view.findViewById(R.id.btn_storage);
        mHosting = view.findViewById(R.id.btn_hosting);
        mFunctions = view.findViewById(R.id.btn_functions);
        mMlKit = view.findViewById(R.id.btn_ml_kit);
        mAuthentication.setOnClickListener(this);
        mDatabase.setOnClickListener(this);
        mStorage.setOnClickListener(this);
        mHosting.setOnClickListener(this);
        mFunctions.setOnClickListener(this);
        mMlKit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_authentication:
                break;
            case R.id.btn_database:
                break;
            case R.id.btn_storage:
                break;
            case R.id.btn_hosting:
                break;
            case R.id.btn_functions:
                break;
            case R.id.btn_ml_kit:
                break;
            default:
                break;
        }
    }
}
