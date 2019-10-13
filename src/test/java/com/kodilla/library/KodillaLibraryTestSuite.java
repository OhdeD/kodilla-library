package com.kodilla.library;

import com.kodilla.library.domain.Borrowings;
import com.kodilla.library.domain.Reader;
import com.kodilla.library.domain.Specimen;
import com.kodilla.library.domain.Title;
import com.kodilla.library.repository.TitlesRepository;
import com.kodilla.library.service.DbService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KodillaLibraryTestSuite {
    @Autowired
    TitlesRepository titlesRepository;
    @Autowired
    DbService dbService;

    @Test
    public void testAddNewReader() {
        //Given
        Reader reader = new Reader("Name", "Surname", LocalDate.of(2018, 10, 6));

        //When
        long id = dbService.addReader(reader).getReaderId();
        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        dbService.deleteReaderById(id);

    }

    @Test
    public void testAddingTitle() {
        //Given
        Title title1 = new Title("tytul1", "autor1", 2005);

        //When
        long id = dbService.addTitle(title1).getTitleId();

        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        dbService.deleteTitleById(id);
    }

    @Test
    public void testAddingSpecimen() {
        //Given
        Title title2 = new Title("tytul1", "autor1", 2005);
        Specimen specimen2 = new Specimen("new", title2);

        //When
        long id = dbService.addTitle(title2).getTitleId();
        long idSpecimen = dbService.addSpecimen(specimen2).getSpecimenId();

        //Then
        long titleIdFromSpecimen = specimen2.getTitle().getTitleId();

        Assert.assertNotEquals(0, idSpecimen);
        Assert.assertEquals(titleIdFromSpecimen, id);

        //CleanUp
        dbService.deleteTitleById(id);
    }


    @Test
    public void testOfGettingCopies() {
        //Given
        Reader reader = new Reader("Adam", "Nowak", LocalDate.of(2018, 5, 15));
        Title title = new Title("Tytuł", "Autor", 03);
        Specimen specimen = new Specimen("new", title);
        Specimen specimen2 = new Specimen("old", title);
        Borrowings borrowings = new Borrowings(LocalDate.of(2019, 10, 1), null, specimen2, reader);

        //When
        long idOfReader = dbService.addReader(reader).getReaderId();
        long idOfTitle = dbService.addTitle(title).getTitleId();
        long idOfAdditionaSpecimen = dbService.addSpecimen(specimen).getSpecimenId();
        long idOfSpecimen = dbService.addSpecimen(specimen2).getSpecimenId();
        dbService.saveBorrowing(borrowings);

        dbService.saveBorrowing(borrowings);
        System.out.println("wszystkie egzemplarze po id: " + dbService.getAllSpecimensIdOfOneTitle(idOfTitle));
        System.out.println("dostępne egzemplarze po id: " + dbService.getAllAvailableSpecimensIdOfOneTitle(idOfTitle));
        System.out.println("dostępne egzemplarze po obiektach egzemplarzy: " + dbService.getAvailableSpecimensOfOneTitle(idOfTitle));
        //Then
        Assert.assertNotEquals(0, idOfReader);
        Assert.assertNotEquals(0, idOfSpecimen);

        //CleanUp
        dbService.deleteTitleById(idOfTitle);
        dbService.deleteReaderById(idOfReader);
    }

    @Test
    public void testOfBorrowingTitle() {
        //Given
        Reader reader = new Reader("Adam", "Nowak", LocalDate.of(2018, 5, 15));
        Title title = new Title("Tytuł", "Autor", 03);
        Specimen specimen2 = new Specimen("old", title);
        Borrowings borrowings = new Borrowings(LocalDate.of(2019, 10, 1), null, specimen2, reader);

        //When
        dbService.addReader(reader);
        dbService.addTitle(title);
        dbService.addSpecimen(specimen2);
        Borrowings borrowingsSaved = dbService.saveBorrowing(borrowings);
        LocalDate borrowDate = borrowingsSaved.getBorrowingDate();
        //Then
        Assert.assertEquals(borrowings.getBorrowingDate(), borrowDate);
        //CleanUp
        dbService.deleteReaderById(reader.getReaderId());
    }

    @Test
    public void testOfReturning() {
        //Given
        Reader reader = new Reader("Adam", "Nowak", LocalDate.of(2018, 5, 15));
        Title title = new Title("Tytuł", "Autor", 03);
        Specimen specimen2 = new Specimen("old", title);
        Borrowings borrowings = new Borrowings(LocalDate.of(2019, 10, 1), null, specimen2, reader);

        //When
        long idOfReader = dbService.addReader(reader).getReaderId();
        long idOfTitle = dbService.addTitle(title).getTitleId();
        long idOfSpecimen = dbService.addSpecimen(specimen2).getSpecimenId();

        dbService.saveBorrowing(borrowings);
        borrowings.setReturned(LocalDate.now());
        LocalDate returned = dbService.saveBorrowing(borrowings).getReturned();
        LocalDate addedReturnDate = borrowings.getReturned();
        //Then
        Assert.assertNotEquals(0, idOfReader);
        Assert.assertNotEquals(0, idOfSpecimen);
        Assert.assertEquals(addedReturnDate, returned);

        //CleanUp
        dbService.deleteReaderById(idOfReader);
        dbService.deleteTitleById(idOfTitle);
    }


}
