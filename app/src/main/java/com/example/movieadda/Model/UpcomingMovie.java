package com.example.movieadda.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


    public class UpcomingMovie {

        @SerializedName("results")
        @Expose
        private List<Result> results = null;
        @SerializedName("page")
        @Expose
        private Long page;
        @SerializedName("total_results")
        @Expose
        private Long totalResults;
        @SerializedName("dates")
        @Expose
        private Dates dates;
        @SerializedName("total_pages")
        @Expose
        private Long totalPages;

        public List<Result> getResults() {
            return results;
        }

        public void setResults(List<Result> results) {
            this.results = results;
        }

        public Long getPage() {
            return page;
        }

        public void setPage(Long page) {
            this.page = page;
        }

        public Long getTotalResults() {
            return totalResults;
        }

        public void setTotalResults(Long totalResults) {
            this.totalResults = totalResults;
        }

        public Dates getDates() {
            return dates;
        }

        public void setDates(Dates dates) {
            this.dates = dates;
        }

        public Long getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(Long totalPages) {
            this.totalPages = totalPages;
        }



    public class Dates {

        @SerializedName("maximum")
        @Expose
        private String maximum;
        @SerializedName("minimum")
        @Expose
        private String minimum;

        public String getMaximum() {
            return maximum;
        }

        public void setMaximum(String maximum) {
            this.maximum = maximum;
        }

        public String getMinimum() {
            return minimum;
        }

        public void setMinimum(String minimum) {
            this.minimum = minimum;
        }

    }





}
