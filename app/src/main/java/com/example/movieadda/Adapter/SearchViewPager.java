package com.example.movieadda.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.movieadda.ui.Fragments.MoviesMoreFragment;
import com.example.movieadda.ui.Fragments.PersonMoreFragment;
import com.example.movieadda.ui.Fragments.ProfileIngoFragment;
import com.example.movieadda.ui.Fragments.ProfileMoviesFragment;
import com.example.movieadda.ui.Fragments.ProfileTvShowsFragment;
import com.example.movieadda.ui.Fragments.SimilarFragment;
import com.example.movieadda.ui.MoreTrendingMoviesActivity;
import com.example.movieadda.utils.Type;

public class SearchViewPager extends FragmentStatePagerAdapter {

  String s;

    public SearchViewPager(@NonNull FragmentManager fm,String s) {
        super(fm);
        this.s=s;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){

            case 0:
                return new MoviesMoreFragment(s,Type.MovieType.SEARCH_MOVIE);
            case 1:
                return new MoviesMoreFragment(s,Type.MovieType.SEARCH_TVSHOW);
            case 2:
                return new PersonMoreFragment(s,Type.MovieType.SEARCH_PERSON);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    public CharSequence getPageTitle(int position){

        switch (position){
            case 0:
                return "Movie";
            case 1:
                return "TV Show";
            case 2:
                return "People";
            default:
                return null;
        }
    }
}
