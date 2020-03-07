package com.example.movieadda.ui.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movieadda.Adapter.MainSliderAdapter;
import com.example.movieadda.Adapter.TrendingMoviesAdapter;
import com.example.movieadda.Adapter.TrendingPersonAdapter;
import com.example.movieadda.Model.PopularMovie;
import com.example.movieadda.Model.TopRAted;
import com.example.movieadda.Model.TrendingMoviesReq;
import com.example.movieadda.Model.TrendingPerson;
import com.example.movieadda.Model.TrendingTvShow;
import com.example.movieadda.Model.UpcomingMovie;
import com.example.movieadda.Network.Constants;
import com.example.movieadda.Network.MovieRequest;
import com.example.movieadda.Network.RetrofitClint;
import com.example.movieadda.Network.TrendingReq;
import com.example.movieadda.R;
import com.example.movieadda.ui.AllDetailActivity;
import com.example.movieadda.ui.MoreTrendingMoviesActivity;
import com.example.movieadda.ui.MoreTrendingPersonActivity;
import com.example.movieadda.utils.PicassoImageLoadingService;
import com.example.movieadda.utils.Type;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ss.com.bannerslider.Slider;
import ss.com.bannerslider.event.OnSlideClickListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private TextView trending_per_more,trending_mov_more,trending_tvs_more,upcoming_mov_more,popular_mov_more,top_rat_more;
    private RecyclerView trending_recycler, trending_tvs_recycler, upcoming_mov_recycler, popular_mov_recycler,
            top_rat_recycler,trending_person_recycler;
    private ImageView search;
    private Slider banner_slider;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        trending_per_more = view.findViewById(R.id.trending_per_more);
        trending_mov_more = view.findViewById(R.id.trending_mov_more);
        trending_tvs_more = view.findViewById(R.id.trending_tvs_more);
        upcoming_mov_more = view.findViewById(R.id.upcoming_mov_more);
        popular_mov_more = view.findViewById(R.id.popular_mov_more);
        top_rat_more = view.findViewById(R.id.top_rat_more);
        search = view.findViewById(R.id.search);
        banner_slider = view.findViewById(R.id.banner_slider);

        trending_recycler = view.findViewById(R.id.trending_recycler);
        trending_tvs_recycler = view.findViewById(R.id.trending_tvs_recycler);
        upcoming_mov_recycler = view.findViewById(R.id.upcoming_mov_recycler);
        popular_mov_recycler = view.findViewById(R.id.popular_mov_recycler);
        top_rat_recycler = view.findViewById(R.id.top_rat_recycler);
        trending_person_recycler = view.findViewById(R.id.trending_person_recycler);

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

        LinearLayoutManager trending_person_layoutManager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        trending_person_recycler.setLayoutManager(trending_person_layoutManager);

        //slider
        Slider.init(new PicassoImageLoadingService(getContext()));

        trending_per_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),MoreTrendingPersonActivity.class);
                intent.putExtra("movie_key",Type.MovieType.TRENDING_PERSON);
                startActivity(intent);
            }
        });

        trending_mov_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(getContext(),MoreTrendingMoviesActivity.class);
               intent.putExtra("movie_key",Type.MovieType.TRENDING_MOVIE);
               startActivity(intent);
            }
        });

        trending_tvs_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),MoreTrendingMoviesActivity.class);
                intent.putExtra("movie_key",Type.MovieType.TRENDING_TVSHOW);
                startActivity(intent);
            }
        });
        upcoming_mov_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),MoreTrendingMoviesActivity.class);
                intent.putExtra("movie_key",Type.MovieType.UPCOMING_MOVIES);
                startActivity(intent);
            }
        });
        popular_mov_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),MoreTrendingMoviesActivity.class);
                intent.putExtra("movie_key",Type.MovieType.POPULAR_MOVIES);
                startActivity(intent);
            }
        });
        top_rat_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),MoreTrendingMoviesActivity.class);
                intent.putExtra("movie_key",Type.MovieType.TOP_MOVIES);
                startActivity(intent);
            }
        });


        trendingMovies();
        trendingTvShow();
        upcomigMovie();
        popularMovie();
        topRatedMovie();
        trendingPerson();

        return view;
    }

    private void trendingPerson() {

        RetrofitClint.getRetrofit(Constants.BASE_URL)
                .create(TrendingReq.class)
                .getTrendingPerson(Constants.key)
                .enqueue(new Callback<TrendingPerson>() {
                    @Override
                    public void onResponse(Call<TrendingPerson> call, Response<TrendingPerson> response) {

                        Log.i("msdjbshj", "onResponse: "+response);
                        Log.i("msdjbshj", "onResponse: "+response.body());

                        TrendingPersonAdapter trendingPersonAdapter = new TrendingPersonAdapter(response.body().getResults(),getContext());
                        trending_person_recycler.setAdapter(trendingPersonAdapter);
                    }

                    @Override
                    public void onFailure(Call<TrendingPerson> call, Throwable t) {

                    }
                });
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

                        TrendingMoviesAdapter adapter = new TrendingMoviesAdapter(getContext(), response.body().getResults(),Type.MovieType.TOP_MOVIES);
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

                        TrendingMoviesAdapter adapter = new TrendingMoviesAdapter(getContext(), response.body().getResults(),Type.MovieType.POPULAR_MOVIES);
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
                    public void onResponse(Call<UpcomingMovie> call, final Response<UpcomingMovie> response) {
                        Log.i("msbfcsjdh", "onResponse: " + response);
                        Log.i("msbfcsjdh", "onResponse: " + response.body());

                        upcoming_mov_recycler.setAdapter(new TrendingMoviesAdapter(getContext(), response.body().getResults(),Type.MovieType.UPCOMING_MOVIES));

                        banner_slider.setAdapter(new MainSliderAdapter(response.body().getResults()));

                        banner_slider.setOnSlideClickListener(new OnSlideClickListener() {
                            @Override
                            public void onSlideClick(int position) {

                                Intent intent=new Intent(getContext(), AllDetailActivity.class);
                                intent.putExtra("id",response.body().getResults().get(position).getId()+"");
                                intent.putExtra("type",Type.MovieType.UPCOMING_MOVIES);
                                startActivity(intent);
                            }
                        });
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

                        TrendingMoviesAdapter adapter = new TrendingMoviesAdapter(getContext(), response.body().getResults(),Type.MovieType.TRENDING_TVSHOW);
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

                        TrendingMoviesAdapter adapter = new TrendingMoviesAdapter(getContext(), response.body().getResults(),Type.MovieType.TRENDING_MOVIE);
                        trending_recycler.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<TrendingMoviesReq> call, Throwable t) {

                    }
                });

    }


}
