package com.example.cinema_magic.Models;

import com.google.gson.annotations.SerializedName;
import com.example.cinema_magic.Models.Movie;

import java.util.List;

public class MovieResponse {
    private List<Movie> Search;

    public List<Movie> getMovies() {
        return Search;
    }

    public void setMovies(List<Movie> movies) {
        this.Search = movies;
    }
}
