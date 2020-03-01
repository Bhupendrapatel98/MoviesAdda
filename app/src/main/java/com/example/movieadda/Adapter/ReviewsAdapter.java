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
import com.example.movieadda.Model.ReviewModel;
import com.example.movieadda.R;

import java.util.List;

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.ReviewViewHolder>{

    Context context;
    List<ReviewModel.Result> list;

    public ReviewsAdapter(Context context, List<ReviewModel.Result> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.review_item,parent,false);
        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {

        holder.review_author.setText(list.get(position).getAuthor());
        holder.review_content.setText(list.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ReviewViewHolder extends RecyclerView.ViewHolder {

        TextView review_author,review_content;

        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);

            review_author = itemView.findViewById(R.id.review_author);
            review_content = itemView.findViewById(R.id.review_content);
        }
    }

}
