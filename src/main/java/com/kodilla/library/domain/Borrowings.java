package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "BORROWINGS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Borrowings implements Serializable {
    @Id
    @GeneratedValue
    private long lp;

    @Column(name = "borrowed")
    @NotNull
    private Date borrowingDate;

    @Column(name = "returned")
    private Date returned;


    @ManyToOne
    @JoinColumn(name = "specimen_id")
    private Specimen specimen;

    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;

    public Borrowings(Date borrowingDate, Date returned, Specimen specimen, Reader reader) {
        this.borrowingDate = borrowingDate;
        this.returned = returned;
        this.specimen = specimen;
        this.reader = reader;
    }
}
