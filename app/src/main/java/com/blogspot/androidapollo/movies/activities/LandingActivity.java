package com.blogspot.androidapollo.movies.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.blogspot.androidapollo.movies.R;
import com.blogspot.androidapollo.movies.activities.fragments.MoviesGridFragment;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().add(R.id.fragment, new MoviesGridFragment()).commit();
        }
    }
}
