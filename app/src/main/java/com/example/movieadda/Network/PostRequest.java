package com.example.movieadda.Network;

import com.example.movieadda.Model.PopularMovie;
import com.example.movieadda.Model.TopRAted;
import com.example.movieadda.Model.TrendingMoviesReq;
import com.example.movieadda.Model.TrendingTvShow;
import com.example.movieadda.Model.UpcomingMovie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PostRequest {

    @GET("trending/movie/day")
    Call<TrendingMoviesReq>getTrendingMovie(@Query("api_key") String key);

    @GET("trending/tv/day")
    Call<TrendingTvShow>getTrendingTvShow(@Query("api_key") String key);

    @GET("movie/upcoming")
    Call<UpcomingMovie>getUpcomingMovie(@Query("api_key")String key);

    @GET("movie/popular")
    Call<PopularMovie>getPopularMovie(@Query("api_key")String key);

    @GET("movie/top_rated")
    Call<TopRAted>getTopRatedMovie(@Query("api_key")String key);



}
