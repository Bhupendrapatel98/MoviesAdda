package com.example.movieadda.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieadda.Model.PersonModel;
import com.example.movieadda.Model.Result;
import com.example.movieadda.Model.TrendingPerson;
import com.example.movieadda.Network.Constants;
import com.example.movieadda.R;
import com.example.movieadda.ui.ProfileActivity;
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
    public void onBindViewHolder(@NonNull PersonViewHolder holder, final int position) {

        holder.person_name.setText(list.get(position).getName());
        Picasso.get().load(Constants.IMAGE_BASE_URL+list.get(position).getProfilePath()).into(holder.person_profile);

        holder.trending_person_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProfileActivity.class);
                intent.putExtra("id",list.get(position).getId()+"");
                Log.i("cdnnskd", "onClick: "+list.get(position).getId());
                intent.putExtra("name",list.get(position).getName()+"");
                intent.putExtra("photo",list.get(position).getProfilePath()+"");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder {

        TextView person_name;
        CircleImageView person_profile;
        LinearLayout trending_person_main;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);

            person_profile = itemView.findViewById(R.id.person_profile);
            person_name = itemView.findViewById(R.id.person_name);
            trending_person_main = itemView.findViewById(R.id.trending_person_main);

        }
    }
}
