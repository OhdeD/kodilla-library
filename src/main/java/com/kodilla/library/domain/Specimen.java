package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "SPECIMENS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Specimen {
    @Column(name = "specimen_id")
    @Id
    @GeneratedValue
    private Long specimenId;

    @Column(name = "title_id")
    private String titleId;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "title_id")
    private Title title;
}
