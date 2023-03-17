
package com.example.bmsglobalsearch.entity;

import com.example.bmsglobalsearch.enums.CertificateType;
import com.example.bmsglobalsearch.enums.Genre;
import com.example.bmsglobalsearch.enums.Language;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Document(indexName = "movies")
@NoArgsConstructor
@Builder
@AllArgsConstructor


public class Movie {


    @Id
    @Field(type = FieldType.Long)
    private Long id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String description;


    @Field(type = FieldType.Keyword)
    private Language language;

    @Field(type = FieldType.Date)
    private Date releaseDate;

    @Field(type = FieldType.Keyword)
    private CertificateType certificateType;

    @Field(type = FieldType.Keyword)
    private Genre genre;

    private List<Actor> actors = new ArrayList<>();

}