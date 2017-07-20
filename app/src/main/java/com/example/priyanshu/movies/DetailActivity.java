package com.example.priyanshu.movies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class DetailActivity extends AppCompatActivity {
private TextView titlebox;
    private TextView overviewbox;
    private TextView ratingbox;
    private TextView datebox;
    private ImageView imagebox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String title=getIntent().getExtras().getString("title");
        String overview=getIntent().getExtras().getString("overview");
        String imagepath=getIntent().getExtras().getString("poster");
        String date=getIntent().getExtras().getString("date");
        String rate=getIntent().getExtras().getString("rating");
        overviewbox=(TextView)findViewById(R.id.overview_view);
        titlebox=(TextView)findViewById(R.id.title_view);
        ratingbox=(TextView)findViewById(R.id.rating_view);
        datebox=(TextView)findViewById(R.id.date_view);
        imagebox=(ImageView) findViewById(R.id.imageView);
ratingbox.setText("Rating:"+rate);
        datebox.setText("Release Date:"+date);
        String image_url="http://image.tmdb.org/t/p/w185/"+imagepath;


        Picasso.with(getApplicationContext())
                .load(image_url).resize(80,80)
                .into(imagebox);
        overviewbox.setText(overview);
        titlebox.setText(title);

    }
}
