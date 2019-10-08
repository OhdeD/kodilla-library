package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Date;
@AllArgsConstructor
@Getter
public class BorrowingsDto {
    private int lp;
    private Date borrowingDate;
    private Date returned;
    private Specimen specimen;
    private Reader reader;


}
