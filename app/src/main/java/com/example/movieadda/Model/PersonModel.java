package com.example.movieadda.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PersonModel {

        @SerializedName("birthday")
        @Expose
        private String birthday;
        @SerializedName("known_for_department")
        @Expose
        private String knownForDepartment;
        @SerializedName("deathday")
        @Expose
        private String deathday;
        @SerializedName("id")
        @Expose
        private Long id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("also_known_as")
        @Expose
        private List<Object> alsoKnownAs = null;
        @SerializedName("gender")
        @Expose
        private Long gender;
        @SerializedName("biography")
        @Expose
        private String biography;
        @SerializedName("popularity")
        @Expose
        private Double popularity;
        @SerializedName("place_of_birth")
        @Expose
        private Object placeOfBirth;
        @SerializedName("profile_path")
        @Expose
        private Object profilePath;
        @SerializedName("adult")
        @Expose
        private Boolean adult;
        @SerializedName("imdb_id")
        @Expose
        private String imdbId;
        @SerializedName("homepage")
        @Expose
        private Object homepage;

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getKnownForDepartment() {
            return knownForDepartment;
        }

        public void setKnownForDepartment(String knownForDepartment) {
            this.knownForDepartment = knownForDepartment;
        }

        public String getDeathday() {
            return deathday;
        }

        public void setDeathday(String deathday) {
            this.deathday = deathday;
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

        public List<Object> getAlsoKnownAs() {
            return alsoKnownAs;
        }

        public void setAlsoKnownAs(List<Object> alsoKnownAs) {
            this.alsoKnownAs = alsoKnownAs;
        }

        public Long getGender() {
            return gender;
        }

        public void setGender(Long gender) {
            this.gender = gender;
        }

        public String getBiography() {
            return biography;
        }

        public void setBiography(String biography) {
            this.biography = biography;
        }

        public Double getPopularity() {
            return popularity;
        }

        public void setPopularity(Double popularity) {
            this.popularity = popularity;
        }

        public Object getPlaceOfBirth() {
            return placeOfBirth;
        }

        public void setPlaceOfBirth(Object placeOfBirth) {
            this.placeOfBirth = placeOfBirth;
        }

        public Object getProfilePath() {
            return profilePath;
        }

        public void setProfilePath(Object profilePath) {
            this.profilePath = profilePath;
        }

        public Boolean getAdult() {
            return adult;
        }

        public void setAdult(Boolean adult) {
            this.adult = adult;
        }

        public String getImdbId() {
            return imdbId;
        }

        public void setImdbId(String imdbId) {
            this.imdbId = imdbId;
        }

        public Object getHomepage() {
            return homepage;
        }

        public void setHomepage(Object homepage) {
            this.homepage = homepage;
        }

    }

