package com.blogspot.androidapollo.movies.utilities.common;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.blogspot.androidapollo.movies.R;

/**
 * Created by ankur on 20/09/15.
 */
public class BaseFragment extends Fragment {

    private ProgressDialog progressDialog;

    protected void hideActionBar(AppCompatActivity activity) {
        activity.getSupportActionBar().hide();
    }

    protected void showActionBar(AppCompatActivity activity) {
        activity.getSupportActionBar().show();
    }

    protected void showProgressDialog() {
        if (progressDialog == null || !progressDialog.isShowing()) {
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage(getString(R.string.please_wait));
            progressDialog.setCancelable(true);
            progressDialog.show();
        }
    }

    protected void hideProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }}
