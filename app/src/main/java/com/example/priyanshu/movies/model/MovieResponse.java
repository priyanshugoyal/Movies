package com.example.priyanshu.movies.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Priyanshu on 29-May-17.
 */

public class MovieResponse {
    @SerializedName("results")
    private ArrayList<Movie> MoviesResult;

    public ArrayList<Movie> getMoviesResult() {
        return MoviesResult;
    }

    public void setMoviesResult(ArrayList<Movie> moviesResult) {
        MoviesResult = moviesResult;
    }




}
