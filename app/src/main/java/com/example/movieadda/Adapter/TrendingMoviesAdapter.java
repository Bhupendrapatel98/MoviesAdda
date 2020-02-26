package com.example.movieadda.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieadda.Model.Result;
import com.example.movieadda.Model.TrendingMoviesReq;
import com.example.movieadda.Model.TrendingTvShow;
import com.example.movieadda.Network.Constants;
import com.example.movieadda.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TrendingMoviesAdapter extends RecyclerView.Adapter<TrendingMoviesAdapter.TrendingMoviewViewHolder> {

    Context context;
    List<Result> list;

    public TrendingMoviesAdapter(Context context, List<Result> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TrendingMoviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.trending_movies_item,parent,false);
        return new TrendingMoviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingMoviewViewHolder holder, int position) {

        Picasso.get().load(Constants.Image_URL+list.get(position).getPosterPath()).into(holder.trending_m_img);
        holder.trending_m_name.setText(list.get(position).getTitle());
        Log.i("znzdhcvsbjdc", "onBindViewHolder: "+list.get(position).getPosterPath());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TrendingMoviewViewHolder extends RecyclerView.ViewHolder {

        private ImageView trending_m_img;
        private TextView trending_m_name;

        public TrendingMoviewViewHolder(@NonNull View itemView) {
            super(itemView);

            trending_m_img = itemView.findViewById(R.id.trending_m_img);
            trending_m_name = itemView.findViewById(R.id.trending_m_name);
        }
    }

}
