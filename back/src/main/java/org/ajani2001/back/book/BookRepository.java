package org.ajani2001.back.book;

import org.ajani2001.back.RCRUDRepository;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends RCRUDRepository<Book, BookRepresentation, Long> {

    @Override
    @Query("SELECT book.id, edition.title AS edition, author.name AS author, " +
            "publishing.name AS publishing, point.name AS point, " +
            "book.issue_date, book.acquisition_date, book.decommission_date " +
            "FROM book JOIN edition ON book.edition_id = edition.id " +
            "JOIN author ON edition.author_id = author.id " +
            "JOIN publishing ON edition.publishing_id = publishing.id " +
            "JOIN point ON book.point_id = point.id")
    Iterable<BookRepresentation> getRepresentationAll();

    @Override
    @Query("SELECT book.id, edition.title AS edition, author.name AS author, " +
            "publishing.name AS publishing, point.name AS point, " +
            "book.issue_date, book.acquisition_date, book.decommission_date " +
            "FROM book JOIN edition ON book.edition_id = edition.id " +
            "JOIN author ON edition.author_id = author.id " +
            "JOIN publishing ON edition.publishing_id = publishing.id " +
            "JOIN point ON book.point_id = point.id " +
            "WHERE book.id = :id")
    Optional<BookRepresentation> getRepresentationById(Long id);

    @Query("SELECT book.id, edition.title AS edition, author.name AS author, " +
            "publishing.name AS publishing, point.name AS point, " +
            "book.issue_date, book.acquisition_date, book.decommission_date " +
            "FROM book JOIN edition ON book.edition_id = edition.id " +
            "JOIN author ON edition.author_id = author.id " +
            "JOIN publishing ON edition.publishing_id = publishing.id " +
            "JOIN point ON book.point_id = point.id " +
            "WHERE (CURRENT_DATE - 365 <= book.acquisition_date OR CURRENT_DATE - 365 <= book.decommission_date) AND " +
            "(:pointId IS NULL OR :pointId = point.id) AND " +
            "(:authorId IS NULL OR :authorId = author.id) AND " +
            "(:issueYear IS NULL OR :issueYear = extract(year from book.issue_date)) AND " +
            "(:supplyYear IS NULL OR :supplyYear = extract(year from book.acquisition_date))")
    Iterable<BookRepresentation> getFlow(Integer pointId, Integer authorId, Integer issueYear, Integer supplyYear);

    @Query("SELECT book.id, edition.title AS edition, author.name AS author, " +
            "publishing.name AS publishing, point.name AS point, " +
            "book.issue_date, book.acquisition_date, book.decommission_date " +
            "FROM book JOIN borrowing ON book.id = borrowing.book_id " +
            "JOIN order_table ON borrowing.id = order_table.borrowing_id" +
            "JOIN edition ON book.edition_id = edition.id " +
            "JOIN author ON edition.author_id = author.id " +
            "JOIN publishing ON edition.publishing_id = publishing.id " +
            "JOIN point ON book.point_id = point.id " +
            "WHERE :sinceDate::date <= order_table.supply_date")
    Iterable<BookRepresentation> getOrdered(String sinceDate);
}