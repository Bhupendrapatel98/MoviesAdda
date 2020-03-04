package com.example.movieadda.Network;

import com.example.movieadda.Model.CrewModel;
import com.example.movieadda.Model.PersonModel;
import com.example.movieadda.Model.ProfileImagesModel;
import com.example.movieadda.Model.ProfileInfoModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PersonRequest {

    @GET("person/{person_id}")
    Call<ProfileInfoModel> person(@Path("person_id") String person_id, @Query("api_key")String api_key);

    @GET("person/{person_id}/images")
    Call<ProfileImagesModel> getPersonImages(@Path("person_id") String person_id, @Query("api_key")String api_key);

    @GET("person/{person_id}/movie_credits")
    Call<CrewModel> getPersonMovies(@Path("person_id") String person_id, @Query("api_key")String api_key);
}
