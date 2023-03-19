package com.example.bmsglobalsearch.controller;

import com.example.bmsglobalsearch.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search/{keyword}")
public class SearchController {
    @Autowired
    SearchService searchService;

    @GetMapping
    public  ResponseEntity<?> searchMovie(@PathVariable String keyword) {
        return new ResponseEntity<>(searchService.searchMovie(keyword), HttpStatus.OK);
    }
}
