package com.kodilla.library.mapper;

import com.kodilla.library.domain.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {

    public Reader mapToReaderBasic(ReaderDto readerDto) {
        return new Reader(readerDto.getName(), readerDto.getSurname(), readerDto.getJoinDate());
    }

    public ReaderDto mapToReaderDto(Reader reader) {
        return new ReaderDto(reader.getReaderId(), reader.getName(), reader.getSurname(), reader.getJoinDate(), reader.getBorrowings());
    }

    public Title mapToTitle(TitleDto titleDto) {
        return new Title(titleDto.getTitleId(), titleDto.getTitle(), titleDto.getAuthor(), titleDto.getPublished(), titleDto.getSpecimenList());
    }

    public TitleDto mapToTitleDto(Title title) {
        return new TitleDto(title.getTitleId(), title.getTitle(), title.getAuthor(), title.getPublished(), title.getSpecimenList());
    }

    public Specimen mapToSpecimens(SpecimenDto specimenDto) {
        return new Specimen(specimenDto.getSpecimenId(), specimenDto.getStatus(), specimenDto.getTitle(), specimenDto.getBorrowings());
    }

    public SpecimenDto mapToSpecimensDto(Specimen specimen) {
        return new SpecimenDto(specimen.getSpecimenId(), specimen.getStatus(), specimen.getTitle(), specimen.getBorrowings());
    }

    public Borrowings mapToBorrowings(BorrowingsDto borrowingsDto) {
        return new Borrowings(borrowingsDto.getBorrowingDate(), borrowingsDto.getReturned(), borrowingsDto.getSpecimen(), borrowingsDto.getReader());
    }

    public BorrowingsDto mapToBorrowingsDto(Borrowings borrowings) {
        return new BorrowingsDto(borrowings.getBorrowingDate(), borrowings.getReturned(), borrowings.getSpecimen(), borrowings.getReader());
    }

    public List<SpecimenDto> mapToSpecimensDtoList(List<Specimen> list) {
        return list.stream()
                .map(a-> new SpecimenDto(a.getSpecimenId(),a.getStatus(),
                        new Title(a.getTitle().getTitleId(),a.getTitle().getTitle(),a.getTitle().getAuthor(), a.getTitle().getPublished(), new ArrayList<>()),
                        a.getBorrowings()))
                .collect(Collectors.toList());
    }
}
