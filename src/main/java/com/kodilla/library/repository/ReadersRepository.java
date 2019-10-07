package com.kodilla.library.repository;

import com.kodilla.library.domain.Reader;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface ReadersRepository extends CrudRepository <Reader, Long> {
    @Override
    Reader save(Reader reader);

//    @Override
//    Optional<Reader> findById(Long id);
//
//    @Override
//    void deleteById(Long id);
}
