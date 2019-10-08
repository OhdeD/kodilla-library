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

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KodillaLibraryTestSuite {
    @Autowired
    TitlesRepository titlesRepository;
    @Autowired
    DbService dbService;

    @Test
    public void testAddNewReader(){
        //Given
        Reader reader = new Reader("Name", "Surname", new Date(2018,04,3));

        //When
        dbService.addReader(reader);
        //Then
        long id = reader.getReaderId();
        Assert.assertNotEquals(0, id);

        //CleanUp
        dbService.deleteReaderById(id);

    }

    @Test
    public void testAddingTitle(){
        //Given
        Title title1 = new Title("tytul1", "autor1", 2005);

        //When
        dbService.addTitle(title1);

        //Then
        long id = title1.getTitleId();
        Assert.assertNotEquals(0,id);

        //CleanUp
        dbService.deleteTitleById(id);
    }

    @Test
    public void testAddingSpecimen(){
        //Given
        Title title2 = new Title("tytul1", "autor1", 2005);
        Specimen specimen2 = new Specimen( "new",title2);

        //When
        dbService.addTitle(title2);
        dbService.addSpecimen(specimen2);

        //Then
        long id = title2.getTitleId();
        long idSpecimen = specimen2.getSpecimenId();
        long titleIdFromSpecimen = specimen2.getTitle().getTitleId();

        Assert.assertNotEquals(0,idSpecimen);
        Assert.assertEquals(titleIdFromSpecimen,id);

        //CleanUp
        dbService.deleteTitleById(id);
        dbService.deleteAllSpecimenById(idSpecimen);
    }

    @Test
    public void testOfBorrowings(){
        //Given
        Reader reader = new Reader("Adam", "Nowak", new Date());
        Title title = new Title("Tytuł", "Autor", 03);
        Specimen specimen = new Specimen("new", title);
        Specimen specimen2 = new Specimen("old", title);
        Borrowings borrowings = new Borrowings(new Date(),null, specimen2,reader);

        //When
        dbService.addReader(reader);
        dbService.addTitle(title);
        dbService.addSpecimen(specimen);
        dbService.addSpecimen(specimen2);
        dbService.saveBorrowing(borrowings);
        long idOfSpecimen = specimen2.getSpecimenId();
        long idOfReader = borrowings.getReader().getReaderId();

        borrowings.setReturned(new Date());
        dbService.saveBorrowing(borrowings);
        //Then
        Assert.assertNotEquals(0,idOfReader);
        Assert.assertNotEquals(0,idOfSpecimen);

        //CleanUp

    }
}
