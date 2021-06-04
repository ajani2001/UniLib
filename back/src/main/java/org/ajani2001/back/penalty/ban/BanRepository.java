package org.ajani2001.back.penalty.ban;

import org.ajani2001.back.RCRUDRepository;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BanRepository extends RCRUDRepository<Ban, BanRepresentation, Long> {

    @Override
    @Query("SELECT penalty.*, reader.first_name AS reader_first_name, " +
            "reader.last_name AS reader_last_name, ban.end_date " +
            "FROM ban JOIN penalty ON ban.penalty_id = penalty.id " +
            "JOIN reader ON penalty.reader_id = reader.id")
    public Iterable<BanRepresentation> getRepresentationAll();

    @Override
    @Query("SELECT penalty.*, reader.first_name AS reader_first_name, " +
            "reader.last_name AS reader_last_name, ban.end_date " +
            "FROM ban JOIN penalty ON ban.penalty_id = penalty.id " +
            "JOIN reader ON penalty.reader_id = reader.id " +
            "WHERE ban.penalty_id = :id")
    public Optional<BanRepresentation> getRepresentationById(Long id);
}