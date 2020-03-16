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
import com.example.movieadda.Network.Constants;
import com.example.movieadda.R;
import com.example.movieadda.utils.Type;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SimilarAdapter extends RecyclerView.Adapter<SimilarAdapter.SimilarViewHolder>{

    Context context;
    List<Result> list;
    Type.MovTv type;
    Type.SimilarType similar;

    public SimilarAdapter(Context context, List<Result> list, Type.MovTv type, Type.SimilarType similar) {
        this.context = context;
        this.list = list;
        this.type=type;
        this.similar=similar;
    }

    @NonNull
    @Override
    public SimilarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.similar_item,parent,false);
        return new SimilarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimilarViewHolder holder, int position) {

        Picasso.get().load(Constants.IMAGE_BASE_URL+list.get(position).getPosterPath()).into(holder.backdrop_path);

        Log.i("jgfjhgfkggf", "onBindViewHolder: "+list);
        Log.i("jgfjhgfkggf", "onBindViewHolder1: "+list.get(position).getTitle());
        Log.i("jgfjhgfkggf", "onBindViewHolder2: "+list.get(position).getName());

        if (type==Type.MovTv.MOVIE){
            holder.title.setText(list.get(position).getTitle());
        }
        else if (type==Type.MovTv.TVSHOW){

            holder.title.setText(list.get(position).getOriginal_name());
        }
        else {
            holder.title.setText(list.get(position).getName());
        }

       /* if (list.get(position).getTitle()==null) {
            holder.title.setText(list.get(position).getName());
        }
        else {
            holder.title.setText(list.get(position).getTitle());
        }*/
        holder.vote_average.setText(""+list.get(position).getVoteAverage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SimilarViewHolder extends RecyclerView.ViewHolder {

        ImageView backdrop_path;
        TextView vote_average,title;

        public SimilarViewHolder(@NonNull View itemView) {
            super(itemView);

            backdrop_path = itemView.findViewById(R.id.backdrop_path);
            vote_average = itemView.findViewById(R.id.vote_average);
            title = itemView.findViewById(R.id.title);

        }
    }

   public void addAllResilu(List<Result> list){
        this.list.addAll(list);
        notifyItemRangeInserted(this.list.size()-list.size(),this.list.size());
   }
}
