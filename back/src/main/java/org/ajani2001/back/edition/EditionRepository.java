package org.ajani2001.back.edition;

import org.ajani2001.back.RCRUDRepository;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EditionRepository extends RCRUDRepository<Edition, EditionRepresentation, Long> {

    @Override
    @Query("SELECT edition.id, author.name AS author, publishing.name AS publishing, " +
            "edition.title, edition.cost " +
            "FROM edition JOIN author ON edition.author_id = author.id " +
            "JOIN publishing ON edition.publishing_id = publishing.id")
    public Iterable<EditionRepresentation> getRepresentationAll();

    @Override
    @Query("SELECT edition.id, author.name AS author, publishing.name AS publishing, " +
            "edition.title, edition.cost " +
            "FROM edition JOIN author ON edition.author_id = author.id " +
            "JOIN publishing ON edition.publishing_id = publishing.id " +
            "WHERE edition.id = :id")
    public Optional<EditionRepresentation> getRepresentationById(Long id);
}