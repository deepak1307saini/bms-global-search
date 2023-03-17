package com.example.bmsglobalsearch.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.example.bmsglobalsearch.repository.MovieRepository;
import com.example.bmsglobalsearch.dto.MovieDto;
import com.example.bmsglobalsearch.dto.MovieResponseDto;
import com.example.bmsglobalsearch.dto.ResponseDto;
import com.example.bmsglobalsearch.entity.Movie;
import com.example.bmsglobalsearch.helper.MovieHelper;
import com.example.bmsglobalsearch.repository.MovieRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieHelper movieHelper;



    @Override
    public MovieResponseDto addMovie(MovieDto movieDto) {
        movieHelper.canAdd(movieDto);
        Movie movie = new Movie();
        movieHelper.mapMovieRequestToMovie(movieDto, movie);
        movieRepository.save(movie);
        return new MovieResponseDto(movie);
    }

    @Override
    public List<MovieResponseDto> getMovies() {
        List<Movie> movies = new ArrayList<>();

        movieRepository.findAll()
                .forEach(movies::add);

        return movieHelper.moviesToMovieDto(movies);
    }

    @Override
    public MovieResponseDto getMovie(Long movieId) {
        movieHelper.checkMovie(movieId);
        Movie movie = movieHelper.getMovie(movieId);
        return new MovieResponseDto(movie);
    }

    @Override
    public ResponseDto updateMovie(Long movieId, MovieDto movieDto) {
        movieHelper.canUpdate(movieId);
        Movie movie = movieHelper.getMovie(movieId);
        movieHelper.mapMovieRequestToMovie(movieDto, movie);
        movieRepository.save(movie);
        return new ResponseDto(true, String.format("movie %s updated successfully", movie.getName()));
    }

    @Override
    public ResponseDto deleteMovie(Long movieId) {
        movieHelper.canDelete(movieId);
        Movie movie = movieHelper.getMovie(movieId);
        movieRepository.delete(movie);
        return new ResponseDto(true, String.format("movie %s deleted successfully", movie.getName()));
    }
}
