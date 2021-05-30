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
            "book.acquisition_date, book.decommission_date " +
            "FROM book JOIN edition ON book.edition_id = edition.id " +
            "JOIN author ON edition.author_id = author.id " +
            "JOIN publishing ON edition.publishing_id = publishing.id " +
            "JOIN point ON book.point_id = point.id")
    public Iterable<BookRepresentation> getRepresentationAll();

    @Override
    @Query("SELECT book.id, edition.title AS edition, author.name AS author, " +
            "publishing.name AS publishing, point.name AS point, " +
            "book.acquisition_date, book.decommission_date " +
            "FROM book JOIN edition ON book.edition_id = edition.id " +
            "JOIN author ON edition.author_id = author.id " +
            "JOIN publishing ON edition.publishing_id = publishing.id " +
            "JOIN point ON book.point_id = point.id " +
            "WHERE book.id = :id")
    public Optional<BookRepresentation> getRepresentationById(Long id);
}