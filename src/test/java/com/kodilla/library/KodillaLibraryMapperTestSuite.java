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
        ReaderDto readerDto = ReaderDto.builder().name("name").surname("surmane").joinDate(LocalDate.of(2019, 10, 5)).build();

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
        TitleDto titleDto = TitleDto.builder().title("tytuł").author("autor").published(2015).build();

        System.out.println(" tytuł: " + titleDto.getTitle());
        //When
        Title title = mapper.mapToTitle(titleDto);
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
        Title title = Title.builder().title("tytuł").author("autor").published(2015).build();
        Specimen specimen = Specimen.builder().status("NEW").title(title).build();

        //When
        SpecimenDto specimenDto = mapper.mapToSpecimensDto(specimen);
        String status = specimenDto.getStatus();
        String tytuł = specimenDto.getTitleDto().getTitle();
        String author = specimenDto.getTitleDto().getAuthor();

        //Then
        Assert.assertEquals(author, "author");
        Assert.assertEquals(tytuł, "title");
        Assert.assertEquals(status, "new");
    }

    @Test
    public void testMapToSpecimen() {
        //Given
        TitleDto title = TitleDto.builder().titleId(7L).title("T").author("A").published(2011).build();

        SpecimenDto specimenDto = SpecimenDto.builder().specimenId(1L).status("new").titleDto(title).borrowings(new ArrayList<>()).build();

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
        SpecimenDto specimen = SpecimenDto.builder().specimenId(4L).build();
        ReaderDto reader = ReaderDto.builder().readerId(5L).name("anna").surname("nowak").joinDate(LocalDate.of(2010, 05, 02)).borrowings(new ArrayList<>()).build();
        BorrowingsDto borrowingsDto = BorrowingsDto.builder().borrowingDate(LocalDate.of(2019, 10, 25)).returned( LocalDate.of(2019, 10, 30)).specimenDto(specimen).readerDto(reader).build();

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
        Title title = Title.builder().title("Tytuł").author("Author").published(03).build();
        Specimen specimen = Specimen.builder().status("NEW").title(title).build();
        Title title2 = Title.builder().title("Tytuł2").author("Author2").published(03).build();
        Specimen specimen2 = Specimen.builder().status("NEW2").title(title).build();

        List<Specimen> list = new ArrayList<>();
        list.add(specimen);
        list.add(specimen2);
        //When
        List<SpecimenDto> specimenDtos = mapper.mapToSpecimensDtoList(list);

        String t1 = specimenDtos.get(0).getTitleDto().getTitle();
        String t2 = specimenDtos.get(1).getTitleDto().getTitle();
        String status1 = specimenDtos.get(0).getStatus();
        String status2 = specimenDtos.get(1).getStatus();
        //Then
        Assert.assertEquals(t1, "title");
        Assert.assertEquals(t2, "title2");
        Assert.assertEquals(status1, "new");
        Assert.assertEquals(status2, "new");

    }


}
