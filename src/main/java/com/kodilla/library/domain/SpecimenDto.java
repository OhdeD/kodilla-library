package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SpecimenDto {
    private Long specimenId;
    private String status;
    private Title title;
    private List<Borrowings>borrowings;

    public SpecimenDto(String status, Title title) {
        this.status = status;
        this.title = title;
    }
}