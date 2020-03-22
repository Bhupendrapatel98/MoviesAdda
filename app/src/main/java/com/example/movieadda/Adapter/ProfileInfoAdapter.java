package com.example.movieadda.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieadda.Model.CrewModel;
import com.example.movieadda.Model.Images;
import com.example.movieadda.Model.ProfileInfoModel;
import com.example.movieadda.Network.Constants;
import com.example.movieadda.R;
import com.example.movieadda.ui.MoviePosterActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProfileInfoAdapter extends RecyclerView.Adapter<ProfileInfoAdapter.ProInfoViewHolder>{

    Context context;
    List<Images> list;

    public ProfileInfoAdapter(Context context, List<Images> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ProInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.pinfo_item,parent,false);
        return new ProInfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProInfoViewHolder holder, final int position) {

        Picasso.get().load(Constants.IMAGE_BASE_URL+list.get(position).getFilePath()).into(holder.proinfo_img);

        Log.i("hbvfjvfjjf", "onBindViewHolder: "+list);
        holder.proinfo_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, MoviePosterActivity.class);
                //imagelist
                intent.putExtra("img",(ArrayList<Images>)(list));
                //intent.putExtra("images",list.get(position).getFilePath());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ProInfoViewHolder extends RecyclerView.ViewHolder {

        ImageView proinfo_img;

        public ProInfoViewHolder(@NonNull View itemView) {
            super(itemView);

            proinfo_img = itemView.findViewById(R.id.proinfo_img);

        }
    }

}
