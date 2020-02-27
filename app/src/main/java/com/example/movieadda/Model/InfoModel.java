package com.example.movieadda.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

    public class InfoModel {

        @SerializedName("adult")
        @Expose
        private Boolean adult;
        @SerializedName("backdrop_path")
        @Expose
        private String backdropPath;
        @SerializedName("belongs_to_collection")
        @Expose
        private BelongsToCollection belongsToCollection;
        @SerializedName("budget")
        @Expose
        private Long budget;
        @SerializedName("genres")
        @Expose
        private List<Genre> genres = null;
        @SerializedName("homepage")
        @Expose
        private String homepage;
        @SerializedName("id")
        @Expose
        private Long id;
        @SerializedName("imdb_id")
        @Expose
        private String imdbId;
        @SerializedName("original_language")
        @Expose
        private String originalLanguage;
        @SerializedName("original_title")
        @Expose
        private String originalTitle;
        @SerializedName("overview")
        @Expose
        private String overview;
        @SerializedName("popularity")
        @Expose
        private Double popularity;
        @SerializedName("poster_path")
        @Expose
        private String posterPath;
        @SerializedName("production_companies")
        @Expose
        private List<ProductionCompany> productionCompanies = null;
        @SerializedName("production_countries")
        @Expose
        private List<ProductionCountry> productionCountries = null;
        @SerializedName("release_date")
        @Expose
        private String releaseDate;
        @SerializedName("revenue")
        @Expose
        private Long revenue;
        @SerializedName("runtime")
        @Expose
        private Long runtime;
        @SerializedName("spoken_languages")
        @Expose
        private List<SpokenLanguage> spokenLanguages = null;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("tagline")
        @Expose
        private String tagline;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("video")
        @Expose
        private Boolean video;
        @SerializedName("vote_average")
        @Expose
        private Double voteAverage;
        @SerializedName("vote_count")
        @Expose
        private Long voteCount;

        public Boolean getAdult() {
            return adult;
        }

        public void setAdult(Boolean adult) {
            this.adult = adult;
        }

        public String getBackdropPath() {
            return backdropPath;
        }

        public void setBackdropPath(String backdropPath) {
            this.backdropPath = backdropPath;
        }

        public BelongsToCollection getBelongsToCollection() {
            return belongsToCollection;
        }

        public void setBelongsToCollection(BelongsToCollection belongsToCollection) {
            this.belongsToCollection = belongsToCollection;
        }

        public Long getBudget() {
            return budget;
        }

        public void setBudget(Long budget) {
            this.budget = budget;
        }

        public List<Genre> getGenres() {
            return genres;
        }

        public void setGenres(List<Genre> genres) {
            this.genres = genres;
        }

        public String getHomepage() {
            return homepage;
        }

        public void setHomepage(String homepage) {
            this.homepage = homepage;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getImdbId() {
            return imdbId;
        }

        public void setImdbId(String imdbId) {
            this.imdbId = imdbId;
        }

        public String getOriginalLanguage() {
            return originalLanguage;
        }

        public void setOriginalLanguage(String originalLanguage) {
            this.originalLanguage = originalLanguage;
        }

        public String getOriginalTitle() {
            return originalTitle;
        }

        public void setOriginalTitle(String originalTitle) {
            this.originalTitle = originalTitle;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public Double getPopularity() {
            return popularity;
        }

        public void setPopularity(Double popularity) {
            this.popularity = popularity;
        }

        public String getPosterPath() {
            return posterPath;
        }

        public void setPosterPath(String posterPath) {
            this.posterPath = posterPath;
        }

        public List<ProductionCompany> getProductionCompanies() {
            return productionCompanies;
        }

        public void setProductionCompanies(List<ProductionCompany> productionCompanies) {
            this.productionCompanies = productionCompanies;
        }

        public List<ProductionCountry> getProductionCountries() {
            return productionCountries;
        }

        public void setProductionCountries(List<ProductionCountry> productionCountries) {
            this.productionCountries = productionCountries;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public Long getRevenue() {
            return revenue;
        }

        public void setRevenue(Long revenue) {
            this.revenue = revenue;
        }

        public Long getRuntime() {
            return runtime;
        }

        public void setRuntime(Long runtime) {
            this.runtime = runtime;
        }

        public List<SpokenLanguage> getSpokenLanguages() {
            return spokenLanguages;
        }

        public void setSpokenLanguages(List<SpokenLanguage> spokenLanguages) {
            this.spokenLanguages = spokenLanguages;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTagline() {
            return tagline;
        }

        public void setTagline(String tagline) {
            this.tagline = tagline;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Boolean getVideo() {
            return video;
        }

        public void setVideo(Boolean video) {
            this.video = video;
        }

        public Double getVoteAverage() {
            return voteAverage;
        }

        public void setVoteAverage(Double voteAverage) {
            this.voteAverage = voteAverage;
        }

        public Long getVoteCount() {
            return voteCount;
        }

        public void setVoteCount(Long voteCount) {
            this.voteCount = voteCount;
        }




    public class BelongsToCollection {

        @SerializedName("id")
        @Expose
        private Long id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("poster_path")
        @Expose
        private String posterPath;
        @SerializedName("backdrop_path")
        @Expose
        private String backdropPath;

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

        public String getPosterPath() {
            return posterPath;
        }

        public void setPosterPath(String posterPath) {
            this.posterPath = posterPath;
        }

        public String getBackdropPath() {
            return backdropPath;
        }

        public void setBackdropPath(String backdropPath) {
            this.backdropPath = backdropPath;
        }

    }

    public class Genre {

        @SerializedName("id")
        @Expose
        private Long id;
        @SerializedName("name")
        @Expose
        private String name;

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

    }


    public class ProductionCompany {

        @SerializedName("id")
        @Expose
        private Long id;
        @SerializedName("logo_path")
        @Expose
        private String logoPath;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("origin_country")
        @Expose
        private String originCountry;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getLogoPath() {
            return logoPath;
        }

        public void setLogoPath(String logoPath) {
            this.logoPath = logoPath;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOriginCountry() {
            return originCountry;
        }

        public void setOriginCountry(String originCountry) {
            this.originCountry = originCountry;
        }

    }

    public class ProductionCountry {

        @SerializedName("iso_3166_1")
        @Expose
        private String iso31661;
        @SerializedName("name")
        @Expose
        private String name;

        public String getIso31661() {
            return iso31661;
        }

        public void setIso31661(String iso31661) {
            this.iso31661 = iso31661;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public class SpokenLanguage {

        @SerializedName("iso_639_1")
        @Expose
        private String iso6391;
        @SerializedName("name")
        @Expose
        private String name;

        public String getIso6391() {
            return iso6391;
        }

        public void setIso6391(String iso6391) {
            this.iso6391 = iso6391;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }


}
