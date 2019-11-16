package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SpecimenDto {
    private Long specimenId;
    private String status;
    private TitleDto titleDto;
    private List<Borrowings> borrowings;
}