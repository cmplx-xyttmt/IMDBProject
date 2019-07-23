package com.andela.imdbproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.andela.imdbproject.adapter.MovieAdapter;
import com.andela.imdbproject.data.Movie;
import com.andela.imdbproject.presenter.MoviePresenter;
import com.andela.imdbproject.view.MovieListView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieListView {
    RecyclerView recyclerView;
    MovieAdapter adapter;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayoutManager = new LinearLayoutManager(this);

        recyclerView = findViewById(R.id.moviesRecyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);

        MoviePresenter moviePresenter = new MoviePresenter(this);
        moviePresenter.getListOfMovies();
    }

    @Override
    public void movieListReady(List<Movie> movies) {
        adapter = new MovieAdapter(movies, this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
