package com.example.movieadda.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.movieadda.ui.Fragments.CastFragment;
import com.example.movieadda.ui.Fragments.InfoFragment;
import com.example.movieadda.ui.Fragments.ProfileIngoFragment;
import com.example.movieadda.ui.Fragments.ProfileMoviesFragment;
import com.example.movieadda.ui.Fragments.ProfileTvShowsFragment;
import com.example.movieadda.ui.Fragments.ReviewsFragment;
import com.example.movieadda.ui.Fragments.SimilarFragment;
import com.example.movieadda.utils.Type;

public class ProfileViewPager extends FragmentPagerAdapter {

    String id;

    public ProfileViewPager(@NonNull FragmentManager fm,String id) {
        super(fm);

        this.id=id;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){

            case  0 :
                return new ProfileIngoFragment(id);
            case 1:
               // return new SimilarFragment(id,Type.SimilarType.SIMILAR);
            case 2:
                return new ProfileTvShowsFragment();
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
                return "Info";
            case 1:
                return "Movies";
            case 2:
              return "Tv Shows";
            default:
                return null;
        }
    }
}