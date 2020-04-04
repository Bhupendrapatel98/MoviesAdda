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

import com.example.movieadda.Model.MyList;
import com.example.movieadda.R;
import com.example.movieadda.ui.MovieCatagoryActivity;
import com.example.movieadda.utils.Type;

import java.util.List;

public class MyListMovieAdapter extends RecyclerView.Adapter<MyListMovieAdapter.MyListMovieviewholder> {
    Context context;
    List<MyList> myLists;
    Type.MovieType type;

    public MyListMovieAdapter(Context context, List<MyList> myLists, Type.MovieType type) {
        this.context=context;
        this.myLists=myLists;
        this.type=type;
    }

    @NonNull
    @Override
    public MyListMovieviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.mylistmovie,parent,false);
        return new MyListMovieviewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyListMovieviewholder holder, final int position) {
        holder.listname.setText(myLists.get(position).getName());
        Log.i("cddfgf", "onBindViewHolder: "+myLists.get(position).getName());
        holder.mno.setText(myLists.get(position).getSize()+"");
        Log.i("fefdfdd", "onBindViewHolder: "+myLists.get(position).getSize()+"");

        holder.listlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, MovieCatagoryActivity.class);
                intent.putExtra("id",myLists.get(position).getId()+"");
                Log.i("sfgdgdg", "onClick: "+myLists.get(position).getId());

                intent.putExtra("mixlisttype", Type.SimilarType.MY_LIST);
                intent.putExtra("type",type);
                 context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myLists.size();
    }

    public class MyListMovieviewholder extends RecyclerView.ViewHolder {
        TextView mno,listname;
        ImageView imageavni;
        LinearLayout listlayout;
        public MyListMovieviewholder(@NonNull View itemView) {
            super(itemView);
            mno=itemView.findViewById(R.id.mno);
            listname=itemView.findViewById(R.id.listname);
            imageavni=itemView.findViewById(R.id.imageavni);
            listlayout=itemView.findViewById(R.id.listlayout);
        }
    }


}
