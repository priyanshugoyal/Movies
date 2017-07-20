package com.example.priyanshu.movies.rest;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Priyanshu on 29-May-17.
 */

public class ApiClient {
    public static final String BASE_URL = "http://api.themoviedb.org/3/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
