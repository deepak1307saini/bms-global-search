package com.example.bmsglobalsearch.repository;

import com.example.bmsglobalsearch.entity.Movie;
import com.example.bmsglobalsearch.enums.Language;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface MovieRepository extends ElasticsearchRepository<Movie, Long> {


    boolean existsByNameAndLanguageAndId(String name, Language language, long movieId);

    List<Movie> findByNameContaining(String partialMovieName);

    @Query("{ \"match\": { \"name\": { \"query\": \"?0\", \"fuzziness\": 2 } } }")
    List<Movie> findByNameFuzzy(String partialActorName);

    List<Movie> findByActorsNameContaining(String partialActorName);

    @Query("{ \"match\": { \"actors.name\": { \"query\": \"?0\", \"fuzziness\": 2 } } }")
    List<Movie> findByActorsNameFuzzy(String partialActorName);

    List<Movie> findByDescriptionContaining(String description);

    @Query("{ \"match\": { \"description\": { \"query\": \"?0\", \"fuzziness\": 2 } } }")
    List<Movie> findByDescriptionFuzzy(String description);

    @Query("{ \"match\": { \"genre\": { \"query\": \"?0\", \"fuzziness\": 2 } } }")
    List<Movie> findByGenreFuzzy(String genre);

    @Query("{ \"match\": { \"language\": { \"query\": \"?0\", \"fuzziness\": 2 } } }")
    List<Movie> findByLanguageFuzzy(String language);

}
