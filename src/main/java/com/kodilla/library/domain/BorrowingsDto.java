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
    private SpecimenDto specimenDto;
    private ReaderDto readerDto;

    public BorrowingsDto(LocalDate borrowingDate, LocalDate returned, SpecimenDto specimenDto, ReaderDto readerDto) {
        this.borrowingDate = borrowingDate;
        this.returned = returned;
        this.specimenDto = specimenDto;
        this.readerDto = readerDto;
    }
}
