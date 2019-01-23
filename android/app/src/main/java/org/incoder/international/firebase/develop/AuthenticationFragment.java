package org.incoder.international.firebase.develop;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.incoder.international.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

/**
 * AuthenticationFragment
 *
 * @author : Jerry xu
 * @date : 2019/01/23  10:28
 */
public class AuthenticationFragment extends Fragment {


    public AuthenticationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_authentication, container, false);
    }

}
