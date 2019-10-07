package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SpecimenDto {
    private Long specimenId;
    private String titleId;
    private String status;
    private Title title;
}