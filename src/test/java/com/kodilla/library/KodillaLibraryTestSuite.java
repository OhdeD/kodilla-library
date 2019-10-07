package com.kodilla.library;

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

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KodillaLibraryTestSuite {
    @Autowired
    TitlesRepository titlesRepository;
    @Autowired
    DbService dbService;


    @Test
    public void testAddingTitle(){
        //Given
        Title title1 = new Title("tytul1", "autor1", 2005);
        Specimen specimen1 = new Specimen( "new",title1);

        //When
        dbService.addTitle(title1);
        dbService.addSpecimen(specimen1);

        //Then
        long id = title1.getTitleId();
        long idSpecimen = specimen1.getSpecimenId();
        long titleIdFromSpecimen = specimen1.getTitle().getTitleId();

        Assert.assertNotEquals(0,id);
        Assert.assertNotEquals(0,idSpecimen);
        Assert.assertEquals(titleIdFromSpecimen,id);


        //CleanUp


    }
}
