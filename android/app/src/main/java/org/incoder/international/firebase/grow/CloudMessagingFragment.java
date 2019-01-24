package org.incoder.international.firebase.grow;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.incoder.international.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

/**
 * CloudMessagingFragment
 *
 * @author : Jerry xu
 * @date : 2019/01/23  10:28
 */
public class CloudMessagingFragment extends Fragment {


    public CloudMessagingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cloud_messaging, container, false);
    }

}
