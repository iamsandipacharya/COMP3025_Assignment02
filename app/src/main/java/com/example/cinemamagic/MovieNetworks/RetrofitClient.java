package com.example.cinema_magic.MovieNetworks;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient instance;
    private final Retrofit retrofit;
    private final MovieApiService apiService;

    private RetrofitClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.omdbapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(MovieApiService.class);
    }

    public static RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }
    public MovieApiService getApiService() {
        return apiService;
    }
}
