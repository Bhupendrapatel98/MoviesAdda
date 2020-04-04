package com.example.movieadda.ui.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movieadda.Adapter.MyListMovieAdapter;
import com.example.movieadda.Model.MyList;
import com.example.movieadda.R;
import com.example.movieadda.Room.DatabaseClient;
import com.example.movieadda.utils.Type;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {

    RecyclerView recyclermovie;
    View view;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);

        recyclermovie=view.findViewById(R.id.recyclermovie);

        recyclermovie.setLayoutManager(new LinearLayoutManager(getContext()));

        List<MyList> myLists = DatabaseClient.getInstance(getContext()).getAppDatabase()
                .getmylistdao()
                .getAll(Type.MovTv.MOVIE);

        Log.i("dsvhch", "onCreateView: "+myLists.toString());

        recyclermovie.setAdapter(new MyListMovieAdapter(getContext(),myLists,Type.MovieType.MOVIE));

        return view;
    }

}
