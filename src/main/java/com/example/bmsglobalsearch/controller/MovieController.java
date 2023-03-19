package com.example.bmsglobalsearch.controller;

import com.example.bmsglobalsearch.dto.MovieDto;
import com.example.bmsglobalsearch.dto.MovieResponseDto;
import com.example.bmsglobalsearch.dto.ResponseDto;
import com.example.bmsglobalsearch.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody MovieDto movieDto) {
        MovieResponseDto movieResponseDto= movieService.addMovie(movieDto);
        return new ResponseEntity<>(movieResponseDto, HttpStatus.OK);
    }


    @GetMapping("/{movieId}")
    public ResponseEntity<?> getMovie(@PathVariable Long movieId) {
        MovieResponseDto movieResponseDto= movieService.getMovie(movieId);
        return new ResponseEntity<>(movieResponseDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getMovies() {
       List< MovieResponseDto> movieResponseDtos = movieService.getMovies();
        return new ResponseEntity<>(movieResponseDtos, HttpStatus.OK);
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long movieId) {
        ResponseDto responseDto= movieService.deleteMovie(movieId);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PutMapping("/{movieId}")
    public ResponseDto updateMovie(@PathVariable long movieId,@Valid @RequestBody MovieDto movieDto) {

        ResponseDto responseDto= movieService.updateMovie(movieId, movieDto);
        return responseDto;
    }
}
