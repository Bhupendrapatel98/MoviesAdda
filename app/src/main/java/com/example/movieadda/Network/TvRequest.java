package com.example.movieadda.Network;

import com.example.movieadda.Model.CrewModel;
import com.example.movieadda.Model.InfoModel;
import com.example.movieadda.Model.TrailersModel;
import com.example.movieadda.utils.Type;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TvRequest {

    @GET("tv/{id}/videos")
    Call<TrailersModel> trailer_Detail(@Path("id")String id, @Query("api_key")String key);

    @GET("tv/{id}/credits")
    Call<CrewModel>getCrewRequest(@Path ("id") String id, @Query("api_key") String key);

    @GET("tv/{id}")
    Call<InfoModel> gettvrequest(@Path("id") String id, @Query("api_key") String key);
}
