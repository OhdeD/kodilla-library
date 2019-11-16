package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "TITLES")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Title {
    @Id
    @GeneratedValue
    @Column(name = "title_id")
    @NotNull
    private Long titleId;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "year_of_publishing")
    private int published;

    @Builder.Default
    @OneToMany(targetEntity = Specimen.class, mappedBy = "title", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Specimen> specimenList = new ArrayList<>();
}
