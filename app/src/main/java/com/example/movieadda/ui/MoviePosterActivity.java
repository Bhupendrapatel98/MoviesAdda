package com.example.movieadda.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import com.example.movieadda.Adapter.MoviePosterAdapter;
import com.example.movieadda.Model.Images;
import com.example.movieadda.R;

import java.util.ArrayList;
import java.util.List;

public class MoviePosterActivity extends AppCompatActivity {

    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_poster);

        pager=findViewById(R.id.pager);

//        Intent intent = getIntent();
//        String images = intent.getStringExtra("images");
//        Log.i("cghsdg", "onCreate: "+ images);

        ArrayList<Images> img = (ArrayList<Images>) getIntent().getSerializableExtra("img");
        Log.i("cghsdg", "onCreate: "+ img);

        pager.setAdapter(new MoviePosterAdapter( getSupportFragmentManager(),img));
        Log.i("scffdf", "onCreate: "+img);



    }
}
