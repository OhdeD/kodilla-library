package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BorrowingsDto {
    private long lp;
    private LocalDate borrowingDate;
    private LocalDate returned;
    private Specimen specimen;
    private Reader reader;

    public BorrowingsDto(LocalDate borrowingDate, LocalDate returned, Specimen specimen, Reader reader) {
        this.borrowingDate = borrowingDate;
        this.returned = returned;
        this.specimen = specimen;
        this.reader = reader;
    }
}
