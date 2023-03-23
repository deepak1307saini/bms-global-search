package com.example.bmsglobalsearch.helper.SearchHelper;

import com.example.bmsglobalsearch.entity.Movie;
import com.example.bmsglobalsearch.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SearchByDescription implements ISearchMovie{
    @Autowired
    MovieRepository movieRepository;

    @Override
    public List<Movie> search(String keyword){
        Set<Movie> movies=new HashSet<>();
        movies.addAll(movieRepository.findByDescriptionContaining(keyword));
        movies.addAll(movieRepository.findByDescriptionFuzzy(keyword));

        return new ArrayList<>(movies);
    }
}
