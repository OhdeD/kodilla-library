package com.kodilla.library.service;

//import com.kodilla.library.domain.Reader;
import com.kodilla.library.domain.Reader;
import com.kodilla.library.domain.Specimen;
import com.kodilla.library.domain.Title;
//import com.kodilla.library.repository.ReadersRepository;
import com.kodilla.library.repository.ReadersRepository;
import com.kodilla.library.repository.SpecimenRepository;
import com.kodilla.library.repository.TitlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DbService {
    @Autowired
    private ReadersRepository repository;
    @Autowired
    private TitlesRepository titlesRepository;
    @Autowired
    private SpecimenRepository specimenRepository;

    public Reader addReader(Reader reader) {
        return repository.save(reader);
    }

    public Title addTitle (Title title){
        return titlesRepository.save(title);
    }

    public Optional<Title> findTitleById(Long id){return  titlesRepository.findById(id); }

    public void deleteTitleById(Long id){titlesRepository.deleteById(id);}

    public Specimen addSpecimen(Specimen specimen) {return  specimenRepository.save(specimen);}
}
