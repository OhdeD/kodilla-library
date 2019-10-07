package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "TITLES")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Title {
    @Id
    @GeneratedValue
    @Column(name = "title_id")
    private Long titleId;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "year_of_publishing")
    private Date published;

    @OneToMany(targetEntity = Specimen.class, mappedBy = "title", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Specimen> specimenList = new ArrayList<>();
}
