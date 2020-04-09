package com.example.movieadda.ui.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movieadda.Adapter.SimilarAdapter;
import com.example.movieadda.Model.GenerListModel;
import com.example.movieadda.Model.InfoModel;
import com.example.movieadda.Model.PersonMoviesModel;
import com.example.movieadda.Model.Result;
import com.example.movieadda.Model.SimilarModel;
import com.example.movieadda.Network.Constants;
import com.example.movieadda.Network.DiscoverRequest;
import com.example.movieadda.Network.MovieRequest;
import com.example.movieadda.Network.PersonRequest;
import com.example.movieadda.Network.RetrofitClint;
import com.example.movieadda.R;
import com.example.movieadda.Room.DatabaseClient;
import com.example.movieadda.utils.Type;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SimilarFragment extends Fragment {

    String id="";
    Type.SimilarType type;
    Type.MovieType movie;
    RecyclerView similar_recycler;

    public SimilarFragment(String id, Type.SimilarType type,Type.MovieType movie) {
        // Required empty public constructor
        this.id=id;
        this.type = type;
        this.movie=movie;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_similar, container, false);

        similar_recycler = view.findViewById(R.id.similar_recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        similar_recycler.setLayoutManager(layoutManager);

        Log.i("idghnhhjmhj", "onCreateView: "+id);
        Log.i("movieggghgh", "onCreateView: "+type);
        Log.i("movieggghgh", "onCreateView: "+movie);

        if(type == Type.SimilarType.GENER)
        {
            getGenerList();
        }
        else if(type == Type.SimilarType.SIMILAR)
        {
            getSimilarMovies();
        }
        else if(type == Type.SimilarType.PERSON_MOVIE)
        {
            getPersonMovies();
        }
        else if (type==Type.SimilarType.PERSON_TVSHOW){

            getPersonTvShows();
        }

        else if (type==Type.SimilarType.BOOKMARK){

            if (movie == Type.MovieType.MOVIE) {
                getBookmarkMovie();
            }
            else {
                getBookmarkTv();
            }
        }
        else if (type==Type.SimilarType.MY_LIST){

            if (movie == Type.MovieType.TVSHOW) {
                getTvList();
            }
            else {
                getMyList();
            }
        }

        return view;
    }

    private void getBookmarkTv() {

        List<InfoModel> list = DatabaseClient.getInstance(getContext()).getAppDatabase()
                .getForBookmarkDao()
                .getAllBookmarkMovieInfo(Type.MovTv.TVSHOW);

        Log.i("dsfd", "gettvshow: "+list.toString());
        List<Result> results = new ArrayList<>();
        for(InfoModel movieInfo : list){
            Log.i("fhjgjgj", "tvshow: "+234);

            results.add(new Result(movieInfo.getName(),
                    movieInfo.getPosterPath(),
                    movieInfo.getId(),
                    movieInfo.getOriginalTitle(),
                    movieInfo.getReleaseDate(),
                    movieInfo.getVoteAverage()
            ));
        }
        Log.i("sfdgdf", "getBookmarkMovie: "+results.toString());
        SimilarAdapter adapter = new SimilarAdapter(getContext(), results, Type.MovTv.TVSHOW,Type.SimilarType.BOOKMARK);
        similar_recycler.setAdapter(adapter);
    }

    private void getMyList() {
        List<InfoModel> list = DatabaseClient.getInstance(getContext()).getAppDatabase()
                .getMovieInfoDao()
                .getdetail(Type.MovTv.MOVIE,Long.parseLong(id));
        Log.i("fdddv", "getMovieList: "+list);

        List<Result> results = new ArrayList<>();
        for(InfoModel movieInfo : list){
            Log.i("sfdgdf", "getBookmarkMovie: "+546464);

            Log.i("dgdggd", "getMovieList: "+movieInfo.toString());

            results.add(new Result
                    (movieInfo.getTitle(),
                            movieInfo.getPosterPath(),
                            movieInfo.getId(),
                            movieInfo.getOriginalTitle(),
                            movieInfo.getReleaseDate(),
                            movieInfo.getVoteAverage()
                    ));
        }
        SimilarAdapter adapter = new SimilarAdapter(getContext(), results, Type.MovTv.MOVIE,Type.SimilarType.MY_LIST);
        similar_recycler.setAdapter(adapter);

    }

    private void getTvList() {

        List<InfoModel> list =DatabaseClient.getInstance(getContext()).getAppDatabase()
                .getMovieInfoDao()
                .getdetail(Type.MovTv.TVSHOW,Long.parseLong(id));
        Log.i("idhudhfudhf", "tv: "+list);

        List<Result> results = new ArrayList<>();
        for(InfoModel movieInfo : list){
            Log.i("sfdgdf", "getBookmarkMovie: "+546464);

            Log.i("mdcbjsd", "getTvList: "+results);
            results.add(new Result(movieInfo.getName(),
                    movieInfo.getPosterPath(),
                    movieInfo.getId(),
                    movieInfo.getOriginalTitle(),
                    movieInfo.getReleaseDate(),
                    movieInfo.getVoteAverage()
            ));
        }
        SimilarAdapter adapter = new SimilarAdapter(getContext(), results, Type.MovTv.TVSHOW,Type.SimilarType.MY_LIST);
        similar_recycler.setAdapter(adapter);
    }

    private void getBookmarkMovie() {

        List<InfoModel> list = DatabaseClient.getInstance(getContext()).getAppDatabase()
                .getForBookmarkDao()
                .getAllBookmarkMovieInfo(Type.MovTv.MOVIE);

        Log.i("sfdgdf", "getBookmarkMovie: "+list.toString());
        List<Result> results = new ArrayList<>();
        for(InfoModel movieInfo : list){
            Log.i("sfdgdf", "getBookmarkMovie: "+546464);

            results.add(new Result(movieInfo.getTitle(),

                    movieInfo.getPosterPath(),
                    movieInfo.getId(),
                    movieInfo.getOriginalTitle(),
                    movieInfo.getReleaseDate(),
                    movieInfo.getVoteAverage()
            ));
        }
        Log.i("sfdgdf", "getBookmarkMovie: "+results.toString());
        SimilarAdapter adapter = new SimilarAdapter(getContext(), results, Type.MovTv.MOVIE,Type.SimilarType.BOOKMARK);
        similar_recycler.setAdapter(adapter);
        Log.i("sfdgdf", "getBookmarkMovie: "+757565);
    }


    private void getGenerList() {

        RetrofitClint.getRetrofit(Constants.BASE_URL)
                .create(DiscoverRequest.class)
                .getGenerListMovie(Constants.key,id)
                .enqueue(new Callback<GenerListModel>() {
                    @Override
                    public void onResponse(Call<GenerListModel> call, Response<GenerListModel> response) {

                        SimilarAdapter similarAdapter = new SimilarAdapter(getContext(),response.body().getResults(),Type.MovTv.MOVIE, Type.SimilarType.SIMILAR);
                        similar_recycler.setAdapter(similarAdapter);
                    }

                    @Override
                    public void onFailure(Call<GenerListModel> call, Throwable t) {

                    }
                });
    }

    private void getSimilarMovies() {

        RetrofitClint.getRetrofit(Constants.BASE_URL)
                .create(MovieRequest.class)
                .getSimilar(id,Constants.key)
                .enqueue(new Callback<SimilarModel>() {
                    @Override
                    public void onResponse(Call<SimilarModel> call, Response<SimilarModel> response) {

                        Log.i("kjfgbnfkbf", "onResponse: "+id);
                        Log.i("cjnbkjgbg", "onResponse: "+Constants.key);
                        Log.i("bnkbffjjdfdj", "onResponse: "+response.body().getResults());

                        Log.i("kjvbnkjfbfgkb", "onResponse: "+response);


                        SimilarAdapter similarAdapter = new SimilarAdapter(getContext(),response.body().getResults(),Type.MovTv.MOVIE,Type.SimilarType.SIMILAR);
                        similar_recycler.setAdapter(similarAdapter);

                    }

                    @Override
                    public void onFailure(Call<SimilarModel> call, Throwable t) {

                    }
                });
    }
    private void getPersonMovies(){

        RetrofitClint.getRetrofit(Constants.BASE_URL)
                .create(PersonRequest.class)
                .getPerPersonMovies(id,Constants.key)
                .enqueue(new Callback<PersonMoviesModel>() {
                    @Override
                    public void onResponse(Call<PersonMoviesModel> call, Response<PersonMoviesModel> response) {

                        if (response.body() != null) {
                            Log.i("adsfcz", "onResponse: " + response.body());
                            Log.i("adsfcz", "onResponse: " + response.toString());


                            PersonMoviesModel personMovies = response.body();

                            List<Result> casts = personMovies.getCast();
                            List<Result> crews = personMovies.getCrew();

                            List<Result> credit = new ArrayList<>();
                            credit.addAll(casts);
                            credit.addAll(crews);

                            SimilarAdapter similarAdapter = new SimilarAdapter(getContext(), credit, Type.MovTv.MOVIE, Type.SimilarType.SIMILAR);
                            similar_recycler.setAdapter(similarAdapter);
                        }

                    }

                    @Override
                    public void onFailure(Call<PersonMoviesModel> call, Throwable t) {

                    }
                });
    }

    private void getPersonTvShows(){

        RetrofitClint.getRetrofit(Constants.BASE_URL)
                .create(PersonRequest.class)
                .getPersonTvshow(id,Constants.key)
                .enqueue(new Callback<PersonMoviesModel>() {
                    @Override
                    public void onResponse(Call<PersonMoviesModel> call, Response<PersonMoviesModel> response) {

                        if (response.body() != null) {
                            Log.i("adsfcz", "onResponse: " + response.body());
                            Log.i("adsfcz", "onResponse: " + response.toString());


                            PersonMoviesModel personMovies = response.body();

                            List<Result> casts = personMovies.getCast();
                            List<Result> crews = personMovies.getCrew();

                            List<Result> credit = new ArrayList<>();
                            credit.addAll(casts);
                            credit.addAll(crews);

                            SimilarAdapter similarAdapter = new SimilarAdapter(getContext(), credit, Type.MovTv.TVSHOW, Type.SimilarType.SIMILAR);
                            similar_recycler.setAdapter(similarAdapter);
                        }

                    }

                    @Override
                    public void onFailure(Call<PersonMoviesModel> call, Throwable t) {

                    }
                });


    }

}
