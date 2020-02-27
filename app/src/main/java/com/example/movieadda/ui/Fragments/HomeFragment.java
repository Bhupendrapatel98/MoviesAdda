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
import com.example.movieadda.Model.PopularMovie;
import com.example.movieadda.Model.TopRAted;
import com.example.movieadda.Model.TrendingMoviesReq;
import com.example.movieadda.Model.TrendingTvShow;
import com.example.movieadda.Model.UpcomingMovie;
import com.example.movieadda.Network.Constants;
import com.example.movieadda.Network.MovieRequest;
import com.example.movieadda.Network.RetrofitClint;
import com.example.movieadda.Network.TrendingReq;
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
    private RecyclerView trending_recycler, trending_tvs_recycler, upcoming_mov_recycler, popular_mov_recycler,
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

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        trending_recycler.setLayoutManager(layoutManager);

        LinearLayoutManager tvshow_layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        trending_tvs_recycler.setLayoutManager(tvshow_layoutManager);

        LinearLayoutManager upcoming_layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        upcoming_mov_recycler.setLayoutManager(upcoming_layoutManager);

        LinearLayoutManager popular_layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        popular_mov_recycler.setLayoutManager(popular_layoutManager);

        LinearLayoutManager top_rate_layoutManager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        top_rat_recycler.setLayoutManager(top_rate_layoutManager);

        trendingMovies();
        trendingTvShow();
        upcomigMovie();
        popularMovie();
        topRatedMovie();

        return view;
    }

    private void topRatedMovie() {

        RetrofitClint.getRetrofit(Constants.BASE_URL)
                .create(MovieRequest.class)
                .getTopRatedMovie(Constants.key)
                .enqueue(new Callback<TopRAted>() {
                    @Override
                    public void onResponse(Call<TopRAted> call, Response<TopRAted> response) {

                        Log.i("msbfcsjdh", "onResponse: " + response);
                        Log.i("msbfcsjdh", "onResponse: " + response.body());

                        TrendingMoviesAdapter adapter = new TrendingMoviesAdapter(getContext(), response.body().getResults());
                        top_rat_recycler.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<TopRAted> call, Throwable t) {

                    }
                });
    }

    private void popularMovie() {

        RetrofitClint.getRetrofit(Constants.BASE_URL)
                .create(MovieRequest.class)
                .getPopularMovie(Constants.key)
                .enqueue(new Callback<PopularMovie>() {
                    @Override
                    public void onResponse(Call<PopularMovie> call, Response<PopularMovie> response) {
                        Log.i("msbfcsjdh", "onResponse: " + response);
                        Log.i("msbfcsjdh", "onResponse: " + response.body());

                        TrendingMoviesAdapter adapter = new TrendingMoviesAdapter(getContext(), response.body().getResults());
                        popular_mov_recycler.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<PopularMovie> call, Throwable t) {

                    }
                });
    }

    private void upcomigMovie() {

        RetrofitClint.getRetrofit(Constants.BASE_URL)
                .create(MovieRequest.class)
                .getUpcomingMovie(Constants.key)
                .enqueue(new Callback<UpcomingMovie>() {
                    @Override
                    public void onResponse(Call<UpcomingMovie> call, Response<UpcomingMovie> response) {
                        Log.i("msbfcsjdh", "onResponse: " + response);
                        Log.i("msbfcsjdh", "onResponse: " + response.body());

                        TrendingMoviesAdapter adapter = new TrendingMoviesAdapter(getContext(), response.body().getResults());
                        upcoming_mov_recycler.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<UpcomingMovie> call, Throwable t) {

                    }
                });
    }

    private void trendingTvShow() {

        RetrofitClint.getRetrofit(Constants.BASE_URL)
                .create(TrendingReq.class)
                .getTrendingTvShow(Constants.key)
                .enqueue(new Callback<TrendingTvShow>() {
                    @Override
                    public void onResponse(Call<TrendingTvShow> call, Response<TrendingTvShow> response) {
                        Log.i("zmcbsjdhsvj", "onResponse: " + response);
                        Log.i("zmcbsjdhsvj", "onResponse: " + response.body());

                        TrendingMoviesAdapter adapter = new TrendingMoviesAdapter(getContext(), response.body().getResults());
                        trending_tvs_recycler.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<TrendingTvShow> call, Throwable t) {


                    }
                });

    }

    public void trendingMovies() {

        RetrofitClint.getRetrofit(Constants.BASE_URL)
                .create(TrendingReq.class)
                .getTrendingMovie(Constants.key)
                .enqueue(new Callback<TrendingMoviesReq>() {
                    @Override
                    public void onResponse(Call<TrendingMoviesReq> call, Response<TrendingMoviesReq> response) {
                        Log.i("jsdhvjsd", "onResponse: " + response);
                        Log.i("jsdhvjsd", "onResponse: " + response.body());

                        TrendingMoviesAdapter adapter = new TrendingMoviesAdapter(getContext(), response.body().getResults());
                        trending_recycler.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<TrendingMoviesReq> call, Throwable t) {

                    }
                });

    }


}
