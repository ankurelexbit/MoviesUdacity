package com.blogspot.androidapollo.movies.data;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blogspot.androidapollo.movies.R;

import java.util.List;

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
        holder.thumbnail.setImageResource(Integer.parseInt(data.getPosterPath()));
        holder.movieName.setText(data.getTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView thumbnail;
        TextView movieName;

        public ViewHolder(View itemView) {
            super(itemView);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
            movieName = (TextView) itemView.findViewById(R.id.movie_name);
        }

    }
}
