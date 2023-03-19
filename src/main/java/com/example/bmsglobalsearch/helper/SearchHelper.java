package com.example.bmsglobalsearch.helper;

import com.example.bmsglobalsearch.entity.Movie;
import com.example.bmsglobalsearch.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class SearchHelper {

    @Autowired
    MovieRepository movieRepository;

    public List<Movie> searchMovies(String keyword) {
        Set<Movie> movies = new HashSet<>();

        movies.addAll(movieRepository.findByNameContaining(keyword));
        movies.addAll(movieRepository.findByNameFuzzy(keyword));

        movies.addAll(movieRepository.findByActorsNameContaining(keyword));
        movies.addAll(movieRepository.findByActorsNameFuzzy(keyword));

        movies.addAll(movieRepository.findByDescriptionContaining(keyword));
        movies.addAll(movieRepository.findByDescriptionFuzzy(keyword));

        movies.addAll(movieRepository.findByGenreFuzzy(keyword.toUpperCase()));

        movies.addAll(movieRepository.findByLanguageFuzzy(keyword.toUpperCase()));
        System.out.println(movies);


        return movies.stream().collect(Collectors.toList());
    }

}
