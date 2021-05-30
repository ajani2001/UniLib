package org.ajani2001.back.borrowing.order;

import org.ajani2001.back.RCRUDRepository;
import org.ajani2001.back.borrowing.BorrowingRepresentation;
import org.springframework.data.jdbc.repository.query.Query;

import java.util.Optional;

public interface OrderRepository extends RCRUDRepository<Order, OrderRepresentation, Long> {
    @Override
    @Query("SELECT borrowing.id, reader.first_name AS reader_first_name, " +
            "reader.last_name AS reader_last_name, edition.title AS title, " +
            "point.name AS point, borrowing.begin_date, borrowing.end_date, " +
            "borrowing.until_date, order_table.supply_date " +
            "FROM order_table JOIN borrowing ON order_table.borrowing_id = borrowing.id " +
            "JOIN reader ON borrowing.reader_id = reader.id " +
            "JOIN book ON borrowing.book_id = book.id " +
            "JOIN edition ON book.edition_id = edition.id " +
            "JOIN point ON borrowing.point_id = point.id")
    Iterable<OrderRepresentation> getRepresentationAll();

    @Override
    @Query("SELECT borrowing.id, reader.first_name AS reader_first_name, " +
            "reader.last_name AS reader_last_name, edition.title AS title, " +
            "point.name AS point, borrowing.begin_date, borrowing.end_date, " +
            "borrowing.until_date, order_table.supply_date " +
            "FROM order_table JOIN borrowing ON order_table.borrowing_id = borrowing.id " +
            "JOIN reader ON borrowing.reader_id = reader.id " +
            "JOIN book ON borrowing.book_id = book.id " +
            "JOIN edition ON book.edition_id = edition.id " +
            "JOIN point ON borrowing.point_id = point.id " +
            "WHERE order_table.borrowing_id = :id")
    Optional<OrderRepresentation> getRepresentationById(Long id);
}
