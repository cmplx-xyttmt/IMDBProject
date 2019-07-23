package com.andela.imdbproject.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieList {


    @SerializedName("items")
    private List<Movie> movies;

    public MovieList(List<Movie> movies) {
        this.movies = movies;
    }


    public List<Movie> getMovies() {
        return movies;
    }
}
