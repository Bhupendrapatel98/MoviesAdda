package com.example.movieadda.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.movieadda.R;
import com.example.movieadda.ui.Fragments.MoviesMoreFragment;
import com.example.movieadda.ui.Fragments.PersonMoreFragment;
import com.example.movieadda.utils.Type;

public class MoreTrendingPersonActivity extends AppCompatActivity {

    FrameLayout tren_per_frame;
    Type.MovieType type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_trending_person);

        tren_per_frame = findViewById(R.id.tren_per_frame);

        type =(Type.MovieType) getIntent().getSerializableExtra("movie_key");

        replace(new PersonMoreFragment("",type));

    }

    void replace(Fragment fragment){
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.tren_per_frame,fragment);
        ft.commit();
    }
}
