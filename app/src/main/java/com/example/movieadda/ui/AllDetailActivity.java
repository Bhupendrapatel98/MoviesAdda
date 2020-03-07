package com.example.movieadda.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.example.movieadda.Adapter.ViewPagerAdapter;
import com.example.movieadda.R;
import com.example.movieadda.utils.Type;
import com.google.android.material.tabs.TabLayout;

public class AllDetailActivity extends AppCompatActivity {

    TabLayout tablayout;
    ViewPager viewpager;
    String id;
    Type.MovieType type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_detail);

        tablayout = findViewById(R.id.tablayout);
        viewpager = findViewById(R.id.viewpager);

        Intent intent = getIntent();
         id = intent.getStringExtra("key_id");

         Type.MovieType type = (Type.MovieType) getIntent().getSerializableExtra("type");



        viewpager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(),id));
        tablayout.setupWithViewPager(viewpager);

    }
}
