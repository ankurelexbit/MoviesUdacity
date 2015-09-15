package com.blogspot.androidapollo.movies.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ankur on 08/09/15.
 */
public class MoviesMasterList implements Serializable{

    @SerializedName("results")
    private List<MoviesMasterData> results;

    public List<MoviesMasterData> getResults() {
        return results;
    }
}
