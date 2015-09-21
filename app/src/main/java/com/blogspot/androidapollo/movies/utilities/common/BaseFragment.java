package com.blogspot.androidapollo.movies.utilities.common;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ankur on 20/09/15.
 */
public class BaseFragment extends Fragment {

    protected void hideActionBar(AppCompatActivity activity) {
        activity.getSupportActionBar().hide();
    }

    protected void showActionBar(AppCompatActivity activity) {
        activity.getSupportActionBar().show();
    }
}
