package com.example.movieadda.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import com.example.movieadda.Adapter.ProfileViewPager;
import com.example.movieadda.Adapter.ViewPagerAdapter;
import com.example.movieadda.R;
import com.google.android.material.tabs.TabLayout;

public class ProfileActivity extends AppCompatActivity {

    TabLayout profile_tablayout;
    ViewPager profile_viewpager;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profile_tablayout = findViewById(R.id.profile_tablayout);
        profile_viewpager = findViewById(R.id.profile_viewpager);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        Log.i("sdjnk", "onCreate: "+id);
        String nam= getIntent().getStringExtra("name");
        String photo= getIntent().getStringExtra("photo");

        profile_viewpager.setAdapter(new ProfileViewPager(getSupportFragmentManager(),id));
        profile_tablayout.setupWithViewPager(profile_viewpager);
    }
}
