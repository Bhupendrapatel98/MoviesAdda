package com.example.movieadda.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.movieadda.Room.typeconverter.MTvConverter;
import com.example.movieadda.utils.Type;

@Entity
@TypeConverters({MTvConverter.class
})
public class MyList {

    @PrimaryKey(autoGenerate = true)
    Long id;
    String name;
    int size;
    Type.MovTv type;

    public MyList(String name, int size, Type.MovTv type) {
        this.name = name;
        this.size = size;
        this.type = type;
    }

    @Override
    public String toString() {
        return "MyList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", type=" + type +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Type.MovTv getType() {
        return type;
    }

    public void setType(Type.MovTv type) {
        this.type = type;
    }
}