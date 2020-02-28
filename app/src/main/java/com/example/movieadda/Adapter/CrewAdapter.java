package com.example.movieadda.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieadda.Model.CrewModel;
import com.example.movieadda.R;

import java.util.ArrayList;
import java.util.List;

public class CrewAdapter extends RecyclerView.Adapter<CrewAdapter.CrewViewHolder>{

    Context context;
    List<CrewModel.Crew> list;

    public CrewAdapter(Context context, List<CrewModel.Crew> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CrewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.crtew_item,parent,false);
        return new CrewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CrewViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.department.setText(list.get(position).getDepartment());
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class CrewViewHolder extends RecyclerView.ViewHolder {

        TextView name,department;

        public CrewViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            department = itemView.findViewById(R.id.department);
        }
    }
}
