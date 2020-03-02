package com.example.movieadda.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieadda.Model.PersonModel;
import com.example.movieadda.Model.Result;
import com.example.movieadda.Model.TrendingPerson;
import com.example.movieadda.Network.Constants;
import com.example.movieadda.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class TrendingPersonAdapter extends RecyclerView.Adapter<TrendingPersonAdapter.PersonViewHolder>{

    List<Result> list;
    Context context;

    public TrendingPersonAdapter(List<Result> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.person_item,parent,false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {

        holder.person_name.setText(list.get(position).getName());
        Picasso.get().load(Constants.IMAGE_BASE_URL+list.get(position).getProfilePath()).into(holder.person_profile);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder {

        TextView person_name;
        CircleImageView person_profile;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);

            person_profile = itemView.findViewById(R.id.person_profile);
            person_name = itemView.findViewById(R.id.person_name);

        }
    }
}
