package org.ajani2001.back.point;

import org.ajani2001.back.RCRUDRepository;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PointRepository extends RCRUDRepository<Point, PointRepresentation, Long> {
    @Override
    @Query("SELECT point.*, subq_reader.reader_count, " +
            "subq_debtor.debtor_count, subq_debt.debt_amount " +
            "FROM point JOIN " +
            "(SELECT point.id AS point_id, COUNT(reader.id) AS reader_count " +
            "FROM point LEFT JOIN borrowing ON point.id = borrowing.point_id " +
            "LEFT JOIN reader ON borrowing.reader_id = reader.id " +
            "GROUP BY point.id) AS subq_reader " +
            "ON point.id = subq_reader.point_id JOIN " +
            "(SELECT point.id AS point_id, COUNT(reader.id) AS debtor_count " +
            "FROM point LEFT JOIN borrowing ON point.id = borrowing.point_id " +
            "LEFT JOIN reader ON borrowing.reader_id = reader.id " +
            "WHERE borrowing.id IS NULL OR borrowing.end_date IS NULL AND borrowing.until_date < CURRENT_DATE " +
            "GROUP BY point.id) AS subq_debtor " +
            "ON point.id = subq_debtor.point_id JOIN " +
            "(SELECT point.id AS point_id, COALESCE(SUM(edition.cost), 0) AS debt_amount " +
            "FROM point LEFT JOIN borrowing ON point.id = borrowing.point_id " +
            "LEFT JOIN book ON borrowing.book_id = book.id " +
            "LEFT JOIN edition ON book.edition_id = edition.id " +
            "WHERE borrowing.id IS NULL OR borrowing.until_date < CURRENT_DATE " +
            "GROUP BY point.id) AS subq_debt " +
            "ON point.id = subq_debt.point_id")
    Iterable<PointRepresentation> getRepresentationAll();

    @Override
    @Query("SELECT point.*, subq_reader.reader_count, " +
            "subq_debtor.debtor_count, subq_debt.debt_amount " +
            "FROM point JOIN " +
            "(SELECT point.id AS point_id, COUNT(reader.id) AS reader_count " +
            "FROM point LEFT JOIN borrowing ON point.id = borrowing.point_id " +
            "LEFT JOIN reader ON borrowing.reader_id = reader.id " +
            "GROUP BY point.id) AS subq_reader " +
            "ON point.id = subq_reader.point_id JOIN " +
            "(SELECT point.id AS point_id, COUNT(reader.id) AS debtor_count " +
            "FROM point LEFT JOIN borrowing ON point.id = borrowing.point_id " +
            "LEFT JOIN reader ON borrowing.reader_id = reader.id " +
            "WHERE borrowing.id IS NULL OR borrowing.end_date IS NULL AND borrowing.until_date < CURRENT_DATE " +
            "GROUP BY point.id) AS subq_debtor " +
            "ON point.id = subq_debtor.point_id JOIN " +
            "(SELECT point.id AS point_id, COALESCE(SUM(edition.cost), 0) AS debt_amount " +
            "FROM point LEFT JOIN borrowing ON point.id = borrowing.point_id " +
            "LEFT JOIN book ON borrowing.book_id = book.id " +
            "LEFT JOIN edition ON book.edition_id = edition.id " +
            "WHERE borrowing.id IS NULL OR borrowing.until_date < CURRENT_DATE " +
            "GROUP BY point.id) AS subq_debt " +
            "ON point.id = subq_debt.point_id " +
            "WHERE point.id = :id")
    Optional<PointRepresentation> getRepresentationById(Long id);
}
