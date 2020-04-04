package com.example.movieadda.Room.typeconverter;

import androidx.room.TypeConverter;

import com.example.movieadda.Model.InfoModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class ProductionCountryConverter {
    @TypeConverter
    public static List<InfoModel.ProductionCountry> storedStringToProductionCountrys(String data) {
        Gson gson = new Gson();
        if (data == null) {
            return Collections.emptyList();
        }
        Type listType = new TypeToken<List<InfoModel.ProductionCountry>>() {}.getType();
        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String myObjectsToStoredString(List<InfoModel.ProductionCountry> myObjects) {
        Gson gson = new Gson();
        return gson.toJson(myObjects);
    }
}