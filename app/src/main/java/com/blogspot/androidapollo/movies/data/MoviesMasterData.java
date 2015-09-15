package com.blogspot.androidapollo.movies.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by ankur on 13/09/15.
 */
public class MoviesMasterData implements Serializable {

    @SerializedName("poster_path")
    public String posterPath;

    @SerializedName("title")
    public String title;

    public String getPosterPath() {
        return posterPath;
    }

    public String getTitle() {
        return title;
    }
}
