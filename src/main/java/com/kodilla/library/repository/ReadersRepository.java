package com.kodilla.library.repository;

import com.kodilla.library.domain.Reader;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface ReadersRepository extends CrudRepository <Reader, Long> {
    @Override
    Reader save(Reader reader);

    @Override
    void deleteById(Long id);
}
