package com.example.movieadda.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.movieadda.Adapter.MoviePosterAdapter;
import com.example.movieadda.Model.Images;
import com.example.movieadda.R;

import java.util.ArrayList;

public class MoviePosterActivity extends AppCompatActivity {

    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_poster);

        pager=findViewById(R.id.pager);

        Intent intent = getIntent();
        String images = intent.getStringExtra("images");
        Log.i("cghsdg", "onCreate: "+ images);

        pager.setAdapter(new MoviePosterAdapter( getSupportFragmentManager(),images));
        Log.i("scffdf", "onCreate: "+images);



    }
}
