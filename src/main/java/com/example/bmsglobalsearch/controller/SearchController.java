package com.example.bmsglobalsearch.controller;

import com.example.bmsglobalsearch.entity.Movie;
import com.example.bmsglobalsearch.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search/{keyword}")
public class SearchController {
    @Autowired
    SearchService searchService;

    @GetMapping
    public List<Movie> searchMovie(@PathVariable String keyword) {
        return searchService.searchMovie(keyword);
    }
}
