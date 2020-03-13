package com.example.movieadda.ui.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movieadda.Adapter.SimilarAdapter;
import com.example.movieadda.Model.GenerListModel;
import com.example.movieadda.Model.ReviewModel;
import com.example.movieadda.Model.SimilarModel;
import com.example.movieadda.Model.UpcomingMovie;
import com.example.movieadda.Network.Constants;
import com.example.movieadda.Network.DiscoverRequest;
import com.example.movieadda.Network.MovieRequest;
import com.example.movieadda.Network.RetrofitClint;
import com.example.movieadda.R;
import com.example.movieadda.utils.Type;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SimilarFragment extends Fragment {

    String id;
    Type.SimilarType type;
    Type.MovTv movie;
    RecyclerView similar_recycler;

    public SimilarFragment(String id, Type.SimilarType type,Type.MovTv movie) {
        // Required empty public constructor
        this.id=id;
        this.type = type;
        this.movie=movie;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_similar, container, false);

        similar_recycler = view.findViewById(R.id.similar_recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        similar_recycler.setLayoutManager(layoutManager);


        if(type == Type.SimilarType.GENER)
        {
            getGenerList();
        }
        else if(type == Type.SimilarType.SIMILAR)
        {
            getSimilarMovies();
        }
        else if (movie==Type.MovTv.MOVIE)
        {
            getSimilarMovies();
        }


        return view;
    }

    private void getGenerList() {

        RetrofitClint.getRetrofit(Constants.BASE_URL)
                .create(DiscoverRequest.class)
                .getGenerListMovie(Constants.key,id)
                .enqueue(new Callback<GenerListModel>() {
                    @Override
                    public void onResponse(Call<GenerListModel> call, Response<GenerListModel> response) {

                        SimilarAdapter similarAdapter = new SimilarAdapter(getContext(),response.body().getResults(),Type.MovTv.MOVIE);
                        similar_recycler.setAdapter(similarAdapter);
                    }

                    @Override
                    public void onFailure(Call<GenerListModel> call, Throwable t) {

                    }
                });
    }

    private void getSimilarMovies() {

        RetrofitClint.getRetrofit(Constants.BASE_URL)
                .create(MovieRequest.class)
                .getSimilar(id,Constants.key)
                .enqueue(new Callback<SimilarModel>() {
                    @Override
                    public void onResponse(Call<SimilarModel> call, Response<SimilarModel> response) {

                        Log.i("bnkbffjjdfdj", "onResponse: "+response.body().getResults());

                        SimilarAdapter similarAdapter = new SimilarAdapter(getContext(),response.body().getResults(),Type.MovTv.MOVIE);
                        similar_recycler.setAdapter(similarAdapter);

                    }

                    @Override
                    public void onFailure(Call<SimilarModel> call, Throwable t) {

                    }
                });
    }

}
