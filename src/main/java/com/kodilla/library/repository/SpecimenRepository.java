package com.kodilla.library.repository;

import com.kodilla.library.domain.Specimen;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface SpecimenRepository extends CrudRepository<Specimen, Long> {
    @Override
    Specimen save(Specimen specimen);


    List<Specimen> findAllSpecimenIdByTitle_TitleId(Long id);
}
