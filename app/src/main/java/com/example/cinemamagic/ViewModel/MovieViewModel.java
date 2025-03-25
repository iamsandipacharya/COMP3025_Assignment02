package com.example.cinema_magic.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.cinema_magic.Models.Movie;
import com.example.cinema_magic.Repository.MovieRepository;

import java.util.List;

public class MovieViewModel extends ViewModel {

    private final MovieRepository movieRepository;

    public MovieViewModel() {
        movieRepository = new MovieRepository();
    }

    public LiveData<List<Movie>> searchMovies(String query) {
        return movieRepository.searchMovies(query);
    }

    public LiveData<Movie> getMovieDetails(String imdbID) {
        return movieRepository.getMovieDetails(imdbID);
    }
}

