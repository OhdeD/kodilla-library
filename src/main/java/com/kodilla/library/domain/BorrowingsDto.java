package com.kodilla.library.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BorrowingsDto {
    private long lp;
    private LocalDate borrowingDate;
    private LocalDate returned;
    private SpecimenDto specimenDto;
    private ReaderDto readerDto;
}
