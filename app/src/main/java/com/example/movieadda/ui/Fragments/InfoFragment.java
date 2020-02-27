package com.example.movieadda.ui.Fragments;


import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.movieadda.Model.InfoModel;
import com.example.movieadda.Model.TopRAted;
import com.example.movieadda.Network.Constants;
import com.example.movieadda.Network.MovieRequest;
import com.example.movieadda.Network.RetrofitClint;
import com.example.movieadda.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment {

    TextView overview;
    String id;
    RecyclerView btn_recycler;
    TextView production_com_name;


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
        production_com_name = view.findViewById(R.id.production_com_name);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        btn_recycler.setLayoutManager(layoutManager);


        allDetail();

        return view;
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
                            s = s+","+ x.getName();
                        }

                        production_com_name.setText(s);
                    }

                    @Override
                    public void onFailure(Call<InfoModel> call, Throwable t) {

                    }
                });
    }

}
