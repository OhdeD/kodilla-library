package com.kodilla.library.repository;

import com.kodilla.library.domain.Title;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Transactional
public interface TitlesRepository extends CrudRepository <Title, Long> {
    @Override
    Title save(Title title);

    @Override
    Optional<Title> findById(Long id);


}
