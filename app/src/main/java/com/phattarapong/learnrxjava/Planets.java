package com.phattarapong.learnrxjava;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Phattarapong on 10/9/2017.
 */

public class Planets {

    @SerializedName("count")
    private int count;
    @SerializedName("next")
    private String next;
    @SerializedName("previous")
    private Object previous;
    @SerializedName("results")
    private List<ResultsBean> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean implements Parcelable {

        @SerializedName("name")
        private String name;
        @SerializedName("rotation_period")
        private String rotationPeriod;
        @SerializedName("orbital_period")
        private String orbitalPeriod;
        @SerializedName("diameter")
        private String diameter;
        @SerializedName("climate")
        private String climate;
        @SerializedName("gravity")
        private String gravity;
        @SerializedName("terrain")
        private String terrain;
        @SerializedName("surface_water")
        private String surfaceWater;
        @SerializedName("population")
        private String population;
        @SerializedName("created")
        private String created;
        @SerializedName("edited")
        private String edited;
        @SerializedName("url")
        private String url;
        @SerializedName("residents")
        private List<String> residents;
        @SerializedName("films")
        private List<String> films;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRotationPeriod() {
            return rotationPeriod;
        }

        public void setRotationPeriod(String rotationPeriod) {
            this.rotationPeriod = rotationPeriod;
        }

        public String getOrbitalPeriod() {
            return orbitalPeriod;
        }

        public void setOrbitalPeriod(String orbitalPeriod) {
            this.orbitalPeriod = orbitalPeriod;
        }

        public String getDiameter() {
            return diameter;
        }

        public void setDiameter(String diameter) {
            this.diameter = diameter;
        }

        public String getClimate() {
            return climate;
        }

        public void setClimate(String climate) {
            this.climate = climate;
        }

        public String getGravity() {
            return gravity;
        }

        public void setGravity(String gravity) {
            this.gravity = gravity;
        }

        public String getTerrain() {
            return terrain;
        }

        public void setTerrain(String terrain) {
            this.terrain = terrain;
        }

        public String getSurfaceWater() {
            return surfaceWater;
        }

        public void setSurfaceWater(String surfaceWater) {
            this.surfaceWater = surfaceWater;
        }

        public String getPopulation() {
            return population;
        }

        public void setPopulation(String population) {
            this.population = population;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getEdited() {
            return edited;
        }

        public void setEdited(String edited) {
            this.edited = edited;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<String> getResidents() {
            return residents;
        }

        public void setResidents(List<String> residents) {
            this.residents = residents;
        }

        public List<String> getFilms() {
            return films;
        }

        public void setFilms(List<String> films) {
            this.films = films;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.name);
            dest.writeString(this.rotationPeriod);
            dest.writeString(this.orbitalPeriod);
            dest.writeString(this.diameter);
            dest.writeString(this.climate);
            dest.writeString(this.gravity);
            dest.writeString(this.terrain);
            dest.writeString(this.surfaceWater);
            dest.writeString(this.population);
            dest.writeString(this.created);
            dest.writeString(this.edited);
            dest.writeString(this.url);
            dest.writeStringList(this.residents);
            dest.writeStringList(this.films);
        }

        public ResultsBean() {
        }

        protected ResultsBean(Parcel in) {
            this.name = in.readString();
            this.rotationPeriod = in.readString();
            this.orbitalPeriod = in.readString();
            this.diameter = in.readString();
            this.climate = in.readString();
            this.gravity = in.readString();
            this.terrain = in.readString();
            this.surfaceWater = in.readString();
            this.population = in.readString();
            this.created = in.readString();
            this.edited = in.readString();
            this.url = in.readString();
            this.residents = in.createStringArrayList();
            this.films = in.createStringArrayList();
        }

        public static final Parcelable.Creator<ResultsBean> CREATOR = new Parcelable.Creator<ResultsBean>() {
            @Override
            public ResultsBean createFromParcel(Parcel source) {
                return new ResultsBean(source);
            }

            @Override
            public ResultsBean[] newArray(int size) {
                return new ResultsBean[size];
            }
        };
    }
}
