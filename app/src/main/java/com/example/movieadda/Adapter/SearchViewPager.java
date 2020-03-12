package com.example.movieadda.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.movieadda.ui.Fragments.MoviesMoreFragment;
import com.example.movieadda.ui.Fragments.PersonMoreFragment;
import com.example.movieadda.ui.Fragments.ProfileIngoFragment;
import com.example.movieadda.ui.Fragments.ProfileMoviesFragment;
import com.example.movieadda.ui.Fragments.ProfileTvShowsFragment;
import com.example.movieadda.ui.Fragments.SimilarFragment;
import com.example.movieadda.utils.Type;

public class SearchViewPager extends FragmentPagerAdapter {

  String s;

    public SearchViewPager(@NonNull FragmentManager fm,String s) {
        super(fm);
        this.s=s;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){

            case  0 :
                return new SimilarFragment(s,Type.SimilarType.SIMILAR,Type.MovTv.MOVIE);
            case 1:
                return new SimilarFragment(s,Type.SimilarType.GENER,Type.MovTv.MOVIE);
            case 2:
                //return new PersonMoreFragment();
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
//                return "People";
            default:
                return null;
        }
    }
}
