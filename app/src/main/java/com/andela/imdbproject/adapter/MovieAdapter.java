package com.andela.imdbproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andela.imdbproject.R;
import com.andela.imdbproject.data.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;

public class MovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Movie> movies;
    private Context context;
    private static final String BASE_IMAGE_URL = "http://image.tmdb.org/t/p/original";

    public MovieAdapter(List<Movie> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View movieView = inflater.inflate(R.layout.movie_item, viewGroup, false);
        return new MovieViewHolder(movieView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        final Movie movie = movies.get(i);
        MovieViewHolder movieViewHolder = (MovieViewHolder) viewHolder;

        Picasso.get().load(BASE_IMAGE_URL + movie.getImageUrl()).into(movieViewHolder.movieImage);
        movieViewHolder.movieTitle.setText(movie.getTitle());
        movieViewHolder.year.setText(String.format(Locale.ENGLISH, "%s", movie.getReleaseDate().substring(0, 4)));
        movieViewHolder.rating.setText(String.format(Locale.ENGLISH, "%.1f", movie.getRating()));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    private class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView movieImage;
        TextView movieTitle;
        TextView year;
        TextView rating;

        MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.imageView);
            movieTitle = itemView.findViewById(R.id.title);
            year = itemView.findViewById(R.id.year);
            rating = itemView.findViewById(R.id.rating);
        }
    }
}
