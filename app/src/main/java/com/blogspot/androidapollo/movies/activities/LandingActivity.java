package com.blogspot.androidapollo.movies.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.blogspot.androidapollo.movies.R;
import com.blogspot.androidapollo.movies.activities.fragments.MoviesGridFragment;

public class LandingActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        fragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null){
            changeType(new MoviesGridFragment());
        }
    }

    public void changeType(Fragment fragment) {
        Fragment fragmentById = fragmentManager.findFragmentById(R.id.fragment);
        if (fragmentById == null) {
            fragmentManager.beginTransaction().add(R.id.fragment, fragment).addToBackStack(null).commit();
        } else {
            fragmentManager.beginTransaction().replace(R.id.fragment, fragment).addToBackStack(null).commit();
        }
    }
}
