package com.example.movieadda.Network;

import com.example.movieadda.Model.CrewModel;
import com.example.movieadda.Model.InfoModel;
import com.example.movieadda.Model.PopularMovie;
import com.example.movieadda.Model.ReviewModel;
import com.example.movieadda.Model.SimilarModel;
import com.example.movieadda.Model.TopRAted;
import com.example.movieadda.Model.TrailersModel;
import com.example.movieadda.Model.UpcomingMovie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieRequest {

    @GET("movie/upcoming")
    Call<UpcomingMovie> getUpcomingMovie(@Query("api_key")String key);

    @GET("movie/popular")
    Call<PopularMovie>getPopularMovie(@Query("api_key")String key);

    @GET("movie/top_rated")
    Call<TopRAted>getTopRatedMovie(@Query("api_key")String key);

    @GET("movie/{id}")
    Call<InfoModel>allDetail(@Path("id")String id,@Query("api_key")String key);

    @GET("movie/{id}/credits")
    Call<CrewModel> crewDetail(@Path("id")String id,@Query("api_key")String key);

    @GET("movie/{id}/videos")
    Call<TrailersModel> trail_Detail(@Path("id")String id, @Query("api_key")String key);

    @GET("movie/{id}/reviews")
    Call<ReviewModel> reviews(@Path("id")String id, @Query("api_key")String key);

    @GET("movie/{id}/similar")
    Call<SimilarModel> getSimilar(@Path("id")String id, @Query("api_key")String key);


}
