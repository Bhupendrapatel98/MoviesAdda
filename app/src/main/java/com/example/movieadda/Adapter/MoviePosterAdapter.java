package com.example.movieadda.Adapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.movieadda.Model.Images;
import com.example.movieadda.ui.Fragments.ZoomPhotokFragment;

import java.util.ArrayList;

public class MoviePosterAdapter extends FragmentPagerAdapter {

    ArrayList<Images> data;

    public MoviePosterAdapter(@NonNull FragmentManager fm, ArrayList<Images> data) {
        super(fm);
        this.data = data;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Log.i("vjbgjbngbkg", "getItem: "+data);
        return new ZoomPhotokFragment(data.get(position).getFilePath());
    }

    @Override
    public int getCount() {
        return data.size();
    }

}
