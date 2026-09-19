package com.Abd.Movie_Recommendation_API.service;

import com.Abd.Movie_Recommendation_API.model.Genre;
import com.Abd.Movie_Recommendation_API.model.Movie;
import com.Abd.Movie_Recommendation_API.model.MovieCarrier;
import com.Abd.Movie_Recommendation_API.model.MovieUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    List<Movie> movies = new ArrayList<>();
    int nextId = 1;

    public List<Movie> getMovies() {
        return movies;
    }

    public Movie addMovie(MovieCarrier carrier) {
         movies.add(new Movie(
                nextId++,
                carrier.name(),
                carrier.genre(),
                carrier.rating(),
                carrier.releaseYear()
        ));
         return movies.get(movies.size()-1);
    }

    public void deleteMovie(int Id) {
        Movie movie = movies.stream().filter(mov -> mov.getId() == Id).findFirst().orElseThrow();
        movies.remove(movie);
    }

    public Movie updateMovie(MovieUpdateRequest request) {
        Movie movie = movies.stream().filter(mov -> mov.getId() == request.Id()).findFirst().orElseThrow();
        movie.setRating(request.rating());
        return movie;
    }

    public Movie getMovieById(int Id) {
        return movies.stream()
                .filter(movie -> movie.getId() == Id)
                .findFirst()
                .orElseThrow();
    }

    public List<Movie> getMoviesByGenre(Genre genre){
        List<Movie> gen = new ArrayList<>();
        for(Movie movie : movies)
            if(movie.getGenre() == genre)
                gen.add(movie);
        return gen;
    }

    public List<Movie> getTop_ratedMovies() {
        List<Movie> top_ratedMovies = new ArrayList<>();
        for(Movie movie : movies)
            if(movie.getRating() >= 7)
                top_ratedMovies.add(movie);
        return top_ratedMovies;
    }

    public Movie searchMovieByName(String name) {
        return movies.stream()
                .filter(movie -> movie.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow();
    }

    public List<Movie> getMoviesWithinCerainPeriod(int fromYear, int toYear) {
        return movies.stream()
                .filter(movie -> fromYear <= movie.getReleaseYear().getYear()
                        && movie.getReleaseYear().getYear() <= toYear)
                .toList();
    }

    public List<Movie> recommendMovies(Genre genre, double rating) {
        return movies.stream()
                .filter(movie -> movie.getGenre() == genre && movie.getRating() == rating)
                .toList();
    }


}
