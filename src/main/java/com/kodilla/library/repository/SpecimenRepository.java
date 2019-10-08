package com.kodilla.library.repository;

import com.kodilla.library.domain.Specimen;
import org.springframework.data.repository.CrudRepository;


public interface SpecimenRepository extends CrudRepository<Specimen, Long> {
    @Override
    Specimen save(Specimen specimen);


    void deleteAllBySpecimenId(Long id);

}
