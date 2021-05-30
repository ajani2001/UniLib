package org.ajani2001.back.penalty.cost_compensation;

import org.ajani2001.back.RCRUDRepository;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CostCompensationRepository extends RCRUDRepository<CostCompensation, CostCompensationRepresentation, Long> {

    @Override
    @Query("SELECT penalty.id, reader.first_name AS reader_first_name, " +
            "reader.last_name AS reader_last_name, penalty.date, " +
            "edition.title AS book_title, edition.cost AS book_cost " +
            "FROM cost_compensation JOIN penalty ON cost_compensation.penalty_id = penalty.id " +
            "JOIN reader ON penalty.reader_id = reader.id " +
            "JOIN book ON cost_compensation.book_id = book.id " +
            "JOIN edition ON book.edition_id = edition.id")
    public Iterable<CostCompensationRepresentation> getRepresentationAll();

    @Override
    @Query("SELECT penalty.id, reader.first_name AS reader_first_name, " +
            "reader.last_name AS reader_last_name, penalty.date, " +
            "edition.title AS book_title, edition.cost AS book_cost " +
            "FROM cost_compensation JOIN penalty ON cost_compensation.penalty_id = penalty.id " +
            "JOIN reader ON penalty.reader_id = reader.id" +
            "JOIN book ON cost_compensation.book_id = book.id " +
            "JOIN edition ON book.edition_id = edition.id " +
            "WHERE cost_compensation.penalty_id = :id")
    public Optional<CostCompensationRepresentation> getRepresentationById(Long id);
}