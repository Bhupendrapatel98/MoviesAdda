package com.example.movieadda.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieadda.Model.CrewModel;
import com.example.movieadda.Model.TrailersModel;
import com.example.movieadda.Network.Constants;
import com.example.movieadda.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TrailersAdapter extends RecyclerView.Adapter<TrailersAdapter.TrailerViewHolder>{

    Context context;
    List<TrailersModel.Result> list;

    public TrailersAdapter(Context context, List<TrailersModel.Result> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TrailerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.trailer_item,parent,false);



        return new TrailerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrailerViewHolder holder, int position) {

        String key = "";
        String s = "";

        key = list.get(position).getKey();

        s = "https://img.youtube.com/vi/"+key+"/sddefault.jpg";
        Log.i("msajbhsjd", "onBindViewHolder: "+s);

        Picasso.get().load(s).into(holder.thumnail);

        holder.trailer_name.setText(list.get(position).getName());

        holder.trailer_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://" + video_id));
//                startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TrailerViewHolder extends RecyclerView.ViewHolder {

        ImageView thumnail;
        RelativeLayout trailer_click;
        TextView trailer_name;

        public TrailerViewHolder(@NonNull View itemView) {
            super(itemView);

            thumnail= itemView.findViewById(R.id.thumnail);
            trailer_click= itemView.findViewById(R.id.trailer_click);
            trailer_name= itemView.findViewById(R.id.trailer_name);
        }
    }
}
