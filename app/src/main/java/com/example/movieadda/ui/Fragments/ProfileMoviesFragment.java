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
import com.example.movieadda.Model.CrewModel;
import com.example.movieadda.Network.Constants;
import com.example.movieadda.Network.PersonRequest;
import com.example.movieadda.Network.RetrofitClint;
import com.example.movieadda.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileMoviesFragment extends Fragment {

    String id;
    RecyclerView profile_moview_recycler;

    public ProfileMoviesFragment(String id) {
        // Required empty public constructor
        this.id=id;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_movies, container, false);

        profile_moview_recycler = view.findViewById(R.id.profile_moview_recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        profile_moview_recycler.setLayoutManager(layoutManager);

        Log.i("dkfjvhdfkdf", "onCreateView: "+id);
        getPersonMovies();

        return view;
    }

    private void getPersonMovies() {

        RetrofitClint.getRetrofit(Constants.BASE_URL)
                .create(PersonRequest.class)
                .getPersonMovies(id,Constants.key)
                .enqueue(new Callback<CrewModel>() {
                    @Override
                    public void onResponse(Call<CrewModel> call, Response<CrewModel> response) {

                        Log.i("ksdjfhdsdf", "onResponse: "+response);
                        Log.i("ksdjfhdsdf", "onResponse: "+response.body());

                        CastAdapter castAdapter = new CastAdapter(getContext(),response.body().getCast());
                        profile_moview_recycler.setAdapter(castAdapter);

                    }

                    @Override
                    public void onFailure(Call<CrewModel> call, Throwable t) {

                    }
                });
    }
}
