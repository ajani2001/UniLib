package org.ajani2001.back.borrowing;

import org.ajani2001.back.RCRUDRepository;
import org.springframework.data.jdbc.repository.query.Query;

import java.util.Optional;

public interface BorrowingRepository extends RCRUDRepository<Borrowing, BorrowingRepresentation, Long> {
    @Override
    @Query("SELECT borrowing.id, reader.first_name AS reader_first_name, " +
            "reader.last_name AS reader_last_name, edition.title AS title, " +
            "point.name AS point, borrowing.begin_date, borrowing.end_date, borrowing.until_date " +
            "FROM borrowing JOIN reader ON borrowing.reader_id = reader.id " +
            "JOIN book ON borrowing.book_id = book.id " +
            "JOIN edition ON book.edition_id = edition.id " +
            "JOIN point ON borrowing.point_id = point.id")
    Iterable<BorrowingRepresentation> getRepresentationAll();

    @Override
    @Query("SELECT borrowing.id, reader.first_name AS reader_first_name, " +
            "reader.last_name AS reader_last_name, edition.title AS title, " +
            "point.name AS point, borrowing.begin_date, borrowing.end_date, borrowing.until_date " +
            "FROM borrowing JOIN reader ON borrowing.reader_id = reader.id " +
            "JOIN book ON borrowing.book_id = book.id " +
            "JOIN edition ON book.edition_id = edition.id " +
            "JOIN point ON borrowing.point_id = point.id " +
            "WHERE borrowing.id = :id")
    Optional<BorrowingRepresentation> getRepresentationById(Long id);
}
