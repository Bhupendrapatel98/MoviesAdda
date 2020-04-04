package com.example.movieadda.Room;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.movieadda.Model.ForBookmark;
import com.example.movieadda.Model.InfoModel;
import com.example.movieadda.Model.MyList;
import com.example.movieadda.Model.MyListDetail;
import com.example.movieadda.Model.Result;
import com.example.movieadda.Room.Dao.ForBookmarkDao;
import com.example.movieadda.Room.Dao.MovieInfoDao;
import com.example.movieadda.Room.Dao.MyListDao;
import com.example.movieadda.Room.Dao.MyListDetailDao;
import com.example.movieadda.Room.Dao.ResultDao;
import com.example.movieadda.Room.typeconverter.BelongsToCollectionConverter;
import com.example.movieadda.Room.typeconverter.GenreConverters;
import com.example.movieadda.Room.typeconverter.IntegerConverter;
import com.example.movieadda.Room.typeconverter.LongConverters;
import com.example.movieadda.Room.typeconverter.MTvConverter;
import com.example.movieadda.Room.typeconverter.ProductionCompanyConverter;
import com.example.movieadda.Room.typeconverter.ProductionCountryConverter;
import com.example.movieadda.Room.typeconverter.SpokenLanguageConverter;

@Database(entities = {Result.class, InfoModel.class, ForBookmark.class, MyList.class, MyListDetail.class}, version = 1)
@TypeConverters(
        {
                LongConverters.class,
                BelongsToCollectionConverter.class,
                GenreConverters.class,
                IntegerConverter.class,
                ProductionCompanyConverter.class,
                ProductionCountryConverter.class,
                SpokenLanguageConverter.class,
                MTvConverter.class
        }
)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ResultDao getResultDao();
    public abstract MovieInfoDao getMovieInfoDao();
    public abstract ForBookmarkDao getForBookmarkDao();
    public abstract MyListDao getmylistdao();
    public abstract MyListDetailDao getmylistdetaildao();

}