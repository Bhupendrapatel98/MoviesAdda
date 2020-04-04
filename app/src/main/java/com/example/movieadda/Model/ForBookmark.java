package com.example.movieadda.Model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.movieadda.Room.typeconverter.MTvConverter;
import com.example.movieadda.utils.Type;

@Entity(foreignKeys = @ForeignKey(entity = InfoModel.class,
        parentColumns = "id",
        childColumns = "minfo",
        onDelete = ForeignKey.CASCADE))
@TypeConverters({MTvConverter.class})

public class ForBookmark {

    @PrimaryKey(autoGenerate = true)
    int mid;
    Long minfo;

    Type.MovTv type;


    public ForBookmark(Long minfo, Type.MovTv type) {
        this.minfo = minfo;
        this.type = type;
    }

    public Type.MovTv getType() {
        return type;
    }

    public void setType(Type.MovTv type) {
        this.type = type;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public Long getMinfo() {
        return minfo;
    }

    public void setMinfo(Long minfo) {
        this.minfo = minfo;
    }
}
