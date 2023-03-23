package com.example.bmsglobalsearch.helper.SearchHelper;


import com.example.bmsglobalsearch.entity.Movie;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ISearchMovie {
    List<Movie> search(String keyword);
}
