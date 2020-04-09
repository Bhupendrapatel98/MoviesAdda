package com.example.movieadda.Room.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.movieadda.Model.InfoModel;
import com.example.movieadda.utils.Type;

import java.util.List;

@Dao
public interface MovieInfoDao {

    @Query("SELECT * FROM InfoModel")
    List<InfoModel> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(InfoModel result);

    @Delete
    void delete(InfoModel result);

    @Update
    void update(InfoModel result);

    @Query("SELECT * FROM InfoModel where InfoModel.movie_id == (:id)")
    List<InfoModel> checkMovieinfo(Long id);

    @Query("Select * FROM  InfoModel INNER JOIN MyListDetail ON  MyListDetail.minfoid==InfoModel.movie_id  Where MyListDetail.type==:type AND mlid==:mylistid ")
    List<InfoModel> getdetail(Type.MovTv type, long mylistid);

}