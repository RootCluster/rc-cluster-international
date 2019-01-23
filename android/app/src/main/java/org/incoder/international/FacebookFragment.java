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
 * FacebookFragment
 *
 * @author : Jerry xu
 * @date : 2019/01/22  14:58
 */
public class FacebookFragment extends Fragment {

    private Button mAccount;
    private Button mMessenger;
    private Button mMarketing;
    private Button mInstagram;

    public FacebookFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_facebook, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        mAccount = view.findViewById(R.id.btn_account);
//        mMessenger = view.findViewById(R.id.btn_messenger);
    }
}
