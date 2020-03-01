package com.example.movieadda.ui.Fragments;


import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.renderscript.Sampler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movieadda.Adapter.BtnAdaapter;
import com.example.movieadda.Adapter.CrewAdapter;
import com.example.movieadda.Adapter.TrailersAdapter;
import com.example.movieadda.Model.CrewModel;
import com.example.movieadda.Model.InfoModel;
import com.example.movieadda.Model.TopRAted;
import com.example.movieadda.Model.TrailersModel;
import com.example.movieadda.Network.Constants;
import com.example.movieadda.Network.MovieRequest;
import com.example.movieadda.Network.RetrofitClint;
import com.example.movieadda.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment {

    TextView overview,fact_title,status,runtime,release,language,budget,revenue;
    String id;
    RecyclerView btn_recycler,crew_recycler,trailer_recycler;
    TextView production_com_name,top_title;
    ImageView backdrop_path,poster_path;


    public InfoFragment(String id) {
        // Required empty public constructor
        this.id = id;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        overview = view.findViewById(R.id.overview);
        btn_recycler = view.findViewById(R.id.btn_recycler);
        crew_recycler = view.findViewById(R.id.crew_recycler);
        trailer_recycler = view.findViewById(R.id.trailer_recycler);
        production_com_name = view.findViewById(R.id.production_com_name);
        fact_title = view.findViewById(R.id.fact_title);
        status = view.findViewById(R.id.status);
        runtime = view.findViewById(R.id.runtime);
        release = view.findViewById(R.id.release);
        language = view.findViewById(R.id.language);
        budget = view.findViewById(R.id.budget);
        revenue = view.findViewById(R.id.revenue);
        poster_path = view.findViewById(R.id.poster_path);
        backdrop_path = view.findViewById(R.id.backdrop_path);
        top_title = view.findViewById(R.id.top_title);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        btn_recycler.setLayoutManager(layoutManager);

        crew_recycler.setLayoutManager(new GridLayoutManager(getActivity(),2));

        LinearLayoutManager trailer_layoutManager = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        trailer_recycler.setLayoutManager(trailer_layoutManager);


        allDetail();
        crew();
        trailers();

        return view;
    }

    private void trailers() {

        RetrofitClint.getRetrofit(Constants.BASE_URL)
                .create(MovieRequest.class)
                .trail_Detail(id,Constants.key)
                .enqueue(new Callback<TrailersModel>() {
                    @Override
                    public void onResponse(Call<TrailersModel> call, Response<TrailersModel> response) {

                        Log.i("zmcbsjdchj", "onResponse: "+response);
                        Log.i("zmcbsjdchj", "onResponse: "+response.body());

                        TrailersAdapter adapter = new TrailersAdapter(getActivity(),response.body().getResults());
                        trailer_recycler.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<TrailersModel> call, Throwable t) {

                    }
                });
    }

    private void crew() {

        RetrofitClint.getRetrofit(Constants.BASE_URL)
                .create(MovieRequest.class)
                .crewDetail(id,Constants.key)
                .enqueue(new Callback<CrewModel>() {
                    @Override
                    public void onResponse(Call<CrewModel> call, Response<CrewModel> response) {

                        Log.i("zmcbsjdchj", "onResponse: "+response);
                        Log.i("zmcbsjdchj", "onResponse: "+response.body());

                        CrewAdapter crewAdapter = new CrewAdapter(getActivity(),response.body().getCrew());
                        crew_recycler.setAdapter(crewAdapter);
                    }

                    @Override
                    public void onFailure(Call<CrewModel> call, Throwable t) {

                    }
                });


    }

    public void allDetail(){

        RetrofitClint.getRetrofit(Constants.BASE_URL)
                .create(MovieRequest.class)
                .allDetail(id,Constants.key)
                .enqueue(new Callback<InfoModel>() {
                    @Override
                    public void onResponse(Call<InfoModel> call, Response<InfoModel> response) {

                        Log.i("zmcbsjdchj", "onResponse: "+response);
                        Log.i("zmcbsjdchj", "onResponse: "+response.body());

                        overview.setText(response.body().getOverview());

                        List<InfoModel.ProductionCompany> list = response.body().getProductionCompanies();

                        String s = "";

                        for(InfoModel.ProductionCompany x : list){
                            s = s+ x.getName()+",";
                        }

                        if (s.length()!=0){

                        String s1=s.substring(0,s.length()-1);

                        production_com_name.setText(s1);
                        fact_title.setText(response.body().getTitle());
                            status.setText(response.body().getStatus());
                            runtime.setText(""+response.body().getRuntime());
                            release.setText(response.body().getReleaseDate());
                            language.setText(response.body().getOriginalLanguage());
                            budget.setText(""+response.body().getBudget());
                            revenue.setText(""+response.body().getRevenue());
                            Picasso.get().load(Constants.Image_URL+response.body().getBackdropPath()).into(backdrop_path);
                            Picasso.get().load(Constants.Image_URL+response.body().getPosterPath()).into(poster_path);
                            top_title.setText(response.body().getTitle());
                            BtnAdaapter adaapter = new BtnAdaapter(response.body().getGenres(),getContext());
                            btn_recycler.setAdapter(adaapter);
                        }

                    }

                    @Override
                    public void onFailure(Call<InfoModel> call, Throwable t) {

                    }
                });
    }

}
