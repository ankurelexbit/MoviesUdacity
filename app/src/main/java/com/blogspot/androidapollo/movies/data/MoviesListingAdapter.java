package com.blogspot.androidapollo.movies.data;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.blogspot.androidapollo.movies.R;
import com.blogspot.androidapollo.movies.activities.LandingActivity;
import com.blogspot.androidapollo.movies.activities.fragments.MovieDetailsFragment;
import com.blogspot.androidapollo.movies.utilities.common.MoviesApplication;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ankur on 09/09/15.
 */
public class MoviesListingAdapter extends RecyclerView.Adapter<MoviesListingAdapter.ViewHolder> {

    List<MoviesMasterData> data;
    public MoviesListingAdapter(Context context, List<MoviesMasterData> data){
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_grid_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MoviesMasterData data = this.data.get(position);
        MoviesApplication.getInstance().loadImage(data.getPosterPath(), holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.thumbnail)
        ImageView thumbnail;
        Context mContext;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        @OnClick(R.id.thumbnail)
        public void onClick() {
            if (mContext == null){
                return;
            }
            if (mContext instanceof LandingActivity) {
                Fragment movieDetailsFragment = new MovieDetailsFragment();
                Bundle bundle = new Bundle();
                bundle.putString("title", data.get(getAdapterPosition()).getTitle());
                bundle.putString("release_date", data.get(getAdapterPosition()).getReleaseDate());
                bundle.putString("vote_average", data.get(getAdapterPosition()).getVoteAverage());
                bundle.putString("vote_count", data.get(getAdapterPosition()).getVoteCount());
                bundle.putString("popularity", data.get(getAdapterPosition()).getPopularity());
                bundle.putString("backdrop_path", data.get(getAdapterPosition()).getBackdropPath());
                bundle.putString("poster_path", data.get(getAdapterPosition()).getPosterPath());
                bundle.putString("overview", data.get(getAdapterPosition()).getOverview());
                movieDetailsFragment.setArguments(bundle);
                LandingActivity landingActivity = (LandingActivity) mContext;
                landingActivity.changeType(movieDetailsFragment);
            }

        }
    }
}
