package com.blogspot.androidapollo.movies.utilities.retrofit.moviesdb;

import com.blogspot.androidapollo.movies.data.MoviesMasterList;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by ankur on 15/09/15.
 */
public interface MoviesDbApiMethods {

    @GET("/3/discover/movie")
    void getPopularMoviesMasterData(@Query("sort_by") String sortBy, @Query("api_key") String apiKey, Callback<MoviesMasterList> callback);

    @GET("/3/discover/movie")
    void getHighestRatedMoviesMasterData(@Query("sort_by") String sortBy, @Query("api_key") String apiKey, @Query("certification_country") String certificationCountry, Callback<MoviesMasterList> callback);

    @GET("/3/discover/movie")
    void getLatestMoviesMasterData(@Query("primary_release_date.gte") String dateGreaterThan, @Query("primary_release_date.lte") String dateLessThan, @Query("api_key") String apiKey, @Query("certification_country") String certificationCountry, Callback<MoviesMasterList> callback);
}
