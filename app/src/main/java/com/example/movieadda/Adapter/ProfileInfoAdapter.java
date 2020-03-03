package com.example.movieadda.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieadda.Model.CrewModel;
import com.example.movieadda.Model.ProfileInfoModel;
import com.example.movieadda.Network.Constants;
import com.example.movieadda.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProfileInfoAdapter extends RecyclerView.Adapter<ProfileInfoAdapter.ProInfoViewHolder>{

    Context context;
    List<ProfileInfoModel> list;

    public ProfileInfoAdapter(Context context, List<ProfileInfoModel> list) {
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
    public void onBindViewHolder(@NonNull ProInfoViewHolder holder, int position) {

        Picasso.get().load(Constants.IMAGE_BASE_URL+list.get(position).getProfilePath()).into(holder.proinfo_img);

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
