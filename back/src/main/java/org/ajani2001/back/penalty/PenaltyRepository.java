package org.ajani2001.back.penalty;

import org.ajani2001.back.RCRUDRepository;
import org.springframework.data.jdbc.repository.query.Query;

import java.util.Optional;

public interface PenaltyRepository extends RCRUDRepository<Penalty, PenaltyRepresentation, Long> {
    @Override
    @Query("SELECT penalty.*, reader.first_name AS reader_first_name, " +
            "reader.last_name AS reader_last_name " +
            "FROM penalty JOIN reader ON penalty.reader_id = reader.id")
    Iterable<PenaltyRepresentation> getRepresentationAll();

    @Override
    @Query("SELECT penalty.*, reader.first_name AS reader_first_name, " +
            "reader.last_name AS reader_last_name " +
            "FROM penalty JOIN reader ON penalty.reader_id = reader.id " +
            "WHERE penalty.id = :id")
    Optional<PenaltyRepresentation> getRepresentationById(Long id);
}
