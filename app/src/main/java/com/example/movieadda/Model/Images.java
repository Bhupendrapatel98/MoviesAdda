package com.example.movieadda.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Images {

        @SerializedName("iso_639_1")
        @Expose
        private Object iso6391;
        @SerializedName("width")
        @Expose
        private Long width;
        @SerializedName("height")
        @Expose
        private Long height;
        @SerializedName("vote_count")
        @Expose
        private Long voteCount;
        @SerializedName("vote_average")
        @Expose
        private Double voteAverage;
        @SerializedName("file_path")
        @Expose
        private String filePath;
        @SerializedName("aspect_ratio")
        @Expose
        private Double aspectRatio;

        public Object getIso6391() {
            return iso6391;
        }

        public void setIso6391(Object iso6391) {
            this.iso6391 = iso6391;
        }

        public Long getWidth() {
            return width;
        }

        public void setWidth(Long width) {
            this.width = width;
        }

        public Long getHeight() {
            return height;
        }

        public void setHeight(Long height) {
            this.height = height;
        }

        public Long getVoteCount() {
            return voteCount;
        }

        public void setVoteCount(Long voteCount) {
            this.voteCount = voteCount;
        }

        public Double getVoteAverage() {
            return voteAverage;
        }

        public void setVoteAverage(Double voteAverage) {
            this.voteAverage = voteAverage;
        }

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        public Double getAspectRatio() {
            return aspectRatio;
        }

        public void setAspectRatio(Double aspectRatio) {
            this.aspectRatio = aspectRatio;
        }
}
