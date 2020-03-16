package com.example.movieadda.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PersonMoviesModel {

    @SerializedName("cast")
    @Expose
    private List<Result> cast = null;
    @SerializedName("crew")
    @Expose
    private List<Result> crew = null;
    @SerializedName("id")
    @Expose
    private long id;

    public List<Result> getCast() {
        return cast;
    }

    public void setCast(List<Result> cast) {
        this.cast = cast;
    }

    public List<Result> getCrew() {
        return crew;
    }

    public void setCrew(List<Result> crew) {
        this.crew = crew;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
