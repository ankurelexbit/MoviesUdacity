package com.blogspot.androidapollo.movies.activities.fragments;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.blogspot.androidapollo.movies.R;
import com.blogspot.androidapollo.movies.activities.LandingActivity;
import com.blogspot.androidapollo.movies.data.MoviesListingAdapter;
import com.blogspot.androidapollo.movies.data.MoviesMasterData;
import com.blogspot.androidapollo.movies.data.MoviesMasterList;
import com.blogspot.androidapollo.movies.utilities.Constants;
import com.blogspot.androidapollo.movies.utilities.common.BaseFragment;
import com.blogspot.androidapollo.movies.utilities.common.MoviesApplication;
import com.blogspot.androidapollo.movies.utilities.common.MoviesUtil;
import com.blogspot.androidapollo.movies.utilities.retrofit.moviesdb.MoviesDbApiMethods;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesGridFragment extends BaseFragment implements View.OnClickListener {

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private static final String TAG = MoviesGridFragment.class.getSimpleName();
    private View rootView;
    private int itemSelected = -1;
    private String USER_OPTION_SELECTED = "user_option_selected";
    private MenuItem menuItem;

    public MoviesGridFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (savedInstanceState != null) {
            itemSelected = savedInstanceState.getInt(USER_OPTION_SELECTED);
        } else {
            itemSelected = R.id.popular_first_menu;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        showActionBar((LandingActivity) getActivity());
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_movies_grid, container, false);
            ButterKnife.bind(this, rootView);
            if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                layoutManager = new GridLayoutManager(getActivity(), 2);
            } else if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                layoutManager = new GridLayoutManager(getActivity(), 3);
            }
            recyclerView.setLayoutManager(layoutManager);
            if (savedInstanceState != null){
                itemSelected = savedInstanceState.getInt(USER_OPTION_SELECTED);
                switch (itemSelected){
                    case R.id.popular_first_menu :
                         updateUIForPopularFirst();
                        break;
                    case R.id.highest_rated_first_menu :
                        updateUIForHighestRatedFirst();
                        break;
                    case R.id.latest_first_menu :
                        updateUIForLatestMovies();
                        break;
                }
            } else
                updateUIForPopularFirst();
        }
        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(
            Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_landing, menu);
        if (itemSelected == -1) {
            return;
        }
        menuItem = menu.findItem(itemSelected);
        menuItem.setChecked(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        itemSelected = item.getItemId();
        switch (item.getItemId()) {
            case R.id.popular_first_menu:
                item.setChecked(true);
                updateUIForPopularFirst();
                return true;
            case R.id.highest_rated_first_menu:
                item.setChecked(true);
                updateUIForHighestRatedFirst();
                return true;
            case R.id.latest_first_menu:
                item.setChecked(true);
                updateUIForLatestMovies();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(USER_OPTION_SELECTED, itemSelected);
        super.onSaveInstanceState(outState);
    }

    private void updateUIForPopularFirst() {
        showProgressDialog();
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Constants.MOVIESDB_BASE_URL)
                .build();
        MoviesDbApiMethods methods = restAdapter.create(MoviesDbApiMethods.class);
        Callback callback = new Callback() {
            @Override
            public void success(Object o, Response response) {
                hideProgressDialog();
                MoviesMasterList moviesList = (MoviesMasterList) o;
                List<MoviesMasterData> data = moviesList.getResults();
                adapter = new MoviesListingAdapter(getActivity(), data);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError error) {
                hideProgressDialog();
                MoviesApplication.getInstance().showToast("Error connecting to moviesDB api");
                Log.e(TAG, "Caught retrofit exception : " + error.getMessage());
            }
        };
        methods.getPopularMoviesMasterData("popularity.desc", Constants.MOVIESDB_KEY, callback);
    }

    private void updateUIForHighestRatedFirst() {
        showProgressDialog();
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Constants.MOVIESDB_BASE_URL)
                .build();
        MoviesDbApiMethods methods = restAdapter.create(MoviesDbApiMethods.class);
        Callback callback = new Callback() {
            @Override
            public void success(Object o, Response response) {
                hideProgressDialog();
                MoviesMasterList moviesList = (MoviesMasterList) o;
                List<MoviesMasterData> data = moviesList.getResults();
                adapter = new MoviesListingAdapter(getActivity(), data);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError error) {
                hideProgressDialog();
                MoviesApplication.getInstance().showToast("Error connecting to moviesDB api");
                Log.e(TAG, "Caught retrofit exception : " + error.getMessage());
            }
        };
        methods.getHighestRatedMoviesMasterData("vote_average.desc", Constants.MOVIESDB_KEY, "US", callback);
    }

    private void updateUIForLatestMovies() {
        showProgressDialog();
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Constants.MOVIESDB_BASE_URL)
                .build();
        MoviesDbApiMethods methods = restAdapter.create(MoviesDbApiMethods.class);
        Callback callback = new Callback() {
            @Override
            public void success(Object o, Response response) {
                hideProgressDialog();
                MoviesMasterList moviesList = (MoviesMasterList) o;
                List<MoviesMasterData> data = moviesList.getResults();
                adapter = new MoviesListingAdapter(getActivity(), data);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError error) {
                hideProgressDialog();
                MoviesApplication.getInstance().showToast("Error connecting to moviesDB api");
                Log.e(TAG, "Caught retrofit exception : " + error.getMessage());
            }
        };
        methods.getLatestMoviesMasterData(MoviesUtil.getPastDate(30), MoviesUtil.getCurrentDate(), Constants.MOVIESDB_KEY, "US", callback);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home:
                getActivity().finish();
        }
    }
}
