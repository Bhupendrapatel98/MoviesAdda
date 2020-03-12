package com.example.movieadda.ui.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.movieadda.Network.Constants;
import com.example.movieadda.Network.RetrofitClint;
import com.example.movieadda.Network.SearchRequest;
import com.example.movieadda.R;
import com.example.movieadda.ui.MoreTrendingMoviesActivity;
import com.example.movieadda.ui.MoreTrendingPersonActivity;
import com.example.movieadda.ui.SearchActivity;
import com.example.movieadda.utils.Type;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    ImageView s_movies,s_tvShow,s_persons;
    LinearLayout fsearch;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        s_movies = view.findViewById(R.id.s_movies);
        s_tvShow = view.findViewById(R.id.s_tvShow);
        s_persons = view.findViewById(R.id.s_persons);
        fsearch = view.findViewById(R.id.fsearch);

        s_movies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MoreTrendingMoviesActivity.class);
                intent.putExtra("movie_key", Type.MovieType.TRENDING_MOVIE);
                startActivity(intent);
            }
        });
        s_tvShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MoreTrendingMoviesActivity.class);
                intent.putExtra("movie_key", Type.MovieType.TRENDING_TVSHOW);
                startActivity(intent);
            }
        });
        s_persons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),MoreTrendingPersonActivity.class);
                intent.putExtra("movie_key", Type.MovieType.TRENDING_PERSON);
                startActivity(intent);
            }
        });

        fsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });



        return view;
    }
}
