package com.kodilla.library.repository;
import com.kodilla.library.domain.Borrowings;
import com.kodilla.library.domain.Specimen;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface BorrowingRepository extends CrudRepository<Borrowings, Long> {
    @Override
    Borrowings save (Borrowings borrowings);

    List<Borrowings> findAllByReturnedNull();

    @Query(nativeQuery = true)
    Borrowings returnTitleBySpecimenIdAndReaderId(@Param("READERID") Long readerId, @Param("SPECIMENID") Long specimenId);

}
