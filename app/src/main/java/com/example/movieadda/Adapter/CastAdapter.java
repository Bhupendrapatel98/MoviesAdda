package com.example.movieadda.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieadda.Model.CrewModel;
import com.example.movieadda.R;

import java.util.List;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastViewHolder> {

    Context context;
    List<CrewModel.Cast> list;

    public CastAdapter(Context context, List<CrewModel.Cast> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.cast_item,parent,false);
        return new CastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CastViewHolder holder, int position) {

        holder.cast_name.setText(list.get(position).getName());
        holder.cast_character.setText(list.get(position).getCharacter());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CastViewHolder extends RecyclerView.ViewHolder {

        TextView cast_name,cast_character;
        ImageView cast_profile_image;

        public CastViewHolder(@NonNull View itemView) {
            super(itemView);

            cast_name = itemView.findViewById(R.id.cast_name);
            cast_character = itemView.findViewById(R.id.cast_character);
            cast_profile_image = itemView.findViewById(R.id.cast_profile_image);

        }
    }
}
