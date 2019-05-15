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

package org.incoder.international.firebase;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.incoder.international.R;

import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static android.app.Activity.RESULT_OK;

/**
 * DevelopFragment
 *
 * @author : Jerry xu
 * @date : 2019/01/23  10:28
 */
public class DevelopFragment extends Fragment implements View.OnClickListener {

    private static final int RC_SIGN_IN = 123;

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
        Button mAuthentication = view.findViewById(R.id.btn_authentication);
        Button mDatabase = view.findViewById(R.id.btn_database);
        Button mStorage = view.findViewById(R.id.btn_storage);
        Button mHosting = view.findViewById(R.id.btn_hosting);
        Button mFunctions = view.findViewById(R.id.btn_functions);
        Button mMlKit = view.findViewById(R.id.btn_ml_kit);
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
//                AuthenticationFragment authentication = new AuthenticationFragment();
//                FragmentTransaction transaction;
//                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
//                    transaction = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
//                    transaction.replace(R.id.ll_content, authentication);
//                    transaction.addToBackStack(null);
//                    transaction.commit();
//                }
                createSignInIntent();
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

    private void createSignInIntent() {
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.PhoneBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build(),
                new AuthUI.IdpConfig.FacebookBuilder().build(),
                new AuthUI.IdpConfig.TwitterBuilder().build()
        );
        // [START auth_fui_theme_logo]
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        // Set logo drawable
                        .setLogo(R.mipmap.ic_launcher)
                        // Set theme
                        .setTheme(R.style.AppDefaultTheme)
                        .build(), RC_SIGN_IN);
        // [END auth_fui_theme_logo]
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);
            System.out.println("IdpResponse" + response);
            if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                System.out.println("user" + user);
                // ...
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
        }
    }


}
