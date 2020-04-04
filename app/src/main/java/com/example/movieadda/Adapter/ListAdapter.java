package com.example.movieadda.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieadda.Model.InfoModel;
import com.example.movieadda.Model.MyList;
import com.example.movieadda.Model.MyListDetail;
import com.example.movieadda.R;
import com.example.movieadda.Room.DatabaseClient;
import com.example.movieadda.utils.Type;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.Listadapterview> {

    Context context;
    List<MyList> myLists ;
    Type.MovTv type;
    InfoModel movieInfo;

    public ListAdapter(Context context, List<MyList> myLists, Type.MovTv type, InfoModel movieInfo) {
        this.context = context;
        this.myLists = myLists;
        this.type = type;
        this.movieInfo = movieInfo;
    }

    @NonNull
    @Override
    public Listadapterview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.listdialouge,parent,false);
        return new Listadapterview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Listadapterview holder, final int position) {

        List<MyListDetail> list =  DatabaseClient.getInstance(context).getAppDatabase(). getmylistdetaildao()
                .checkListDetail(movieInfo.getId(),myLists.get(position).getId());
        boolean isMyListDetailAlready = list.size()>0?true:false;

        List<InfoModel>list1=DatabaseClient.getInstance(context).getAppDatabase(). getMovieInfoDao()
                .checkMovieinfo(movieInfo.getId());
        final boolean isMyMovieinfotAlready = list1.size()>0?true:false;

        holder.listname.setText(myLists.get(position).getName());

        holder.listcheck.setOnCheckedChangeListener(null);
        holder.listcheck.setChecked(isMyListDetailAlready);
        holder.listcheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    if(!isMyMovieinfotAlready){
                        DatabaseClient.getInstance(context).getAppDatabase()
                                .getMovieInfoDao()
                                .insert(movieInfo);

                    }

                    DatabaseClient.getInstance(context).getAppDatabase(). getmylistdetaildao()
                            .insert(new MyListDetail(myLists.get(position).getId(),movieInfo.getId(), type));
                    Log.i("cscscsc", "onCheckedChanged: "+type);



                }
                else {
                    DatabaseClient.getInstance(context).getAppDatabase()
                            .getmylistdetaildao()
                            .delte(myLists.get(position).getId(),movieInfo.getId());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return myLists.size();
    }

    public class Listadapterview extends RecyclerView.ViewHolder {
        TextView listname;
        CheckBox listcheck;
        public Listadapterview(@NonNull View itemView) {
            super(itemView);
            listname=itemView.findViewById(R.id.listname);
            listcheck=itemView.findViewById(R.id.listcheck);
        }
    }
}
