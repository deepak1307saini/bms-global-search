package com.example.bmsglobalsearch.service;

import com.example.bmsglobalsearch.dto.MovieDto;
import com.example.bmsglobalsearch.dto.MovieResponseDto;
import com.example.bmsglobalsearch.dto.ResponseDto;

import java.util.List;

public interface MovieService {
    MovieResponseDto addMovie(MovieDto movieDto);

    List<MovieResponseDto> getMovies();

    MovieResponseDto getMovie(Long movieId);

    ResponseDto updateMovie(Long movieId, MovieDto movieRequestDTO);

    ResponseDto deleteMovie(Long movieId);
}
