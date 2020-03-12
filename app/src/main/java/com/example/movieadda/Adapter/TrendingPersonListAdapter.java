package com.example.movieadda.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieadda.Model.Result;
import com.example.movieadda.Network.Constants;
import com.example.movieadda.R;
import com.example.movieadda.ui.ProfileActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TrendingPersonListAdapter extends RecyclerView.Adapter<TrendingPersonListAdapter.TpersonViewHolder>{

    Context context;
    List<Result> list;

    public TrendingPersonListAdapter(Context context, List<Result> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TpersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.cast_item,parent,false);
        return new TpersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TpersonViewHolder holder, final int position) {

        holder.cast_name.setText(list.get(position).getName());
        holder.cast_character.setText(list.get(position).getKnown_for_department());
        Picasso.get().load(Constants.IMAGE_BASE_URL+list.get(position).getProfilePath()).into(holder.cast_profile_image);

        holder.cast_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProfileActivity.class);
                intent.putExtra("id",list.get(position).getId()+"");
                Log.i("cdnnskd", "onClick: "+list.get(position).getId());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TpersonViewHolder extends RecyclerView.ViewHolder {

        TextView cast_name,cast_character;
        ImageView cast_profile_image;
        LinearLayout cast_main;

        public TpersonViewHolder(@NonNull View itemView) {
            super(itemView);

            cast_name = itemView.findViewById(R.id.cast_name);
            cast_character = itemView.findViewById(R.id.cast_character);
            cast_profile_image = itemView.findViewById(R.id.cast_profile_image);
            cast_main = itemView.findViewById(R.id.cast_main);

        }
    }
    public void addAllResilu(List<Result> list){
        this.list.addAll(list);
        notifyItemRangeInserted(this.list.size()-list.size(),this.list.size());
    }
}
