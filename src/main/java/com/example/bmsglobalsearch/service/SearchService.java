package com.example.bmsglobalsearch.service;

import com.example.bmsglobalsearch.entity.Movie;
import com.example.bmsglobalsearch.helper.SearchHelper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class SearchService {

    @Autowired
    SearchHelper searchHelper;

    public List<Movie> searchMovie(String keyword){
          return searchHelper.searchMovies(keyword);
    }
}
