package com.Abd.Movie_Recommendation_API;

import com.Abd.Movie_Recommendation_API.controller.MovieController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MovieRecommendationApiApplication {

	public static void main(String[] args) {
		ApplicationContext container = SpringApplication.run(MovieRecommendationApiApplication.class, args);
		MovieController controller = container.getBean(MovieController.class);
	}

}
