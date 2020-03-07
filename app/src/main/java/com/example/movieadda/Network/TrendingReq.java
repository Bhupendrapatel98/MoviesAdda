package com.example.movieadda.Network;

import com.example.movieadda.Model.TrendingMoviesReq;
import com.example.movieadda.Model.TrendingPerson;
import com.example.movieadda.Model.TrendingTvShow;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TrendingReq {

    @GET("trending/movie/day")
    Call<TrendingMoviesReq> getTrendingMovie(@Query("api_key") String key);

    @GET("trending/movie/day")
    Call<TrendingMoviesReq> getTrendingMore(@Query("page")String page,@Query("api_key") String key);


    @GET("trending/tv/day")
    Call<TrendingTvShow>getTrendingTvShow(@Query("api_key") String key);

    @GET("trending/tv/day")
    Call<TrendingTvShow>getTrendingTvShowMore(@Query("page") String page,@Query("api_key") String key);

    @GET("trending/person/day")
    Call<TrendingPerson> getTrendingPerson(@Query("api_key") String key);



}
