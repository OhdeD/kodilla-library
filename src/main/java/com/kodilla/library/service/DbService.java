package com.kodilla.library.service;

//import com.kodilla.library.domain.Reader;

import com.kodilla.library.domain.Borrowings;
import com.kodilla.library.domain.Reader;
import com.kodilla.library.domain.Specimen;
import com.kodilla.library.domain.Title;
//import com.kodilla.library.repository.ReadersRepository;
import com.kodilla.library.repository.BorrowingRepository;
import com.kodilla.library.repository.ReadersRepository;
import com.kodilla.library.repository.SpecimenRepository;
import com.kodilla.library.repository.TitlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DbService {
    @Autowired
    private ReadersRepository repository;
    @Autowired
    private TitlesRepository titlesRepository;
    @Autowired
    private SpecimenRepository specimenRepository;
    @Autowired
    private BorrowingRepository borrowingRepository;

    public Reader addReader(Reader reader) {
        return repository.save(reader);
    }

    public void deleteReaderById(Long id) {
        repository.deleteById(id);
    }

    public Title addTitle(Title title) {
        return titlesRepository.save(title);
    }

    public Optional<Title> findTitleById(Long id) {
        return titlesRepository.findById(id);
    }

    public void deleteTitleById(Long id) {
        titlesRepository.deleteById(id);
    }

    public Specimen addSpecimen(Specimen specimen) {
        return specimenRepository.save(specimen);
    }

    public void deleteSpecimenById(Long id) {
        specimenRepository.deleteById(id);
    }

    public Borrowings saveBorrowing(Borrowings borrowings) {
        return borrowingRepository.save(borrowings);
    }

    public List<Long> showAllSpecimensIdOfOneTitle(Long titleId) {
        List<Specimen> listOfSpecimens = specimenRepository.findAllSpecimenIdByTitle_TitleId(titleId);
        List<Long> idsOfCopies = new ArrayList<>();
        for (Specimen s : listOfSpecimens) {
            idsOfCopies.add(s.getSpecimenId());
        }
        return idsOfCopies;
    }


    public List<Long> showAllAvailableSpecimensIdOfOneTitle (Long titleId) {
        List<Long> specimensId = showAllSpecimensIdOfOneTitle(titleId);
        List<Borrowings> listOfBorrowed = borrowingRepository.findAllByReturnedNull();
        List<Long> toRemove = new ArrayList<>();
        for (Long availableId : specimensId) {
            for (Borrowings b : listOfBorrowed) {
                if (b.getSpecimen().getSpecimenId().equals(availableId)) {
                    toRemove.add(availableId);
                }
            }
        }
        specimensId.removeAll(toRemove);
        return specimensId;
    }

}
