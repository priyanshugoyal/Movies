package com.example.priyanshu.movies.model;
import com.google.gson.annotations.SerializedName;
/**
 * Created by Priyanshu on 29-May-17.
 */

public class Movie {
    @SerializedName("poster_path")
    private String PosterPath;
    @SerializedName("original_title")
    private String OriginalTitle;

    @SerializedName("release_date")
    private String ReleaseDate;

    @SerializedName("overview")
    private String Overview;

    @SerializedName("vote_average")
    private String Vote;

    public String getPosterPath() {
        return PosterPath;
    }

    public void setPosterPath(String posterPath) {
        PosterPath = posterPath;
    }

    public String getOriginalTitle() {
        return OriginalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        OriginalTitle = originalTitle;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        ReleaseDate = releaseDate;
    }

    public String getOverview() {
        return Overview;
    }

    public void setOverview(String overview) {
        Overview = overview;
    }

    public String getVote() {
        return Vote;
    }

    public void setVote(String vote) {
        Vote = vote;
    }


}
