package com.kodilla.library.repository;
import com.kodilla.library.domain.Borrowings;
import com.kodilla.library.domain.Specimen;
import org.springframework.data.repository.CrudRepository;


import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface BorrowingRepository extends CrudRepository<Borrowings, Long> {
    @Override
    Borrowings save (Borrowings borrowings);

    List<Borrowings> findAllByReturnedNull();

}
