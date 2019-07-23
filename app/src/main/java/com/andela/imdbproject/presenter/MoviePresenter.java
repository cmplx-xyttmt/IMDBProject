package com.andela.imdbproject.presenter;


import android.support.annotation.NonNull;
import android.util.Log;

import com.andela.imdbproject.data.MovieList;
import com.andela.imdbproject.service.MovieService;
import com.andela.imdbproject.view.MovieListView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviePresenter {

    private MovieService movieService;
    private MovieListView movieListView;

    public MoviePresenter(MovieListView movieListView) {
        this.movieListView = movieListView;
        if (this.movieService == null) {
            this.movieService = new MovieService();
        }
    }

    public void getListOfMovies() {
        movieService
                .getMovieAPI()
                .getMovies()
                .enqueue(new Callback<MovieList>() {
                    @Override
                    public void onResponse(@NonNull Call<MovieList> call, @NonNull Response<MovieList> response) {
                        Log.d("IMDBProject", response.toString());
                        if (response.body() != null) {
                            movieListView.movieListReady(response.body().getMovies());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<MovieList> call, @NonNull Throwable t) {
                        Log.e("IMDBProject", t.getLocalizedMessage());
                    }
                });
    }
}
