package com.example.movieadda.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClint {

    private static Retrofit retrofit;

    private static Retrofit tvshow_retrofit;

    private static Retrofit upcomig_mov_retrofit;

    private static Retrofit popular_mov_retrofit;

    public static Retrofit getRetrofit(String s) {
        if(retrofit == null)
            return   retrofit  = new Retrofit.Builder()
                    .baseUrl(s)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        else
            return retrofit;

    }

    public static Retrofit getTvShowRetrofit(String s) {
        if(retrofit == null)
            return   retrofit  = new Retrofit.Builder()
                    .baseUrl(s)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        else
            return retrofit;

    }

    public static Retrofit upcomig_mov_retrofit(String s) {
        if(retrofit == null)
            return   retrofit  = new Retrofit.Builder()
                    .baseUrl(s)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        else
            return retrofit;

    }
    public static Retrofit popular_mov_retrofit(String s) {
        if(retrofit == null)
            return   retrofit  = new Retrofit.Builder()
                    .baseUrl(s)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        else
            return retrofit;

    }
}
