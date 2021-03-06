package com.example.movieadda.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.movieadda.ui.Fragments.CastFragment;
import com.example.movieadda.ui.Fragments.HomeFragment;
import com.example.movieadda.ui.Fragments.InfoFragment;
import com.example.movieadda.ui.Fragments.ReviewsFragment;
import com.example.movieadda.ui.Fragments.SimilarFragment;
import com.example.movieadda.utils.Type;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    String id;
    Type.MovTv type;

    public ViewPagerAdapter(@NonNull FragmentManager fm, String id,Type.MovTv type) {
        super(fm);
        this.id = id;
        this.type=type;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){

            case 0:
                return new InfoFragment(id,type);
            case 1:
                return new CastFragment(id);
            case 2:
                return new ReviewsFragment(id);
            case 3:
                return new SimilarFragment(id, Type.SimilarType.SIMILAR,Type.MovieType.MOVIE);
                default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
    public CharSequence getPageTitle(int position){

        switch (position){
            case 0:
                return "Info";
            case 1:
                return "Cast";
            case 2:
                return "Reviews";
            case 3:
                return "Similar";
                default:
                    return null;
        }
    }
}
