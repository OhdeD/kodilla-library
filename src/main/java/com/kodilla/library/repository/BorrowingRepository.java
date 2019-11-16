package com.kodilla.library.repository;
import com.kodilla.library.domain.Borrowings;
import org.springframework.data.jpa.repository.Modifying;
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

    @Modifying
    @Query(value = " UPDATE BORROWINGS" +
            " SET returned = now() " +
            " WHERE (returned is null and reader_id = :READERID and specimen_id = :SPECIMENID );",
            nativeQuery = true)
    void returnTitleBySpecimenIdAndReaderId(@Param("READERID") Long readerId, @Param("SPECIMENID") Long specimenId);

}
