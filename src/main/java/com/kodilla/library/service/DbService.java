package com.kodilla.library.service;

import com.kodilla.library.domain.Reader;
import com.kodilla.library.domain.Title;
import com.kodilla.library.repository.ReadersRepository;
import com.kodilla.library.repository.TitlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbService {
    @Autowired
    private ReadersRepository repository;
    @Autowired
    private TitlesRepository titlesRepository;

    public Reader addReader(Reader reader) {
        return repository.save(reader);
    }

    public Title addTitle (Title title){
        return titlesRepository.save(title);
    }
}
