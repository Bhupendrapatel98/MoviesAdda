package com.example.movieadda.Network;

import com.example.movieadda.Model.SearchModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchRequest {

    @GET("search/movie")
    Call<SearchModel> getSearchmovie(@Query("api_key")String api_key,@Query("query")String query);

    @GET("search/tv")
    Call<SearchModel> getsearchTv(@Query("page") String page, @Query("query")String query, @Query("api_key")String key);

    @GET("search/person")
    Call<SearchModel> getsearchPerson(@Query("page") String page, @Query("query")String query, @Query("api_key")String key);
}
