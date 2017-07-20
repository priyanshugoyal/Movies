package com.example.priyanshu.movies.rest;

import com.example.priyanshu.movies.model.MovieResponse;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Priyanshu on 29-May-17.
 */

public interface ApiInterface {
    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key")String apikey);
    @GET("movie/popular")
    Call<MovieResponse> getPopular(@Query("api_key")String apiKey);
}
