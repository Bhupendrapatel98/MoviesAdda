package com.example.movieadda.Model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.movieadda.Model.InfoModel;
import com.example.movieadda.Model.MyList;
import com.example.movieadda.Room.typeconverter.MTvConverter;
import com.example.movieadda.utils.Type;

@TypeConverters({MTvConverter.class
})
@Entity
        (foreignKeys = {
                @ForeignKey(entity = MyList.class,
                        parentColumns="id",
                        childColumns = "mlid"),

                @ForeignKey(entity = InfoModel.class,
                        parentColumns="id",
                        childColumns = "minfoid"),


        })
public class MyListDetail {
    @PrimaryKey(autoGenerate = true)
    long id;

    long mlid;

    long minfoid;

    Type.MovTv type;



    public  MyListDetail(long mlid,long minfoid,Type.MovTv type){
        this.mlid=mlid;
        this.minfoid=minfoid;
        this.type=type;

    }

    public long getMlid() {
        return mlid;
    }

    public void setMlid(long mlid) {
        this.mlid = mlid;
    }

    public long getMinfoid() {
        return minfoid;
    }

    public void setMinfoid(long minfoid) {
        this.minfoid = minfoid;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public Type.MovTv getType() {
        return type;
    }

    public void setType(Type.MovTv type) {
        this.type = type;
    }
}
