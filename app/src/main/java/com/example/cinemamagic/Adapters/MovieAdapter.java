package com.example.cinema_magic.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.cinema_magic.Models.Movie;
import com.example.cinema_magic.MovieNetworks.MovieApiService;
import com.example.cinema_magic.MovieNetworks.RetrofitClient;
import com.example.cinema_magic.R;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private final Context context;
    private final List<Movie> movies;
    private OnItemClickListener onRowItemsClickListener;
    private static final String API_KEY = "12542ee0";

    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    public interface OnItemClickListener {
        void onItemClick(Movie movie);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onRowItemsClickListener = listener;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movies.get(position);

        holder.title.setText(movie.getTitle() != null ? movie.getTitle() : "No Title");
        holder.year.setText(movie.getYear() != null ? movie.getYear() : "Unknown Year");
        holder.production.setText(movie.getProduction() != null ? movie.getProduction() : "N/A");

        fetchMovieDetails(movie.getImdbID(), holder);

        holder.itemView.setOnClickListener(v -> {
            if (onRowItemsClickListener != null) {
                onRowItemsClickListener.onItemClick(movie);
            }
        });
    }

    private void fetchMovieDetails(String imdbID, MovieViewHolder holder) {
        if (imdbID == null || imdbID.isEmpty()) {
            holder.rating.setText("Rating: N/A");
            return;
        }

        MovieApiService apiService = RetrofitClient.getInstance().getApiService();
        Call<Movie> call = apiService.getMovieDetails(imdbID, API_KEY);

        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(@NonNull Call<Movie> call, @NonNull Response<Movie> response) {
                if (response.isSuccessful() && response.body() != null) {
                    holder.rating.setText(response.body().getImdbRating() != null ?
                            "Rating: " + response.body().getImdbRating() : "Rating: N/A");
                } else {
                    holder.rating.setText("Rating: N/A");
                }
            }

            @Override
            public void onFailure(@NonNull Call<Movie> call, @NonNull Throwable t) {
                holder.rating.setText("Rating: N/A");
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies != null ? movies.size() : 0;
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView title, rating, year, production;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.rowMovieTitle);
            rating = itemView.findViewById(R.id.rowMovieRating);
            year = itemView.findViewById(R.id.rowMovieYear);
            production = itemView.findViewById(R.id.rowMovieStudio);
        }
    }
}

