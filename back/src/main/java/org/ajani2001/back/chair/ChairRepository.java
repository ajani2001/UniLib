package org.ajani2001.back.chair;

import org.ajani2001.back.RCRUDRepository;
import org.springframework.data.jdbc.repository.query.Query;

import java.util.Optional;

public interface ChairRepository extends RCRUDRepository<Chair, ChairRepresentation, Long> {
    @Override
    @Query("SELECT chair.id, faculty.name AS faculty, chair.name " +
            "FROM chair JOIN faculty ON chair.faculty_id = faculty.id")
    Iterable<ChairRepresentation> getRepresentationAll();

    @Override
    @Query("SELECT chair.id, faculty.name AS faculty, chair.name " +
            "FROM chair JOIN faculty ON chair.faculty_id = faculty.id " +
            "WHERE chair.id = :id")
    Optional<ChairRepresentation> getRepresentationById(Long id);
}
