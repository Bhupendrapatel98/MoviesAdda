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
import com.example.movieadda.Model.ReviewModel;
import com.example.movieadda.Model.SimilarModel;
import com.example.movieadda.Network.Constants;
import com.example.movieadda.Network.MovieRequest;
import com.example.movieadda.Network.RetrofitClint;
import com.example.movieadda.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SimilarFragment extends Fragment {

    String id;
    RecyclerView similar_recycler;

    public SimilarFragment(String id) {
        // Required empty public constructor
        this.id=id;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_similar, container, false);

        similar_recycler = view.findViewById(R.id.similar_recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        similar_recycler.setLayoutManager(layoutManager);

        getSimilarMovies();

        return view;
    }

    private void getSimilarMovies() {

        RetrofitClint.getRetrofit(Constants.BASE_URL)
                .create(MovieRequest.class)
                .getSimilar(id,Constants.key)
                .enqueue(new Callback<SimilarModel>() {
                    @Override
                    public void onResponse(Call<SimilarModel> call, Response<SimilarModel> response) {

                        SimilarAdapter similarAdapter = new SimilarAdapter(getContext(),response.body().getResults());
                        similar_recycler.setAdapter(similarAdapter);

                    }

                    @Override
                    public void onFailure(Call<SimilarModel> call, Throwable t) {

                    }
                });
    }

}
