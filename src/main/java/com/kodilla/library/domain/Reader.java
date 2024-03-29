package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "READER")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reader {
    @Id
    @GeneratedValue
    @Column(name = "reader_id")
    @NotNull
    private Long readerId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "join_date")
    private LocalDate joinDate;

    @ManyToMany(targetEntity = Borrowings.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "reader")
    private List<Borrowings> borrowings;
}
