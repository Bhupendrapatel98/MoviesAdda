package com.example.movieadda.ui.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movieadda.Adapter.ReviewsAdapter;
import com.example.movieadda.Model.ReviewModel;
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
public class ReviewsFragment extends Fragment {

    RecyclerView review_recycler;
    String id;
    public ReviewsFragment(String id) {
        // Required empty public constructor
        this.id=id;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reviews, container, false);

        review_recycler = view.findViewById(R.id.review_recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        review_recycler.setLayoutManager(layoutManager);

        getReview();

        return  view;
    }

    private void getReview() {

        RetrofitClint.getRetrofit(Constants.BASE_URL)
                .create(MovieRequest.class)
                .reviews(id,Constants.key)
                .enqueue(new Callback<ReviewModel>() {
                    @Override
                    public void onResponse(Call<ReviewModel> call, Response<ReviewModel> response) {
                        Log.i("nbdnds", "onResponse: "+response.body());
                        Log.i("nbdnds", "onResponse: "+response);

                        ReviewsAdapter reviewsAdapter = new ReviewsAdapter(getContext(),response.body().getResults());
                        review_recycler.setAdapter(reviewsAdapter);
                    }

                    @Override
                    public void onFailure(Call<ReviewModel> call, Throwable t) {

                    }
                });
    }

}
