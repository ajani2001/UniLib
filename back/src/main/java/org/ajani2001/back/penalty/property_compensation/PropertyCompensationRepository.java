package org.ajani2001.back.penalty.property_compensation;

import org.ajani2001.back.RCRUDRepository;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PropertyCompensationRepository extends RCRUDRepository<PropertyCompensation, PropertyCompensationRepresentation, Long> {

    @Override
    @Query("SELECT penalty.id, reader.first_name AS reader_first_name, " +
            "reader.last_name AS reader_last_name, penalty.date, " +
            "edition_old.title AS old_book_title, edition_new.title AS new_book_title " +
            "FROM property_compensation JOIN penalty ON property_compensation.penalty_id = penalty.id " +
            "JOIN reader ON penalty.reader_id = reader.id " +
            "JOIN book AS book_old ON property_compensation.old_book_id = book_old.id " +
            "JOIN edition AS edition_old ON book_old.edition_id = edition_old.id " +
            "JOIN book AS book_new ON property_compensation.new_book_id = book_new.id " +
            "JOIN edition AS edition_new ON book_new.edition_id = edition_new.id")
    public Iterable<PropertyCompensationRepresentation> getRepresentationAll();

    @Override
    @Query("SELECT penalty.id, reader.first_name AS reader_first_name, " +
            "reader.last_name AS reader_last_name, penalty.date, " +
            "edition_old.title AS old_book_title, edition_new.title AS new_book_title " +
            "FROM property_compensation JOIN penalty ON property_compensation.penalty_id = penalty.id " +
            "JOIN reader ON penalty.reader_id = reader.id " +
            "JOIN book AS book_old ON property_compensation.old_book_id = book_old.id " +
            "JOIN edition AS edition_old ON book_old.edition_id = edition_old.id " +
            "JOIN book AS book_new ON property_compensation.new_book_id = book_new.id " +
            "JOIN edition AS edition_new ON book_new.edition_id = edition_new.id " +
            "WHERE property_compensation.penalty_id = :id")
    public Optional<PropertyCompensationRepresentation> getRepresentationById(Long id);
}