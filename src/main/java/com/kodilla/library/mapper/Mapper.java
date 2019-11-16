package com.kodilla.library.mapper;

import com.kodilla.library.domain.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {

    public Reader mapToReader(ReaderDto readerDto) {
        return Reader.builder()
                .name(readerDto.getName())
                .surname(readerDto.getSurname())
                .joinDate(readerDto.getJoinDate()).build();
    }

    public Title mapToTitle(TitleDto titleDto) {
        List<Specimen> specimensList = new ArrayList<>();
        if (specimensList.size() != 0) {
            for (SpecimenDto s : titleDto.getSpecimenList()) {
                Specimen specimen = mapToSpecimens(s);
                specimensList.add(specimen);
            }
        }
        return Title.builder()
                .titleId(titleDto.getTitleId())
                .title(titleDto.getTitle())
                .author(titleDto.getAuthor())
                .published(titleDto.getPublished())
                .specimenList(specimensList).build();
    }

    public Specimen mapToSpecimens(SpecimenDto specimenDto) {
        return Specimen.builder()
                .specimenId(specimenDto.getSpecimenId())
                .status(specimenDto.getStatus())
                .title(Title.builder()
                        .titleId(specimenDto.getTitleDto().getTitleId()).build())
                .build();
    }

    public SpecimenDto mapToSpecimensDto(Specimen specimen) {
        return SpecimenDto.builder()
                .specimenId(specimen.getSpecimenId())
                .status(specimen.getStatus())
                .titleDto(TitleDto.builder()
                        .titleId(specimen.getTitle().getTitleId())
                        .title(specimen.getTitle().getTitle())
                        .author(specimen.getTitle().getAuthor())
                        .published(specimen.getTitle().getPublished()).build())
                .borrowings(specimen.getBorrowings()).build();
    }

    public Borrowings mapToBorrowings(BorrowingsDto borrowingsDto) {
        return Borrowings.builder()
                .borrowingDate(borrowingsDto.getBorrowingDate())
                .returned(borrowingsDto.getReturned())
                .specimen(Specimen.builder()
                        .specimenId(borrowingsDto.getSpecimenDto().getSpecimenId()).build())
                .reader(Reader.builder()
                        .readerId(borrowingsDto.getReaderDto().getReaderId()).build())
                .build();
    }

    public List<SpecimenDto> mapToSpecimensDtoList(List<Specimen> list) {
        return list.stream()
                .map(a -> SpecimenDto.builder()
                        .specimenId(a.getSpecimenId())
                        .status(a.getStatus())
                        .titleDto(TitleDto.builder()
                                .titleId(a.getTitle().getTitleId())
                                .title(a.getTitle().getTitle())
                                .author(a.getTitle().getAuthor())
                                .published(a.getTitle().getPublished()).build())
                        .borrowings(a.getBorrowings()).build())
                .collect(Collectors.toList());
    }
}
