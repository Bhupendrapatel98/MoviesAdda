package com.example.movieadda.Room.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.movieadda.Model.ForBookmark;
import com.example.movieadda.Model.InfoModel;
import com.example.movieadda.utils.Type;

import java.util.List;

@Dao
public interface  ForBookmarkDao {

    @Query("SELECT * FROM ForBookmark")
    List<ForBookmark> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ForBookmark bookmark);

    @Query("DELETE  FROM ForBookmark WHERE ForBookmark.minfo==(:mid)")
    void delte( long mid);

    @Update
    void update(ForBookmark bookmark);

    @Query("SELECT * FROM InfoModel INNER JOIN ForBookmark ON InfoModel.id == ForBookmark.minfo WHERE ForBookmark.type == (:type)")
    List<InfoModel> getAllBookmarkMovieInfo(Type.MovTv type);

    @Query("SELECT * FROM ForBookmark WHERE ForBookmark.minfo==(:mid) ")
    List<ForBookmark> getbookmarklist(long mid);
}