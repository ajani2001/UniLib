package org.ajani2001.back.penalty.fine;

import org.ajani2001.back.RCRUDRepository;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FineRepository extends RCRUDRepository<Fine, FineRepresentation, Long> {

    @Override
    @Query("SELECT penalty.id, reader.first_name AS reader_first_name, " +
            "reader.last_name AS reader_last_name, penalty.date, fine.amount " +
            "FROM fine JOIN penalty ON fine.penalty_id = penalty.id " +
            "JOIN reader ON penalty.reader_id = reader.id")
    public Iterable<FineRepresentation> getRepresentationAll();

    @Override
    @Query("SELECT penalty.id, reader.first_name AS reader_first_name, " +
            "reader.last_name AS reader_last_name, penalty.date, fine.amount " +
            "FROM fine JOIN penalty ON fine.penalty_id = penalty.id " +
            "JOIN reader ON penalty.reader_id = reader.id" +
            "WHERE fine.penalty_id = :id")
    public Optional<FineRepresentation> getRepresentationById(Long id);
}