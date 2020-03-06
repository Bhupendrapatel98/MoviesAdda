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
import com.example.movieadda.utils.Type;
import com.tuyenmonkey.mkloader.MKLoader;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.movieadda.utils.Type.MovieType.TRENDING_MOVIE;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesMoreFragment extends Fragment {

    Type.MovieType type;
    RecyclerView more_recycler;
    MKLoader loader;
    SimilarAdapter adapter;
    int page=1;
    boolean isLoading=false;
    LinearLayoutManager layoutManager;

    public MoviesMoreFragment(Type.MovieType type) {
        // Required empty public constructor
        this.type=type;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movies_more, container, false);

        more_recycler = view.findViewById(R.id.more_recycler);
        loader = view.findViewById(R.id.loader);

         layoutManager = new LinearLayoutManager(getContext());
        more_recycler.setLayoutManager(layoutManager);

        switch (type) {
            case TRENDING_MOVIE:
                trendingMovies();
                break;

            case TRENDING_TVSHOW:
                trendingTvShow();
                break;

            case UPCOMING_MOVIES:
                upcomigMovie();
                break;

            case POPULAR_MOVIES:
                popularMovie();
                break;

            case TOP_MOVIES:
                topRatedMovie();
                break;
        }

        addListner();

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

                         adapter = new SimilarAdapter(getContext(), response.body().getResults());
                        more_recycler.setAdapter(adapter);
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

                        adapter = new SimilarAdapter(getContext(), response.body().getResults());
                        more_recycler.setAdapter(adapter);
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

                        adapter = new SimilarAdapter(getContext(), response.body().getResults());
                        more_recycler.setAdapter(adapter);
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

                         adapter = new SimilarAdapter(getContext(), response.body().getResults());
                        more_recycler.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<TrendingTvShow> call, Throwable t) {


                    }
                });

    }

    public void trendingMovies() {

        RetrofitClint.getRetrofit(Constants.BASE_URL)
                .create(TrendingReq.class)
                .getTrendingMore(""+page,Constants.key)
                .enqueue(new Callback<TrendingMoviesReq>() {
                    @Override
                    public void onResponse(Call<TrendingMoviesReq> call, Response<TrendingMoviesReq> response) {

                        if (page==1) {
                            adapter = new SimilarAdapter(getContext(), response.body().getResults());
                            more_recycler.setAdapter(adapter);
                        }
                        else {
                            adapter.addAllResilu(response.body().getResults());
                        }
                        isLoading =false;
                        page++;
                    }

                    @Override
                    public void onFailure(Call<TrendingMoviesReq> call, Throwable t) {

                    }
                });

    }

    public void addListner(){

            more_recycler.setOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);

                    int total = layoutManager.getItemCount();
                    int firstVisibleItemCount = layoutManager.findFirstVisibleItemPosition();
                    int lastVisibleItemCount = layoutManager.findLastVisibleItemPosition();

                    //to avoid multiple calls to loadMore() method
                    //maintain a boolean value (isLoading). if loadMore() task started set to true and completes set to false
                    if (!isLoading) {
                        if (total > 0)
                            if ((total - 1) == lastVisibleItemCount) {
                                isLoading = true;

                                switch (type) {
                                    case TRENDING_MOVIE:
                                        trendingMovies();
                                        break;

                                    case TRENDING_TVSHOW:
                                        trendingTvShow();
                                        break;

                                    case UPCOMING_MOVIES:
                                        upcomigMovie();
                                        break;

                                    case POPULAR_MOVIES:
                                        popularMovie();
                                        break;

                                    case TOP_MOVIES:
                                        topRatedMovie();
                                        break;
                                }


                            }
                    }
                }

                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);

                }

            });
        }
    }

