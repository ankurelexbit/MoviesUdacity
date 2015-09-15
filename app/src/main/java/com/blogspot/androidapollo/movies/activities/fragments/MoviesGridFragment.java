package com.blogspot.androidapollo.movies.activities.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blogspot.androidapollo.movies.R;
import com.blogspot.androidapollo.movies.data.MoviesListingAdapter;
import com.blogspot.androidapollo.movies.data.MoviesMasterData;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesGridFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    public MoviesGridFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies_grid, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);

        List<MoviesMasterData> data = new ArrayList<>();
        MoviesMasterData d1 = new MoviesMasterData();
        d1.posterPath = String.valueOf(R.drawable.dolph);
        d1.title = "Dolphin";
        data.add(d1);

        MoviesMasterData d2 = new MoviesMasterData();
        d2.posterPath = String.valueOf(R.drawable.elephant);
        d2.title = "Elephant";
        data.add(d2);

        MoviesMasterData d3 = new MoviesMasterData();
        d3.posterPath = String.valueOf(R.drawable.leopard);
        d3.title = "Leopard";
        data.add(d3);

        MoviesMasterData d4 = new MoviesMasterData();
        d4.posterPath = String.valueOf(R.drawable.rhino);
        d4.title = "rhina";
        data.add(d4);

        adapter = new MoviesListingAdapter(getActivity(), data);
        recyclerView.setAdapter(adapter);

        return view;
    }


}
