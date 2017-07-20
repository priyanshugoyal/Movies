package com.example.priyanshu.movies;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.priyanshu.movies.adapter.GridAdapter;
import com.example.priyanshu.movies.model.Movie;
import com.example.priyanshu.movies.model.MovieResponse;
import com.example.priyanshu.movies.rest.ApiClient;
import com.example.priyanshu.movies.rest.ApiInterface;


import java.util.ArrayList;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MovieGridActivity extends AppCompatActivity {
private final String TAG=MovieGridActivity.class.getSimpleName();
    //TODO:Add your API key
    private final static String API_KEY="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_grid);

        final GridView gridview=(GridView)findViewById(R.id.gridview);
        ApiInterface apiServices = ApiClient.getClient().create(ApiInterface.class);
        Call<MovieResponse> call = apiServices.getTopRatedMovies(API_KEY);
        final ProgressDialog mprogressDialog=new ProgressDialog(MovieGridActivity.this);
mprogressDialog.setTitle("Loading");
        mprogressDialog.setMessage("Wait while loading");
        mprogressDialog.setCancelable(false);
        mprogressDialog.show();
        call.enqueue(new Callback<MovieResponse>() {

            @Override
            public void onResponse(Response<MovieResponse> response, Retrofit retrofit) {
               final ArrayList<Movie> movies=response.body().getMoviesResult();
mprogressDialog.dismiss();
                gridview.setAdapter(new GridAdapter(MovieGridActivity.this,movies));
                //gridview.setAdapter(new GridAdapter(MovieGridActivity.this,movies));
                gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent i = new Intent(MovieGridActivity.this, DetailActivity.class);
                        String OrignalTitle = movies.get(position).getOriginalTitle();
                        String Overview=movies.get(position).getOverview();
                        String ReleaseDate=movies.get(position).getReleaseDate();
                        String Rating=movies.get(position).getVote();
                        String Posterpath=movies.get(position).getPosterPath();
                        i.putExtra("date",ReleaseDate);
                        i.putExtra("rating",Rating);
                        i.putExtra("poster",Posterpath);
                        i.putExtra("overview",Overview);
                        i.putExtra("title", OrignalTitle);
                        startActivity(i);
                    }
                });


            }

            @Override
            public void onFailure(Throwable t) {
Log.e(TAG,t.toString());
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.action_popular:

                byPopularity();
                return true;
            case R.id.action_rating:
                byRating();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void byRating()
    {
        final GridView gridview=(GridView)findViewById(R.id.gridview);
        ApiInterface apiServices = ApiClient.getClient().create(ApiInterface.class);
        Call<MovieResponse> call = apiServices.getTopRatedMovies(API_KEY);
        final ProgressDialog mprogressDialog=new ProgressDialog(MovieGridActivity.this);
        mprogressDialog.setTitle("Loading");
        mprogressDialog.setMessage("Wait while loading");
        mprogressDialog.setCancelable(false);
        mprogressDialog.show();
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Response<MovieResponse> response, Retrofit retrofit) {
                mprogressDialog.dismiss();
               final ArrayList<Movie> movies=response.body().getMoviesResult();
                gridview.setAdapter(new GridAdapter(MovieGridActivity.this,movies));
                gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent i = new Intent(MovieGridActivity.this, DetailActivity.class);
                        String OrignalTitle = movies.get(position).getOriginalTitle();
                        String Overview=movies.get(position).getOverview();
                        String ReleaseDate=movies.get(position).getReleaseDate();
                        String Rating=movies.get(position).getVote();
                        String Posterpath=movies.get(position).getPosterPath();
                        i.putExtra("date",ReleaseDate);
                        i.putExtra("rating",Rating);
                        i.putExtra("poster",Posterpath);
                        i.putExtra("overview",Overview);
                        i.putExtra("title", OrignalTitle);
                        startActivity(i);
                    }
                });

            }

            @Override
            public void onFailure(Throwable t) {
                Log.e(TAG,t.toString());
            }
        });
    }
    public void byPopularity()
    {
        final GridView gridview=(GridView)findViewById(R.id.gridview);
        ApiInterface apiServices = ApiClient.getClient().create(ApiInterface.class);
        Call<MovieResponse> call = apiServices.getPopular(API_KEY);
        final ProgressDialog mprogressDialog=new ProgressDialog(MovieGridActivity.this);
        mprogressDialog.setTitle("Loading");
        mprogressDialog.setMessage("Wait while loading");
        mprogressDialog.setCancelable(false);
        mprogressDialog.show();
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Response<MovieResponse> response, Retrofit retrofit) {
                mprogressDialog.dismiss();
                final ArrayList<Movie> movies=response.body().getMoviesResult();
                gridview.setAdapter(new GridAdapter(MovieGridActivity.this,movies));
gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i=new Intent(MovieGridActivity.this,DetailActivity.class);
        String OrignalTitle=movies.get(position).getOriginalTitle();
        String Overview=movies.get(position).getOverview();
        String ReleaseDate=movies.get(position).getReleaseDate();
        String Rating=movies.get(position).getVote();
        String Posterpath=movies.get(position).getPosterPath();
        i.putExtra("date",ReleaseDate);
        i.putExtra("rating",Rating);
        i.putExtra("poster",Posterpath);
        i.putExtra("overview",Overview);
        i.putExtra("title",OrignalTitle);
        startActivity(i);
    }
});

            }

            @Override
            public void onFailure(Throwable t) {
                Log.e(TAG,t.toString());
            }
        });
    }
}

