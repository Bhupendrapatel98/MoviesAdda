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
import com.example.movieadda.ui.AllDetailActivity;
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

        Log.i("dfjkhkdjd", "onBindViewHolder: "+type);
        Log.i("jdhfbjdfbhdkjfv", "onBindViewHolder: "+similar);

        //for list and book mark

        if (type==Type.MovTv.MOVIE){
            if (list.get(position).getTitle()==null){
                holder.title.setText(list.get(position).getOriginalTitle());
            }
            else {
                holder.title.setText(list.get(position).getTitle());
            }

            //get movie year
//            String yer = list.get(position).getReleaseDate();
//            String[] y =  yer.split("-");
//            if (y != null) {
//                Log.i("dmhbdjfhjd", "onBindViewHolder: " + y[0]);
//                holder.year.setText(y[0]);
//            }
        }
        else if (type==Type.MovTv.TVSHOW){

            if (list.get(position).getOriginal_name()==null){
                holder.title.setText(list.get(position).getName());
            }
            else {
                holder.title.setText(list.get(position).getOriginal_name());
            }

        }
        else {
            holder.title.setText(list.get(position).getName());
            Log.i("smcjbnksdj", "onBindViewHolder4: "+list.get(position).getName());
        }

       /* if (list.get(position).getTitle()==null) {
            holder.title.setText(list.get(position).getName());
        }
        else {
            holder.title.setText(list.get(position).getTitle());
        }*/
        holder.vote_average.setText(""+list.get(position).getVoteAverage());

        final String key = String.valueOf(list.get(position).getId());

        holder.main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.i("cbvjhdf", "onClick: "+key);

                Intent intent = new Intent(context, AllDetailActivity.class);
                intent.putExtra("key_id",key);
                intent.putExtra("type",type);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SimilarViewHolder extends RecyclerView.ViewHolder {

        ImageView backdrop_path;
        TextView vote_average,title,year;
        LinearLayout main;

        public SimilarViewHolder(@NonNull View itemView) {
            super(itemView);

            backdrop_path = itemView.findViewById(R.id.backdrop_path);
            vote_average = itemView.findViewById(R.id.vote_average);
            title = itemView.findViewById(R.id.title);
            main = itemView.findViewById(R.id.main);
            year = itemView.findViewById(R.id.year);

        }
    }

   public void addAllResilu(List<Result> list){
        this.list.addAll(list);
        notifyItemRangeInserted(this.list.size()-list.size(),this.list.size());
   }
}
