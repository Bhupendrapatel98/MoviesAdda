package com.example.movieadda.ui.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movieadda.Adapter.CastAdapter;
import com.example.movieadda.Adapter.CrewAdapter;
import com.example.movieadda.Model.CrewModel;
import com.example.movieadda.Network.Constants;
import com.example.movieadda.Network.MovieRequest;
import com.example.movieadda.Network.RetrofitClint;
import com.example.movieadda.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class CastFragment extends Fragment {

    private RecyclerView cast_recycler;
    String id;

    public CastFragment(String id) {
        this.id=id;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cast, container, false);

        cast_recycler = view.findViewById(R.id.cast_recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        cast_recycler.setLayoutManager(layoutManager);


        crew();

        return view;
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

                        CastAdapter castAdapter = new CastAdapter(getActivity(),response.body().getCast());
                        cast_recycler.setAdapter(castAdapter);
                    }

                    @Override
                    public void onFailure(Call<CrewModel> call, Throwable t) {

                    }
                });


    }

}
