package com.example.movieadda.Network;

import com.example.movieadda.Model.PersonModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PersonRequest {

    @GET("person/{person_id}")
    Call<PersonModel> person(@Path("person_id") int person_id, @Query("api_key")String api_key);
}
