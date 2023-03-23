package com.example.bmsglobalsearch.service;

import com.example.bmsglobalsearch.dto.MovieResponseDto;
import com.example.bmsglobalsearch.entity.Movie;
import com.example.bmsglobalsearch.helper.SearchHelper.ISearchMovie;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Data
public class SearchService {

    @Autowired
    List<ISearchMovie>  iSearchMovies;

    public List<MovieResponseDto> searchMovie(String keyword) {
        Set<Movie> movies=new HashSet<>();

        for (ISearchMovie searchMovie:iSearchMovies) {
              movies.addAll(searchMovie.search(keyword));
        }

        return movies.stream().map(movie -> new MovieResponseDto(movie)).collect(Collectors.toList());
    }
}
