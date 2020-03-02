package com.example.movieadda.Network;

import com.example.movieadda.Model.GenerListModel;
import com.example.movieadda.Model.UpcomingMovie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DiscoverRequest {

    @GET("discover/movie")
    Call<GenerListModel> getGenerListMovie(@Query("api_key")String key,@Query("with_genres")String with_genres);
}
