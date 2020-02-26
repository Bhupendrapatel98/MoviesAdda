package com.example.movieadda.ui.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.movieadda.Adapter.TrendingMoviesAdapter;
import com.example.movieadda.Model.TrendingMoviesReq;
import com.example.movieadda.Model.TrendingTvShow;
import com.example.movieadda.Network.Constants;
import com.example.movieadda.Network.PostRequest;
import com.example.movieadda.Network.RetrofitClint;
import com.example.movieadda.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private TextView trending_more;
    private RecyclerView trending_recycler,trending_tvs_recycler,upcoming_mov_recycler,popular_mov_recycler,
    top_rat_recycler;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        trending_more = view.findViewById(R.id.trending_more);
        trending_recycler = view.findViewById(R.id.trending_recycler);
        trending_tvs_recycler = view.findViewById(R.id.trending_tvs_recycler);
        upcoming_mov_recycler = view.findViewById(R.id.upcoming_mov_recycler);
        popular_mov_recycler = view.findViewById(R.id.popular_mov_recycler);
        top_rat_recycler = view.findViewById(R.id.top_rat_recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        trending_recycler.setLayoutManager(layoutManager);

        LinearLayoutManager tvshow_layoutManager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        trending_tvs_recycler.setLayoutManager(tvshow_layoutManager);

        LinearLayoutManager upcoming_layoutManager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        upcoming_mov_recycler.setLayoutManager(upcoming_layoutManager);
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
//        popular_mov_recycler.setLayoutManager(layoutManager);
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
//        top_rat_recycler.setLayoutManager(layoutManager);

        trendingMovies();
        trendingTvShow();

       return view;
    }

    private void trendingTvShow() {

        RetrofitClint.getTvShowRetrofit(Constants.BASE_URL)
                .create(PostRequest.class)
                .getTrendingTvShow(Constants.key)
                .enqueue(new Callback<TrendingTvShow>() {
                    @Override
                    public void onResponse(Call<TrendingTvShow> call, Response<TrendingTvShow> response) {
                        Log.i("zmcbsjdhsvj", "onResponse: "+response);
                        Log.i("zmcbsjdhsvj", "onResponse: "+response.body());

                        TrendingMoviesAdapter adapter = new TrendingMoviesAdapter(getContext(),response.body().getResults());
                        trending_tvs_recycler.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<TrendingTvShow> call, Throwable t) {


                    }
                });

    }

    public void trendingMovies(){

        RetrofitClint.getRetrofit(Constants.BASE_URL)
                .create(PostRequest.class)
                .getTrendingMovie(Constants.key)
                .enqueue(new Callback<TrendingMoviesReq>() {
                    @Override
                    public void onResponse(Call<TrendingMoviesReq> call, Response<TrendingMoviesReq> response) {
                        Log.i("jsdhvjsd", "onResponse: "+response);
                        Log.i("jsdhvjsd", "onResponse: "+response.body());

                        TrendingMoviesAdapter adapter = new TrendingMoviesAdapter(getContext(),response.body().getResults());
                        trending_recycler.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<TrendingMoviesReq> call, Throwable t) {

                    }
                });

    }


}
