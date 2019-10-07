package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SPECIMENS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Specimen {
    @Column(name = "specimen_id")
    @Id
    @GeneratedValue
    @NotNull
    private Long specimenId;

//    @Column(name = "title_id")
//    @NotNull
//    private Long titleId;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "title_id")
    private Title title;

    public Specimen(String status, Title title) {
        this.status = status;
        this.title = title;
    }
}
