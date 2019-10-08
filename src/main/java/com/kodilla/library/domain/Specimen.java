package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

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

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "title_id")
    private Title title;

    @OneToMany(targetEntity = Borrowings.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "specimen")
    private List<Borrowings> borrowings;

    public Specimen(String status, Title title) {
        this.status = status;
        this.title = title;
    }
}
