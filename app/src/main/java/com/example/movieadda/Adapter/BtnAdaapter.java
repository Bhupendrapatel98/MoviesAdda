package com.example.movieadda.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieadda.Model.ButtonModel;
import com.example.movieadda.Model.InfoModel;
import com.example.movieadda.R;

import java.util.List;

public class BtnAdaapter extends RecyclerView.Adapter<BtnAdaapter.BtnViewHolder> {

    List<InfoModel.Genre> list;
    Context context;

    public BtnAdaapter(List<InfoModel.Genre> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public BtnViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.btn_item,parent,false);
        return new BtnViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BtnViewHolder holder, int position) {

        holder.btn.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BtnViewHolder extends RecyclerView.ViewHolder {

        private Button btn;

        public BtnViewHolder(@NonNull View itemView) {
            super(itemView);

            btn = itemView.findViewById(R.id.btn);
        }
    }
}
