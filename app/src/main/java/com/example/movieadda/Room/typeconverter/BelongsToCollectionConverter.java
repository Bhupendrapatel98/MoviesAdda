package com.example.movieadda.Room.typeconverter;

import androidx.room.TypeConverter;

import com.example.movieadda.Model.InfoModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class BelongsToCollectionConverter {
    @TypeConverter
    public static InfoModel.BelongsToCollection storedStringToBelongsToCollections(String data) {
        Gson gson = new Gson();
        Type listType = new TypeToken<InfoModel.BelongsToCollection>() {}.getType();
        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String myObjectsToStoredString(InfoModel.BelongsToCollection myObjects) {
        Gson gson = new Gson();
        return gson.toJson(myObjects);
    }
}