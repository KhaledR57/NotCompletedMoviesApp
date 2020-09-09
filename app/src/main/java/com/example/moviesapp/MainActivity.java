package com.example.moviesapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieItemClickListener{
    private ViewPager viewPager;
    private ViewPagerAdapter pagerAdapter;
    private RecyclerView bestMoviesRec,moreMoviesRec;
    private BestMoviesAdapter bestMoviesAdapter;
    BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // View Pager Setup
        viewPager = findViewById(R.id.view_pager);

        List<PagerSlide> pagerSlides = new ArrayList<>();
        pagerSlides.add(new PagerSlide(R.drawable.blade,"Title","Lorem ipsum dolor sit amet, adipiscing elit."));
        pagerSlides.add(new PagerSlide(R.drawable.star,"Title","fLorem ipsum dolor sit amet, adipiscing elit."));

        pagerAdapter = new ViewPagerAdapter(this,pagerSlides);
        viewPager.setAdapter(pagerAdapter);
        //End View Pager Setup


        //Recycler View Setup
        bestMoviesRec = findViewById(R.id.rec_best_movies);

        List<Movies> moviesList = new ArrayList<>();
        moviesList.add(new Movies("2017",R.drawable.logan,"137 min","Logan"));
        moviesList.add(new Movies("2019",R.drawable.irishman,"209 min","The Irishman"));
        moviesList.add(new Movies("2008",R.drawable.batman,"152 min","The Dark Knight"));
        moviesList.add(new Movies("2011",R.drawable.harrypotter,"130 min","Harry Potter"));
        moviesList.add(new Movies("2017",R.drawable.blade_runner,"117 min","Blade Runner"));
        moviesList.add(new Movies("2018",R.drawable.spiderman,"117 min","Spider-Man: Into the Spider-Verse"));
        moviesList.add(new Movies("2019",R.drawable.star_wars,"142 min","Star Wars"));
        moviesList.add(new Movies("2019",R.drawable.joker,"122 min","Joker"));
        moviesList.add(new Movies("2019",R.drawable.avengers,"181 min","Avengers: Endgame"));
        moviesList.add(new Movies("1972",R.drawable.thegodfather,"175 min","The Godfather"));

        bestMoviesAdapter = new BestMoviesAdapter(this,moviesList,this);
        bestMoviesRec.setAdapter(bestMoviesAdapter);

        bestMoviesRec.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        //End Recycler View Setup


        //another Recycler View Setup
        moreMoviesRec = findViewById(R.id.rec_more_movies);

        List<Movies> moviesList2 = new ArrayList<>();
        moviesList2.add(new Movies("2018",R.drawable.spiderman,"117 min","Spider-Man: Into the Spider-Verse"));
        moviesList2.add(new Movies("2011",R.drawable.harrypotter,"130 min","Harry Potter"));
        moviesList2.add(new Movies("2019",R.drawable.avengers,"181 min","Avengers: Endgame"));
        moviesList2.add(new Movies("2019",R.drawable.joker,"122 min","Joker"));
        moviesList2.add(new Movies("2019",R.drawable.irishman,"209 min","The Irishman"));
        moviesList2.add(new Movies("2019",R.drawable.star_wars,"142 min","Star Wars"));
        moviesList2.add(new Movies("2017",R.drawable.blade_runner,"117 min","Blade Runner"));
        moviesList2.add(new Movies("2008",R.drawable.batman,"152 min","The Dark Knight"));
        moviesList2.add(new Movies("1972",R.drawable.thegodfather,"175 min","The Godfather"));
        moviesList2.add(new Movies("2017",R.drawable.logan,"137 min","Logan"));


        MoreMoviesAdapter moreMoviesAdapter = new MoreMoviesAdapter(this,moviesList2);
        moreMoviesRec.setAdapter(moreMoviesAdapter);

        moreMoviesRec.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        //End Recycler View Setup

        //Bottom Navigation Setup
        bottomNavigation = findViewById(R.id.bottom_nav);
        ScrollView namebar = findViewById(R.id.scroll_View);
        ((ViewGroup) namebar.getParent()).removeView(namebar);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new HomeFragment()).commit();
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = new HomeFragment();

                switch(item.getItemId()){
                    case R.id.bottom_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.bottom_search:
                        fragment = new SearchFragment();
                        break;
                    case R.id.bottom_settings:
                        fragment = new SettingsFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).commit();
                return true;
            }
        });
        //End Bottom Navigation Setup

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onMovieClick(Movies movies, ImageView imageView) {
        Intent intent = new Intent(MainActivity.this,MovieDetailsActivity.class);
        intent.putExtra("posterURL",movies.getPoster());
        intent.putExtra("Year",movies.getYear());
        intent.putExtra("Plot",movies.getPlot());
        intent.putExtra("Director",movies.getDirector());
        intent.putExtra("Run Time",movies.getRunTime());
        intent.putExtra("Title",movies.getTitle());
        // Animation
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,imageView,"HomeToDetails");
        startActivity(intent,options.toBundle());
    }
}
