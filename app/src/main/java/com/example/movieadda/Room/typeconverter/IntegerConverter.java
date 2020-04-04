package com.example.movieadda.Room.typeconverter;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class IntegerConverter {
    @TypeConverter
    public static List<Integer> storedStringToIntegers(String data) {
        Gson gson = new Gson();
        if (data == null) {
            return Collections.emptyList();
        }
        Type listType = new TypeToken<List<Integer>>() {}.getType();
        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String integerToStoredString(List<Integer> myObjects) {
        Gson gson = new Gson();
        return gson.toJson(myObjects);
    }
}