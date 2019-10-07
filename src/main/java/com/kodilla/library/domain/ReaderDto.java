package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class ReaderDto {
    private Long readerId;
    private String name;
    private String surname;
    private Date joinDate;
}
