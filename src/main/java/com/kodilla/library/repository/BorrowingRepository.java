package com.kodilla.library.repository;
import com.kodilla.library.domain.Borrowings;
import org.springframework.data.repository.CrudRepository;
import javax.transaction.Transactional;

@Transactional
public interface BorrowingRepository extends CrudRepository<Borrowings, Long> {
    @Override
    Borrowings save (Borrowings borrowings);
}
