package com.Abd.Movie_Recommendation_API.controller;

import com.Abd.Movie_Recommendation_API.model.Genre;
import com.Abd.Movie_Recommendation_API.model.Movie;
import com.Abd.Movie_Recommendation_API.model.MovieCarrier;
import com.Abd.Movie_Recommendation_API.model.MovieUpdateRequest;
import com.Abd.Movie_Recommendation_API.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    MovieService service;
    public MovieController(MovieService service) {this.service=service;}


    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return service.getMovies();
    }

    @PostMapping("/movies")
    public Movie addMovie(@RequestBody MovieCarrier carrier) {
        return service.addMovie(carrier);
    }

    @DeleteMapping("/movies")
    public void deleteMovie(@RequestBody int Id) {
        service.deleteMovie(Id);
    }

    @PutMapping("/movies/{Id}")
    public Movie updateMovie(@PathVariable int Id, @RequestBody MovieUpdateRequest request) {
        return service.updateMovie(request);
    }

    @GetMapping("/movies/{Id}")
    public Movie getMovieById(@PathVariable int Id) {
        return service.getMovieById(Id);
    }

    @GetMapping("/movies/genre/{genre}")
    public List<Movie> getMoviesByGenre(@PathVariable Genre genre){
        return service.getMoviesByGenre(genre);
    }

    @GetMapping("/movies/top-rated")
    public List<Movie> getTop_ratedMovies(){
        return service.getTop_ratedMovies();
    }

    @GetMapping("/movies/search")
    public Movie searchMovieByName(@RequestParam String name){
        return service.searchMovieByName(name);
    }

    @GetMapping("/movies/year")
    public List<Movie> getMoviesWithinCerainPeriod(@RequestParam int from, @RequestParam int to){
        return service.getMoviesWithinCerainPeriod(from, to);
    }

    @GetMapping("/movies/recommend")
    public List<Movie> recommendMovies(@RequestParam Genre genre, @RequestParam double rating){
        return service.recommendMovies(genre, rating);
    }
}
