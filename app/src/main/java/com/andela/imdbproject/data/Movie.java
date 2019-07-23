package com.andela.imdbproject.data;

public class Movie {

    private String imageUrl;
    private String title;
    private int year;
    private double rating;

    public Movie(String imageUrl, String title, int year, double rating) {
        this.title = title;
        this.year = year;
        this.rating = rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public double getRating() {
        return rating;
    }
}
