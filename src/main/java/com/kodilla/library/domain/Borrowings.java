package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;



@NamedNativeQuery(
        name = "Borrowings.returnTitleBySpecimenIdAndReaderId",
        query =" UPDATE BORROWINGS" +
               " SET returned = now() " +
               " WHERE (returned is null and reader_id = :READERID and specimen_id = :SPECIMENID);",
        resultClass = Borrowings.class
)
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
    private LocalDate borrowingDate;

    @Column(name = "returned")
    private LocalDate returned;


    @ManyToOne
    @JoinColumn(name = "specimen_id")
    private Specimen specimen;

    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;

    public Borrowings(LocalDate borrowingDate, LocalDate returned, Specimen specimen, Reader reader) {
        this.borrowingDate = borrowingDate;
        this.returned = returned;
        this.specimen = specimen;
        this.reader = reader;
    }
}
