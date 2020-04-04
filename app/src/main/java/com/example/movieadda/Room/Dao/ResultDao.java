package com.example.movieadda.Room.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.movieadda.Model.Result;

import java.util.List;

@Dao
public interface  ResultDao {

    @Query("SELECT * FROM Result")
    List<Result> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Result result);

    @Delete
    void delete(Result result);

    @Update
    void update(Result result);
}