package com.example.movieadda.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.movieadda.Model.Images;
import com.example.movieadda.ui.Fragments.ZoomPhotokFragment;

import java.util.ArrayList;

public class MoviePosterAdapter extends FragmentPagerAdapter {

    String data;

    public MoviePosterAdapter(@NonNull FragmentManager fm,String data) {
        super(fm);
        this.data = data;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return new ZoomPhotokFragment(data);
    }

    @Override
    public int getCount() {
        return data();
    }

    private int data() {
        return 1;
    }
}
