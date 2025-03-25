package com.example.cinema_magic;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cinema_magic.Adapters.MovieAdapter;
import com.example.cinema_magic.Models.Movie;
import com.example.cinema_magic.ViewModel.MovieViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText searchField;
    private Button searchButton;
    private RecyclerView movieRecycler;
    private MovieAdapter movieAdapter;
    private MovieViewModel movieViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchField = findViewById(R.id.searchField);
        searchButton = findViewById(R.id.searchButton);
        movieRecycler = findViewById(R.id.movieRecycler);
        movieRecycler.setLayoutManager(new LinearLayoutManager(this));

        movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);

        searchButton.setOnClickListener(v -> {
            String query = searchField.getText().toString().trim();
            if (TextUtils.isEmpty(query)) {
                Toast.makeText(this, "Please enter a movie title", Toast.LENGTH_SHORT).show();
                return;
            }

            movieViewModel.searchMovies(query).observe(this, movies -> {
                if (movies == null) {
                    Toast.makeText(this, "Error fetching movies. Please enter movie title again!", Toast.LENGTH_SHORT).show();
                } else if (movies.isEmpty()) {
                    Toast.makeText(this, "No movies found", Toast.LENGTH_SHORT).show();
                } else {
                    movieAdapter = new MovieAdapter(this, movies);
                    movieRecycler.setAdapter(movieAdapter);

                    // Set up item click listener
                    movieAdapter.setOnItemClickListener(movie -> {
                        movieViewModel.getMovieDetails(movie.getImdbID()).observe(this, detailedMovie -> {
                            if (detailedMovie != null) {
                                Intent intent = new Intent(MainActivity.this, MovieDetailsActivity.class);
                                intent.putExtra("movie", detailedMovie);
                                startActivity(intent);
                            } else {
                                Toast.makeText(this, "Error fetching movie details", Toast.LENGTH_SHORT).show();
                            }
                        });
                    });
                }
            });
        });

    }
}






