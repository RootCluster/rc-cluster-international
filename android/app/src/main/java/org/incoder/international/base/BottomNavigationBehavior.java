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

package org.incoder.international.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

/**
 * BottomNavigationBehavior
 * add to activity_main.xml file of BottomNavigationView
 * app:layout_behavior="org.incoder.international.base.BottomNavigationBehavior"
 *
 * @author : Jerry xu
 * @date : 2019/2/1 11:29
 */
public final class BottomNavigationBehavior extends CoordinatorLayout.Behavior<BottomNavigationView> {

    public BottomNavigationBehavior(@NonNull Context context, @NonNull AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(@Nullable CoordinatorLayout parent, @NonNull BottomNavigationView child, @Nullable View dependency) {
        if (dependency instanceof Snackbar.SnackbarLayout) {
            this.updateSnackBar(child, (Snackbar.SnackbarLayout) dependency);
        }

        assert parent != null;
        assert dependency != null;
        return super.layoutDependsOn(parent, child, dependency);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomNavigationView child,
                                       @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }

    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomNavigationView child,
                                  @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);
        child.setTranslationY(Math.max(0.0f, Math.min(child.getHeight(), child.getTranslationY() + dy)));
    }

    private void updateSnackBar(BottomNavigationView child, Snackbar.SnackbarLayout snackBarLayout) {
        if (snackBarLayout.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            android.view.ViewGroup.LayoutParams layoutParams = snackBarLayout.getLayoutParams();
            if (layoutParams == null) {
                throw new RuntimeException("null cannot be cast to non-null type android.support.design.widget.CoordinatorLayout.LayoutParams");
            }

            CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) layoutParams;
            params.setAnchorId(child.getId());
            params.anchorGravity = Gravity.TOP;
            params.gravity = Gravity.TOP;
            snackBarLayout.setLayoutParams(params);
        }

    }
}
