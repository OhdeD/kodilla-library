package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SpecimenDto {
    private Long specimenId;
    private String status;
    private TitleDto titleDto;
    private List<Borrowings> borrowings;

    public SpecimenDto(String status, TitleDto titleDto) {
        this.status = status;
        this.titleDto = titleDto;
    }

}