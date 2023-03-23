package com.example.bmsglobalsearch.helper;

import com.example.bmsglobalsearch.dto.MovieDto;
import com.example.bmsglobalsearch.dto.MovieResponseDto;
import com.example.bmsglobalsearch.entity.Actor;
import com.example.bmsglobalsearch.entity.Movie;
import com.example.bmsglobalsearch.enums.CertificateType;
import com.example.bmsglobalsearch.enums.Genre;
import com.example.bmsglobalsearch.enums.Language;
import com.example.bmsglobalsearch.exception.DuplicateRecordException;
import com.example.bmsglobalsearch.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieHelper {

    @Autowired
    MovieRepository movieRepository;


    public void mapMovieRequestToMovie(MovieDto movieDto, Movie movie) {
        movie.setId(movieDto.getId());
        movie.setName(movieDto.getName());
        movie.setDescription(movieDto.getDescription());
        movie.setReleaseDate(movieDto.getReleaseDate());
        movie.setLanguage(Language.valueOf(movieDto.getLanguage().toUpperCase()));
        movie.setGenre(Genre.valueOf(movieDto.getGenre().toUpperCase()));
        movie.setCertificateType(CertificateType.valueOf(movieDto.getCertificateType().toUpperCase()));
        movie.setActors(movieDto.getActorNames()
                .stream()
                .map(Actor::new)
                .collect(Collectors.toList()));
    }

    public void checkGenre(String genre) {
        try {
            Genre.valueOf(genre.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.format("invalid Genre type, select genre from %s",
                    Arrays.toString(Genre.class.getEnumConstants())));
        }
    }

    public void checkLanguage(String language) {
        try {
            Language.valueOf(language.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.format("invalid Language type, select language from %s",
                    Arrays.toString(Language.class.getEnumConstants())));
        }
    }

    public void checkCertificateType(String certificateType) {
        try {
            CertificateType.valueOf(certificateType.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.format("invalid Certificate type, select CertificateType from %s",
                    Arrays.toString(CertificateType.class.getEnumConstants())));
        }
    }


    public void canAdd(MovieDto movieDto) {
        checkGenre(movieDto.getGenre());
        checkLanguage(movieDto.getLanguage());
        checkCertificateType(movieDto.getCertificateType());
        if (movieRepository.existsByNameAndLanguageAndId(movieDto.getName(), Language.valueOf(movieDto.getLanguage().toUpperCase()), movieDto.getId())) {
            throw new DuplicateRecordException(String.format("Movie Already Exists with Name: " + movieDto.getName() + " in Language: " + movieDto.getLanguage()));
        }
    }

    public void checkMovie(Long id) {
        if (!movieRepository.existsById(id))
            throw new EntityNotFoundException("invalid movie id");
    }

    public Movie getMovie(Long movieId) {
        return movieRepository.findById(movieId).get();
    }


    public void canUpdate(Long movieId) {
        checkMovie(movieId);
    }


    public void canDelete(Long movieId) {
        checkMovie(movieId);
    }

    public List<MovieResponseDto> moviesToMovieDto(List<Movie> movies) {
        return movies
                .stream()
                .map(movie -> new MovieResponseDto(movie))
                .collect(Collectors.toList());
    }
}
