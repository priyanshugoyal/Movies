package com.example.priyanshu.movies.adapter;

import android.content.Context;
import android.util.Log;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.priyanshu.movies.MovieGridActivity;

import com.example.priyanshu.movies.R;
import com.example.priyanshu.movies.model.Movie;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by Priyanshu on 29-May-17.
 */

public class GridAdapter extends BaseAdapter {
    private Context mContext;
    private final String TAG=MovieGridActivity.class.getSimpleName();

    private ArrayList<Movie> movieList=new ArrayList<>();
    public GridAdapter(Context context, ArrayList<Movie> movieList)
    {
        mContext=context;
        this.movieList=movieList;


    }


    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(370, 400));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }
        else
        {
            imageView = (ImageView) convertView;
        }


        String image_path=movieList.get(position).getPosterPath();
        Log.e(TAG,image_path);
        //String image_url="\"http://image.tmdb.org/t/p/w342/"+image_path+"\"";
        String image_url="http://image.tmdb.org/t/p/w185/"+image_path;

        Log.e(TAG,image_url);

        Picasso.with(mContext)
                .load(image_url).resize(300,400).centerCrop()
                .into(imageView);

        return imageView;
    }

    }

