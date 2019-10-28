package com.kodilla.library.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TitleDto {
    private Long titleId;
    private String title;
    private String author;
    private int published;
    private List<SpecimenDto> specimenList;

    public TitleDto(String title, String author, int published) {
        this.title = title;
        this.author = author;
        this.published = published;
    }

    public TitleDto(Long titleId, String title, String author, int published) {
        this.titleId = titleId;
        this.title = title;
        this.author = author;
        this.published = published;
    }
}