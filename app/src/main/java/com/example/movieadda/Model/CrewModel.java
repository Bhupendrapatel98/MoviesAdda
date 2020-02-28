package com.example.movieadda.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CrewModel {

        @SerializedName("id")
        @Expose
        private Long id;
        @SerializedName("cast")
        @Expose
        private List<Cast> cast = null;
        @SerializedName("crew")
        @Expose
        private List<Crew> crew = null;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public List<Cast> getCast() {
            return cast;
        }

        public void setCast(List<Cast> cast) {
            this.cast = cast;
        }

        public List<Crew> getCrew() {
            return crew;
        }

        public void setCrew(List<Crew> crew) {
            this.crew = crew;
        }

        public class Cast {

            @SerializedName("cast_id")
            @Expose
            private Long castId;
            @SerializedName("character")
            @Expose
            private String character;
            @SerializedName("credit_id")
            @Expose
            private String creditId;
            @SerializedName("gender")
            @Expose
            private Long gender;
            @SerializedName("id")
            @Expose
            private Long id;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("order")
            @Expose
            private Long order;
            @SerializedName("profile_path")
            @Expose
            private Object profilePath;

            public Long getCastId() {
                return castId;
            }

            public void setCastId(Long castId) {
                this.castId = castId;
            }

            public String getCharacter() {
                return character;
            }

            public void setCharacter(String character) {
                this.character = character;
            }

            public String getCreditId() {
                return creditId;
            }

            public void setCreditId(String creditId) {
                this.creditId = creditId;
            }

            public Long getGender() {
                return gender;
            }

            public void setGender(Long gender) {
                this.gender = gender;
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

            public Long getOrder() {
                return order;
            }

            public void setOrder(Long order) {
                this.order = order;
            }

            public Object getProfilePath() {
                return profilePath;
            }

            public void setProfilePath(Object profilePath) {
                this.profilePath = profilePath;
            }

        }

        public class Crew {

            @SerializedName("credit_id")
            @Expose
            private String creditId;
            @SerializedName("department")
            @Expose
            private String department;
            @SerializedName("gender")
            @Expose
            private Long gender;
            @SerializedName("id")
            @Expose
            private Long id;
            @SerializedName("job")
            @Expose
            private String job;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("profile_path")
            @Expose
            private Object profilePath;

            public String getCreditId() {
                return creditId;
            }

            public void setCreditId(String creditId) {
                this.creditId = creditId;
            }

            public String getDepartment() {
                return department;
            }

            public void setDepartment(String department) {
                this.department = department;
            }

            public Long getGender() {
                return gender;
            }

            public void setGender(Long gender) {
                this.gender = gender;
            }

            public Long getId() {
                return id;
            }

            public void setId(Long id) {
                this.id = id;
            }

            public String getJob() {
                return job;
            }

            public void setJob(String job) {
                this.job = job;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Object getProfilePath() {
                return profilePath;
            }

            public void setProfilePath(Object profilePath) {
                this.profilePath = profilePath;
            }

        }


    }
