package com.andela.imdbproject.service;

import com.andela.imdbproject.data.MovieList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieAPI {

    @GET("list/4?api_key=3f911b776823abb2d83ae03666802b86")
    Call<MovieList> getMovies();
}
