package com.kodilla.library.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;



@Entity
@Table(name = "BORROWINGS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Borrowings implements Serializable {
    @Id
    @GeneratedValue
    private long lp;

    @Column(name = "borrowed")
    @NotNull
    private LocalDate borrowingDate;

    @Column(name = "returned")
    private LocalDate returned;


    @ManyToOne
    @JoinColumn(name = "specimen_id")
    private Specimen specimen;

    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;
}
