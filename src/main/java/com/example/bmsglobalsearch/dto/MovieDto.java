package com.example.bmsglobalsearch.dto;


import com.example.bmsglobalsearch.enums.CertificateType;
import com.example.bmsglobalsearch.enums.Genre;
import com.example.bmsglobalsearch.enums.Language;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor

public class MovieDto {


    private long id;

    private String name;

    private String description;


    private Language language;


    private CertificateType certificateType;

    private Date releaseDate;


    private Genre genre;

    private List<String> actorNames;

}
