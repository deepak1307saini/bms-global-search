package com.example.bmsglobalsearch.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Data
@Document(indexName = "actors")
@NoArgsConstructor
@Builder
public class Actor {
    @Field(type = FieldType.Text)
    private String name;

    public Actor(String name) {
        this.name = name;
    }
}


