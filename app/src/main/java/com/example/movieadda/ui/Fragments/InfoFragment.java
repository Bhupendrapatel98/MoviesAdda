package com.example.movieadda.ui.Fragments;


import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.renderscript.Sampler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.movieadda.Adapter.BtnAdaapter;
import com.example.movieadda.Adapter.CrewAdapter;
import com.example.movieadda.Adapter.ListAdapter;
import com.example.movieadda.Adapter.TrailersAdapter;
import com.example.movieadda.Model.CrewModel;
import com.example.movieadda.Model.ForBookmark;
import com.example.movieadda.Model.InfoModel;

import com.example.movieadda.Model.MyList;
import com.example.movieadda.Model.TopRAted;
import com.example.movieadda.Model.TrailersModel;
import com.example.movieadda.Network.Constants;
import com.example.movieadda.Network.MovieRequest;
import com.example.movieadda.Network.RetrofitClint;
import com.example.movieadda.Network.TvRequest;
import com.example.movieadda.R;
import com.example.movieadda.Room.DatabaseClient;
import com.example.movieadda.ui.CelebritiesActivity;
import com.example.movieadda.utils.Type;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;
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
    TextView production_com_name,top_title,crew_showall,time;
    ImageView backdrop_path,poster_path,list,bookmark,bookmark_white;
    Type.MovTv type;


    public InfoFragment(String id,Type.MovTv type) {
        // Required empty public constructor
        this.id = id;
        this.type=type;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        time = view.findViewById(R.id.time);
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
        list = view.findViewById(R.id.list);
        bookmark = view.findViewById(R.id.bookmark);
        crew_showall = view.findViewById(R.id.crew_showall);
        bookmark_white = view.findViewById(R.id.bookmark_white);

        bookmark_white.setVisibility(View.GONE);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        btn_recycler.setLayoutManager(layoutManager);

        crew_recycler.setLayoutManager(new GridLayoutManager(getActivity(),2));

        LinearLayoutManager trailer_layoutManager = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        trailer_recycler.setLayoutManager(trailer_layoutManager);

        crew_showall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            Intent intent = new Intent(getContext(), CelebritiesActivity.class);
            getContext().startActivity(intent);

        }
        });

        if (type == Type.MovTv.TVSHOW){
            getTvDetail();
            Tvcrew();
            Tvtrailers();
        }
        else
        {
            getMovieDetail();
            crew();
            trailers();
        }

        return view;
    }

    private void Tvtrailers() {

        RetrofitClint.getRetrofit(Constants.BASE_URL)
                .create(TvRequest.class)
                .trailer_Detail(id,Constants.key)
                .enqueue(new Callback<TrailersModel>() {
                    @Override
                    public void onResponse(Call<TrailersModel> call, Response<TrailersModel> response) {

                        Log.i("zmcbsjdchj", "onResponse: "+response);
                        Log.i("zmcbsjdchj", "onResponse: "+response.body());
                        if (response.body()!=null) {
                            TrailersAdapter adapter = new TrailersAdapter(getActivity(), response.body().getResults());
                            trailer_recycler.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<TrailersModel> call, Throwable t) {

                    }
                });
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
                        if (response.body()!=null) {
                            TrailersAdapter adapter = new TrailersAdapter(getActivity(), response.body().getResults());
                            trailer_recycler.setAdapter(adapter);
                        }
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
                        if (response.body()!=null) {
                            CrewAdapter crewAdapter = new CrewAdapter(getActivity(), response.body().getCrew());
                            crew_recycler.setAdapter(crewAdapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<CrewModel> call, Throwable t) {

                    }
                });


    }

    private void Tvcrew() {

        RetrofitClint.getRetrofit(Constants.BASE_URL)
                .create(TvRequest.class)
                .getCrewRequest(id,Constants.key)
                .enqueue(new Callback<CrewModel>() {
                    @Override
                    public void onResponse(Call<CrewModel> call, Response<CrewModel> response) {

                        Log.i("zmcbsjdchj", "onResponse: "+response);
                        Log.i("zmcbsjdchj", "onResponse: "+response.body());
                        if (response.body()!=null) {
                            CrewAdapter crewAdapter = new CrewAdapter(getActivity(), response.body().getCrew());
                            crew_recycler.setAdapter(crewAdapter);
                        }

                    }

                    @Override
                    public void onFailure(Call<CrewModel> call, Throwable t) {

                    }
                });


    }



    public void getTvDetail(){

        RetrofitClint.getRetrofit(Constants.BASE_URL)
                .create(TvRequest.class)
                .gettvrequest(id,Constants.key)
                .enqueue(new Callback<InfoModel>() {
                    @Override
                    public void onResponse(Call<InfoModel> call, final Response<InfoModel> response) {

                        if (response.body() != null) {

                            list_bookmark(response.body());

                            Log.i("zmcbsjdchj", "onResponse: " + response);
                            Log.i("hdgdggdgdggd", "onResponse: " + response.body());

                            overview.setText(response.body().getOverview());

                            List<InfoModel.ProductionCompany> list = response.body().getProductionCompanies();

                            String s = "";

                            for (InfoModel.ProductionCompany x : list) {
                                s = s + x.getName() + ",";
                            }

                            if (s.length() != 0) {

                                String s1 = s.substring(0, s.length() - 1);

                                production_com_name.setText(s1);
                                fact_title.setText(response.body().getName());
                                status.setText(response.body().getStatus());
                                //runtime.setText("" + response.body().getRuntime());
                                // time.setText("" + response.body().getRuntime());

                                int t = response.body().getRuntime();
                                int hours = t / 60;
                                int minutes = t % 60;
                                Log.i("mjbdbdkkdf", "onResponse: "+hours+""+minutes);
                                time.setText(hours+ " hour " +minutes+" minutes ");
                                runtime.setText(hours+ " hour " +minutes+" minutes ");

                                release.setText(response.body().getReleaseDate());
                                language.setText(response.body().getOriginalLanguage());
                                budget.setText("" + response.body().getBudget());
                                revenue.setText("" + response.body().getRevenue());
                                Picasso.get().load(Constants.Image_URL + response.body().getBackdropPath()).into(backdrop_path);
                                Picasso.get().load(Constants.Image_URL + response.body().getPosterPath()).into(poster_path);
                                top_title.setText(response.body().getName());
                                BtnAdaapter adaapter = new BtnAdaapter(response.body().getGenres(), getContext());
                                btn_recycler.setAdapter(adaapter);
                            }

                        }

                        bookmark.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                bookmark.setVisibility(View.GONE);
                                bookmark_white.setVisibility(View.VISIBLE);

                                DatabaseClient.getInstance(getContext()).getAppDatabase()
                                        .getMovieInfoDao()
                                        .insert(response.body());

                                ForBookmark forBookmark = new ForBookmark(response.body().getId(), Type.MovTv.TVSHOW);

                                DatabaseClient.getInstance(getContext()).getAppDatabase()
                                        .getForBookmarkDao()
                                        .insert(forBookmark);
                            }
                        });

                    }

                    @Override
                    public void onFailure(Call<InfoModel> call, Throwable t) {

                    }
                });
    }

    public void getMovieDetail(){

        RetrofitClint.getRetrofit(Constants.BASE_URL)
                .create(MovieRequest.class)
                .allDetail(id,Constants.key)
                .enqueue(new Callback<InfoModel>() {
                    @Override
                    public void onResponse(Call<InfoModel> call, final Response<InfoModel> response) {

                        if (response.body() != null) {

                            list_bookmark(response.body());

                            Log.i("zmcbsjdchj", "onResponse: " + response);
                            Log.i("zmcbsjdchj", "onResponse: " + response.body());

                            overview.setText(response.body().getOverview());

                            List<InfoModel.ProductionCompany> list = response.body().getProductionCompanies();

                            String s = "";

                            for (InfoModel.ProductionCompany x : list) {
                                s = s + x.getName() + ",";
                            }

                            if (s.length() != 0) {

                                String s1 = s.substring(0, s.length() - 1);

                                production_com_name.setText(s1);
                                fact_title.setText(response.body().getTitle());
                                status.setText(response.body().getStatus());
                                //runtime.setText("" + response.body().getRuntime());
                               // time.setText("" + response.body().getRuntime());

                                int t = response.body().getRuntime();
                                int hours = t / 60;
                                int minutes = t % 60;
                                Log.i("mjbdbdkkdf", "onResponse: "+hours+""+minutes);
                                time.setText(hours+ " hour " +minutes+" minutes ");
                                runtime.setText(hours+ " hour " +minutes+" minutes ");

                                release.setText(response.body().getReleaseDate());
                                language.setText(response.body().getOriginalLanguage());
                                budget.setText("" + response.body().getBudget());
                                revenue.setText("" + response.body().getRevenue());
                                Picasso.get().load(Constants.Image_URL + response.body().getBackdropPath()).into(backdrop_path);
                                Picasso.get().load(Constants.Image_URL + response.body().getPosterPath()).into(poster_path);
                                top_title.setText(response.body().getTitle());
                                BtnAdaapter adaapter = new BtnAdaapter(response.body().getGenres(), getContext());
                                btn_recycler.setAdapter(adaapter);
                            }

                        }

                        bookmark.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                bookmark.setVisibility(View.GONE);
                                bookmark_white.setVisibility(View.VISIBLE);

                                DatabaseClient.getInstance(getContext()).getAppDatabase()
                                        .getMovieInfoDao()
                                        .insert(response.body());

                                ForBookmark forBookmark = new ForBookmark(response.body().getId(), Type.MovTv.MOVIE);

                                DatabaseClient.getInstance(getContext()).getAppDatabase()
                                        .getForBookmarkDao()
                                        .insert(forBookmark);
                            }
                        });


                    }

                    @Override
                    public void onFailure(Call<InfoModel> call, Throwable t) {

                    }
                });
    }

    public void list_bookmark(final InfoModel body){

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1st dialok
                final DialogPlus dialog = DialogPlus.newDialog(getContext())
                        .setContentHolder(new ViewHolder(R.layout.list_dialog))
                        .setGravity(Gravity.CENTER)
                        .setMargin(100, 0, 100, 0)
                        .setCancelable(false)
                        .setExpanded(false)
                        .create();

                LinearLayout layoutlist = (LinearLayout) dialog.getHolderView();

                ImageView add = layoutlist.findViewById(R.id.add);

                //2nd dialok
                final DialogPlus dialog1 = DialogPlus.newDialog(getContext())
                        .setContentHolder(new ViewHolder(R.layout.plus_btn_dialog))
                        .setGravity(Gravity.CENTER)
                        .setMargin(100, 0, 100, 0)
                        .setCancelable(false)
                        .setExpanded(false)
                        .create();
                LinearLayout listnamelayout = (LinearLayout) dialog1.getHolderView();

                Button cancel1 = listnamelayout.findViewById(R.id.cancel1);
                Button ok1 = listnamelayout.findViewById(R.id.ok1);
                final EditText text = listnamelayout.findViewById(R.id.textname);

                RecyclerView movielist = layoutlist.findViewById(R.id.movielist);

                List<MyList> myLists = DatabaseClient.getInstance(getContext()).getAppDatabase()
                        .getmylistdao()
                        .getAll(type);
                Log.i("hbvbjdhvjdf", "onClick: "+myLists);

                movielist.setLayoutManager(new LinearLayoutManager(getContext()));

                movielist.setAdapter(new ListAdapter(getContext(), myLists, type, body));

                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        dialog.dismiss();

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dialog1.show();
                            }
                        },1000);
                    }
                });

                cancel1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog1.dismiss();
                    }
                });

                ok1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        DatabaseClient.getInstance(getContext()).getAppDatabase()
                                .getmylistdao()
                                .insert(new MyList(text.getText().toString(), 1, type));
                        Toast.makeText(getContext(), "" + text.getText().toString(), Toast.LENGTH_SHORT).show();
                        dialog1.dismiss();
                    }
                });

                Button ok = layoutlist.findViewById(R.id.ok);
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }

}
