package com.example.moviesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieDetailsActivity extends AppCompatActivity {

    private ImageView thumbnailImage,bannerImage;
    private TextView movieName,movieYear,runTime;
    private RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        thumbnailImage = findViewById(R.id.movie_thumbnail);
        bannerImage = findViewById(R.id.movie_banner);
        movieYear = findViewById(R.id.movie_year);
        movieName = findViewById(R.id.movie_name);
        ratingBar = findViewById(R.id.rating_bar);

        int thumbnailURL = getIntent().getExtras().getInt("posterURL");
        String year = getIntent().getExtras().getString("Year");
        String Plot = getIntent().getExtras().getString("Plot");
        String Director = getIntent().getExtras().getString("Director");
        String RunTime = getIntent().getExtras().getString("Run Time");
        String Title = getIntent().getExtras().getString("Title");

        thumbnailImage.setImageResource(thumbnailURL);
        bannerImage.setImageResource(thumbnailURL);
        //Picasso.get().load(thumbnailURL).into(bannerImage);
        movieName.setText(Title);
        movieYear.setText(year);

        ratingBar.setRating(4);
    }
}
