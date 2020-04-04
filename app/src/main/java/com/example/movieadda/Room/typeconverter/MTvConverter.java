package com.example.movieadda.Room.typeconverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class MTvConverter {

    @androidx.room.TypeConverter
    public static com.example.movieadda.utils.Type.MovTv storedStringToTypeMovieOrTvshows(String data) {
        Gson gson = new Gson();

        Type listType = new TypeToken<com.example.movieadda.utils.Type.MovTv>() {}.getType();
        return gson.fromJson(data, listType);
    }

    @androidx.room.TypeConverter
    public static String myObjectsToStoredString(com.example.movieadda.utils.Type.MovTv myObjects) {
        Gson gson = new Gson();
        return gson.toJson(myObjects);
    }
}