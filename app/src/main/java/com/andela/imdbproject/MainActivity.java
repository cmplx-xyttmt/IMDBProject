package com.andela.imdbproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.andela.imdbproject.adapter.MovieAdapter;
import com.andela.imdbproject.data.DummyData;
import com.andela.imdbproject.data.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Movie> movies = new ArrayList<>();
        movies.add(DummyData.movie1);
        movies.add(DummyData.movie2);
        movies.add(DummyData.movie3);

        RecyclerView recyclerView = findViewById(R.id.moviesRecyclerView);
        MovieAdapter adapter = new MovieAdapter(movies, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
