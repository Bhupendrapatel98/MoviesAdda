package com.example.movieadda.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.movieadda.R;
import com.example.movieadda.ui.Fragments.HomeFragment;
import com.example.movieadda.ui.Fragments.MoviesMoreFragment;
import com.example.movieadda.utils.Type;

public class MoreTrendingMoviesActivity extends AppCompatActivity {

    FrameLayout tren_movie_frame;
    Type.MovieType type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_trending_movies);

        tren_movie_frame = findViewById(R.id.tren_movie_frame);

         type =(Type.MovieType) getIntent().getSerializableExtra("movie_key");

        replace(new MoviesMoreFragment(type));

    }

    void replace(Fragment fragment){
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.tren_movie_frame,fragment);
        ft.commit();
    }
}
