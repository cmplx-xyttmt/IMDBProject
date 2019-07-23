package com.andela.imdbproject.view;

import com.andela.imdbproject.data.Movie;

import java.util.List;

public interface MovieListView {

    void movieListReady(List<Movie> movies);
}
