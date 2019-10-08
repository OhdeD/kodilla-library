package com.kodilla.library.mapper;
import com.kodilla.library.domain.*;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public Reader mapToReader(ReaderDto readerDto) {
        return new Reader(readerDto.getReaderId(),readerDto.getName(),readerDto.getSurname(),readerDto.getJoinDate(),readerDto.getBorrowings());
    }

    public ReaderDto mapToReaderDto(Reader reader){
        return new ReaderDto(reader.getReaderId(), reader.getName(), reader.getSurname(),reader.getJoinDate(),reader.getBorrowings());
    }

    public Title mapToTitle(TitleDto titleDto){
        return new Title(titleDto.getTitleId(), titleDto.getTitle(), titleDto.getAuthor(),titleDto.getPublished(), titleDto.getSpecimenList());
    }

    public TitleDto mapToTitleDto(Title title){
        return new TitleDto(title.getTitleId(), title.getTitle(),title.getAuthor(), title.getPublished(),title.getSpecimenList());
    }

    public Specimen mapToSpecimens (SpecimenDto specimenDto){
        return new Specimen(specimenDto.getSpecimenId(), specimenDto.getStatus(), specimenDto.getTitle(),specimenDto.getBorrowings());
    }
    public SpecimenDto mapToSpecimensDto (Specimen specimen){
        return new SpecimenDto( specimen.getSpecimenId(), specimen.getStatus(), specimen.getTitle(), specimen.getBorrowings());
    }

}
