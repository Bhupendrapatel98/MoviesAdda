package com.example.movieadda.ui.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.movieadda.Adapter.ProfileInfoAdapter;
import com.example.movieadda.Model.ProfileInfoModel;
import com.example.movieadda.Network.Constants;
import com.example.movieadda.Network.PersonRequest;
import com.example.movieadda.Network.RetrofitClint;
import com.example.movieadda.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileIngoFragment extends Fragment {

    String id;
    TextView birthday,deathday,also_known_as,biography;
    RecyclerView pro_info_recycler;

    public ProfileIngoFragment(String id) {
        // Required empty public constructor
        this.id=id;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile_ingo, container, false);

        birthday= view.findViewById(R.id.birthday);
        deathday= view.findViewById(R.id.deathday);
        also_known_as= view.findViewById(R.id.also_known_as);
        biography= view.findViewById(R.id.biography);
        pro_info_recycler= view.findViewById(R.id.pro_info_recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        pro_info_recycler.setLayoutManager(layoutManager);

        Log.i("jzhcdfdsjf", "onCreateView: "+id);
        profileInfo();

        return  view;
    }

    private void profileInfo() {

        RetrofitClint.getRetrofit(Constants.BASE_URL)
                .create(PersonRequest.class)
                .person(id,Constants.key)
                .enqueue(new Callback<ProfileInfoModel>() {
                    @Override
                    public void onResponse(Call<ProfileInfoModel> call, Response<ProfileInfoModel> response) {

                        Log.i("sjdnkdsj", "onResponse: "+response);
                        Log.i("sjdnkdsj", "onResponse: "+response.body());

                        birthday.setText(response.body().getBirthday());
                        deathday.setText(response.body().getDeathday());

                        also_known_as.setText(response.body().getAlsoKnownAs().get(0));
                        biography.setText(response.body().getBiography());

                    }

                    @Override
                    public void onFailure(Call<ProfileInfoModel> call, Throwable t) {

                    }
                });
    }

}
