package com.example.movieadda.Room.typeconverter;

import androidx.room.TypeConverter;

import com.example.movieadda.Model.InfoModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class GenreConverters {
    @TypeConverter
    public static List<InfoModel.Genre> storedStringToGenres(String data) {
        Gson gson = new Gson();
        if (data == null) {
            return Collections.emptyList();
        }
        Type listType = new TypeToken<List<InfoModel.Genre>>() {}.getType();
        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String myObjectsToStoredString(List<InfoModel.Genre> myObjects) {
        Gson gson = new Gson();
        return gson.toJson(myObjects);
    }
}