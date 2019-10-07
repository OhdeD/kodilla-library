package com.kodilla.library.repository;

import com.kodilla.library.domain.Title;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TitlesRepository extends CrudRepository <Title, Long> {
    @Override
    Title save(Title title);

    @Override
    Optional<Title> findById(Long id);
}
