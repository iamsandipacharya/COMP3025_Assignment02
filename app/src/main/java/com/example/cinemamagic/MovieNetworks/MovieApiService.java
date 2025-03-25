package com.example.cinema_magic.MovieNetworks;

import com.example.cinema_magic.Models.Movie;
import com.example.cinema_magic.Models.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {
    @GET("/")
    Call<MovieResponse> searchMovies(@Query("s") String title, @Query("apikey") String apiKey);

    // Fetch movie details by IMDB ID
    @GET("/")
    Call<Movie> getMovieDetails(@Query("i") String imdbID, @Query("apikey") String apiKey);
}
