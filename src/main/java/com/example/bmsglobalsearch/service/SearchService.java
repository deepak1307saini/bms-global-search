package com.example.bmsglobalsearch.service;

import com.example.bmsglobalsearch.dto.MovieResponseDto;
import com.example.bmsglobalsearch.helper.SearchHelper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class SearchService {

    @Autowired
    SearchHelper searchHelper;

    public List<MovieResponseDto> searchMovie(String keyword) {
        return searchHelper.searchMovies(keyword).stream().map(movie -> new MovieResponseDto(movie)).collect(Collectors.toList());
    }
}
