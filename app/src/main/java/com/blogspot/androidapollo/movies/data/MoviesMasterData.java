package com.blogspot.androidapollo.movies.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by ankur on 13/09/15.
 */
public class MoviesMasterData implements Serializable {

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("backdrop_path")
    private String backdropPath;

    @SerializedName("title")
    private String title;

    @SerializedName("overview")
    private String overview;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("popularity")
    private String popularity;

    @SerializedName("vote_average")
    private String voteAverage;

    @SerializedName("vote_count")
    private String voteCount;

    public String getPosterPath() {
        return posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getPopularity() {
        return popularity;
    }

    public String getVoteAverage() {
        return voteAverage;
    }

    public String getVoteCount() {
        return voteCount;
    }
}
