package com.example.movieadda.Room.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.movieadda.Model.MyListDetail;

import java.util.List;

@Dao
public interface MyListDetailDao {

    @Query("SELECT * FROM MyListDetail")
    List<MyListDetail> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MyListDetail list);

    @Query("DELETE FROM MyListDetail WHERE MyListDetail.mlid == :myListId AND MyListDetail.minfoid = :movieInfoId  ")
    void delte(Long myListId, Long movieInfoId );

    @Update
    void update(MyListDetail list);

    @Query("SELECT * FROM MyListDetail where MyListDetail.minfoid == (:id) And MyListDetail.mlid == (:mlid)" )
    List<MyListDetail> checkListDetail(Long id,Long mlid);

}