package com.example.movieadda.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.movieadda.ui.Fragments.MovieFragment;
import com.example.movieadda.ui.Fragments.TvshowFragment;
import com.example.movieadda.utils.Type;

public class MyListAdapter extends FragmentStatePagerAdapter {


    public MyListAdapter(@NonNull FragmentManager fm) {
        super(fm);
       }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                return new MovieFragment();

            case 1:
                return new TvshowFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Movie";
            case 1:
                return "Tv Show";
            default:
                return null;

        }
    }

}
