package com.Abd.Movie_Recommendation_API.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Entity
public class Movie {

    @Id
    private int Id;
    private String name;
    private Genre genre;
    private double rating;
    private LocalDate releaseYear;

    public Movie(){}
    public Movie(int id, String name, Genre genre, double rating, LocalDate releaseYear) {
        Id = id;
        this.name = name;
        this.genre = genre;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public LocalDate getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(LocalDate releaseYear) {
        this.releaseYear = releaseYear;
    }
}
