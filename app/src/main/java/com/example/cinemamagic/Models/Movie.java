package com.example.cinema_magic.Models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Movie implements Serializable {
    @SerializedName("imdbID")
    private String imdbID;

    @SerializedName("Title")
    private String title;

    @SerializedName("Year")
    private String year;

    @SerializedName("Plot")
    private String plot;

    @SerializedName("Production")
    private String production;

    @SerializedName("imdbRating")
    private String imdbRating;

    @SerializedName("Poster")
    private String poster;

    @SerializedName("Actors")
    private String movieActors;

    @SerializedName("Director")
    private String movieDirector;

    @SerializedName("Country")
    private String country;

    // Required getters for the app
    public String getMovieActors() {
        return movieActors;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public String getCountry() {
        return country;
    }

    public String getImdbID() {
        return imdbID;
    }
    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getPlot() {
        return plot;
    }

    public String getProduction() {
        return production;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public String getPoster() {
        return poster;
    }

}
