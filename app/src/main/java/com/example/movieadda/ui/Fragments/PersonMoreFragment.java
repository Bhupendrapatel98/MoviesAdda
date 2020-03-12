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
import com.example.movieadda.Adapter.TrendingPersonAdapter;
import com.example.movieadda.Adapter.TrendingPersonListAdapter;
import com.example.movieadda.Model.TrendingPerson;
import com.example.movieadda.Network.Constants;
import com.example.movieadda.Network.RetrofitClint;
import com.example.movieadda.Network.TrendingReq;
import com.example.movieadda.R;
import com.example.movieadda.utils.Type;
import com.tuyenmonkey.mkloader.MKLoader;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonMoreFragment extends Fragment {

    Type.MovieType type;
    RecyclerView more_recycler;
    MKLoader loader;
    LinearLayoutManager layoutManager;
    TrendingPersonListAdapter adapter;
    int page=1;
    boolean isLoading=false;


    public PersonMoreFragment(Type.MovieType type) {
        // Required empty public constructor
        this.type = type;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_person_more, container, false);

        more_recycler = view.findViewById(R.id.more_recycler);
        loader = view.findViewById(R.id.loader);

        layoutManager = new LinearLayoutManager(getContext());
        more_recycler.setLayoutManager(layoutManager);

        Log.i("ncvvdhdhdgd", "onCreateView: "+type);

        if (type==Type.MovieType.TRENDING_PERSON){
            getPersonMore();
        }

        addListner();

        return view;
    }

    public  void  getPersonMore(){

        RetrofitClint.getRetrofit(Constants.BASE_URL)
                .create(TrendingReq.class)
                .getTrendingPersonList(""+page,Constants.key)
                .enqueue(new Callback<TrendingPerson>() {
                    @Override
                    public void onResponse(Call<TrendingPerson> call, Response<TrendingPerson> response) {

                        Log.i("msdjbshj", "onResponse: "+response);
                        Log.i("msdjbshj", "onResponse: "+response.body());

                        if (page==1){

                             adapter = new TrendingPersonListAdapter(getContext(),response.body().getResults());
                            more_recycler.setAdapter(adapter);
                        }
                        else {
                            adapter.addAllResilu(response.body().getResults());
                        }
                        isLoading = false;
                        page++;
              }

                    @Override
                    public void onFailure(Call<TrendingPerson> call, Throwable t) {

                    }
                });

    }

    public void addListner(){

        more_recycler.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int total = layoutManager.getItemCount();
                int firstVisibleItemCount = layoutManager.findFirstVisibleItemPosition();
                int lastVisibleItemCount = layoutManager.findLastVisibleItemPosition();

                //to avoid multiple calls to loadMore() method
                //maintain a boolean value (isLoading). if loadMore() task started set to true and completes set to false
                if (!isLoading) {
                    if (total > 0)
                        if ((total - 1) == lastVisibleItemCount) {
                            isLoading = true;

                            getPersonMore();

                        }
                }
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

            }

        });
    }

}
