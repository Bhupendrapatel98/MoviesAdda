package com.example.movieadda.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClint {

    private static Retrofit retrofit;


    public static Retrofit getRetrofit(String s) {
        if(retrofit == null)
            return   retrofit  = new Retrofit.Builder()
                    .baseUrl(s)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        else
            return retrofit;

    }

}
