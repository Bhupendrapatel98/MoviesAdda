package com.example.movieadda.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProfileImagesModel {

        @SerializedName("profiles")
        @Expose
        private List<Images> profiles = null;
        @SerializedName("id")
        @Expose
        private Long id;

        public List<Images> getProfiles() {
            return profiles;
        }

        public void setProfiles(List<Images> profiles) {
            this.profiles = profiles;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

    }