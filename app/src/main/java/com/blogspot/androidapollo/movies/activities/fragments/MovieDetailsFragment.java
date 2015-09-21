package com.blogspot.androidapollo.movies.activities.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blogspot.androidapollo.movies.R;
import com.blogspot.androidapollo.movies.activities.LandingActivity;
import com.blogspot.androidapollo.movies.utilities.common.BaseFragment;
import com.blogspot.androidapollo.movies.utilities.common.MoviesApplication;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieDetailsFragment extends BaseFragment {

    @Bind(R.id.img_backdrop)
    ImageView imgBackDrop;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_release_date)
    TextView tvReleaseDate;
    @Bind(R.id.tv_overview)
    TextView tvOverview;
    @Bind(R.id.img_poster)
    ImageView imgPoster;
    @Bind(R.id.tv_vote_average)
    TextView tvVoteAverage;
    @Bind(R.id.tv_vote_count)
    TextView tvVoteCount;
    @Bind(R.id.tv_popularity)
    TextView tvPopulatiry;
    public MovieDetailsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_details, container, false);
        ButterKnife.bind(this, view);
        hideActionBar((LandingActivity) getActivity());
        if (getArguments().getString("backdrop_path") == null){
            imgBackDrop.setVisibility(View.GONE);
        } else {
            MoviesApplication.getInstance().loadImage(getArguments().getString("backdrop_path"), imgBackDrop);
        }
        MoviesApplication.getInstance().loadImage(getArguments().getString("poster_path"), imgPoster);
        tvTitle.setText(getArguments().getString("title"));
        tvOverview.setText(getArguments().getString("overview"));
        tvReleaseDate.setText(getArguments().getString("release_date"));
        tvVoteAverage.setText(getArguments().getString("vote_average"));
        tvVoteCount.setText(getArguments().getString("vote_count"));
        int popularity = 0;
        try {
            popularity = Integer.valueOf(getArguments().getString("popularity").split("\\.")[0]);
        } catch (NumberFormatException e) {
            popularity = 0;
        }
        tvPopulatiry.setText(String.valueOf(popularity));
        return view;
    }
}
