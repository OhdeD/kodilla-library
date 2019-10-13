package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReaderDto {
    private Long readerId;
    private String name;
    private String surname;
    private LocalDate joinDate;
    private List<Borrowings>borrowings;

}
