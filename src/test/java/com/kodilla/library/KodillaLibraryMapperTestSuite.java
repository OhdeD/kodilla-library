package com.kodilla.library;

import com.kodilla.library.domain.*;
import com.kodilla.library.mapper.Mapper;
import org.junit.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class KodillaLibraryMapperTestSuite {
    Mapper mapper = new Mapper();

    @Test
    public void testMapToReader() {
        //Given
        ReaderDto readerDto = new ReaderDto("name", "surname", LocalDate.of(2019, 10, 5));

        //When
        Reader reader = mapper.mapToReader(readerDto);
        String name = reader.getName();
        String surname = reader.getSurname();
        LocalDate join = reader.getJoinDate();

        //Then
        Assert.assertEquals(name, "name");
        Assert.assertEquals(surname, "surname");
        Assert.assertEquals(join, LocalDate.of(2019, 10, 5));

    }

    @Test
    public void testMapToTitle() {
        //Given
        TitleDto titleDto = new TitleDto("Tytuł", "Autor", 2015);

        System.out.println(" tytuł: " + titleDto.getTitle());
        //When
        Title title = mapper.mapToTitle(new TitleDto("Tytuł", "Autor", 2015));
        String t = title.getTitle();
        String a = title.getAuthor();
        int p = title.getPublished();
        System.out.println(t);

        //Then
        Assert.assertEquals(t, "Tytuł");
        Assert.assertEquals(a, "Autor");
        Assert.assertEquals(p, 2015);
    }

    @Test
    public void testMapToSpecimenDto() {
        //Given
        Title title = new Title("title", "author", 2015);
        Specimen specimen = new Specimen("new", title);

        //When
        SpecimenDto specimenDto = mapper.mapToSpecimensDto(specimen);
        String status = specimenDto.getStatus();
        String tytuł = specimenDto.getTitle().getTitle();
        String author = specimenDto.getTitle().getAuthor();

        //Then
        Assert.assertEquals(author, "author");
        Assert.assertEquals(tytuł, "title");
        Assert.assertEquals(status, "new");
    }

    @Test
    public void testMapToSpecimen() {
        //Given
        Title title = new Title(7L, "T", "A", 2011);
        SpecimenDto specimenDto = new SpecimenDto(1L, "new", title, new ArrayList<>());

        //When
        Specimen specimen = mapper.mapToSpecimens(specimenDto);

        Long id = specimen.getTitle().getTitleId();
        String status = specimen.getStatus();
        List<Borrowings> borrowings = specimen.getBorrowings();

        //Then
        Assert.assertNotEquals(null, id);
        Assert.assertEquals(status, "new");
        Assert.assertEquals(borrowings.size(), 0);
    }

    @Test
    public void testMapToBorrowings() {
        //Given
        Specimen specimen = new Specimen(4L);
        Reader reader = new Reader(5L, "Ania", "Nowak", LocalDate.of(2010, 05, 02), new ArrayList<>());
        BorrowingsDto borrowingsDto = new BorrowingsDto(LocalDate.of(2019, 10, 25), LocalDate.of(2019, 10, 30), specimen, reader);

        //When
        Borrowings borrowings = mapper.mapToBorrowings(borrowingsDto);

        LocalDate borrow = borrowings.getBorrowingDate();
        LocalDate returned = borrowings.getReturned();
        Long specimenId = borrowings.getSpecimen().getSpecimenId();
        Long readerId = borrowings.getReader().getReaderId();

        //Then
        Assert.assertEquals(borrow, LocalDate.of(2019, 10, 25));
        Assert.assertEquals(returned, LocalDate.of(2019, 10, 30));
        Assert.assertNotEquals(null, specimenId);
        Assert.assertNotEquals(null, readerId);
    }

    @Test
    public void testMapToSpecimensDtoList() {
        //Given
        Title title = new Title("title", "author", 2015);
        Specimen specimen = new Specimen("new", title);
        Title title2 = new Title("title2", "author2", 2025);
        Specimen specimen2 = new Specimen("new", title2);

        List<Specimen> list = new ArrayList<>();
        list.add(specimen);
        list.add(specimen2);
        //When
        List<SpecimenDto> specimenDtos = mapper.mapToSpecimensDtoList(list);

        String t1 = specimenDtos.get(0).getTitle().getTitle();
        String t2 = specimenDtos.get(1).getTitle().getTitle();
        String status1 = specimenDtos.get(0).getStatus();
        String status2 = specimenDtos.get(1).getStatus();
        //Then
        Assert.assertEquals(t1, "title");
        Assert.assertEquals(t2, "title2");
        Assert.assertEquals(status1, "new");
        Assert.assertEquals(status2, "new");

    }


}
