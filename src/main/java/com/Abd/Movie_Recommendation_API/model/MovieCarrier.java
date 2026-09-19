package com.Abd.Movie_Recommendation_API.model;

import java.time.LocalDate;

public record MovieCarrier(
        String name,
        Genre genre,
        double rating,
        LocalDate releaseYear
) {
}
