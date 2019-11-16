package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ReaderDto {
    private Long readerId;
    private String name;
    private String surname;
    private LocalDate joinDate;
    private List<BorrowingsDto> borrowings;
}
