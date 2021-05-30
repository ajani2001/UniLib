package org.ajani2001.back.reader.professor;

import org.ajani2001.back.RCRUDRepository;
import org.springframework.data.jdbc.repository.query.Query;

import java.util.Optional;

public interface ProfessorRepository extends RCRUDRepository<Professor, ProfessorRepresentation, Long> {
    @Override
    @Query("SELECT reader.id, reader.first_name, reader.last_name, " +
            "reader.acceptation_date, reader.retirement_date, degree.name AS degree, " +
            "rank.name AS rank, chair.name AS chair, faculty.name AS faculty " +
            "FROM reader JOIN professor ON reader.id = professor.reader_id " +
            "JOIN degree ON professor.degree_id = degree.id " +
            "JOIN rank ON professor.rank_id = rank.id " +
            "JOIN chair ON professor.chair_id = chair.id " +
            "JOIN faculty ON chair.faculty_id = faculty.id")
    Iterable<ProfessorRepresentation> getRepresentationAll();

    @Override
    @Query("SELECT reader.id, reader.first_name, reader.last_name, " +
            "reader.acceptation_date, reader.retirement_date, degree.name AS degree, " +
            "rank.name AS rank, chair.name AS chair, faculty.name AS faculty " +
            "FROM reader JOIN professor ON reader.id = professor.reader_id " +
            "JOIN degree ON professor.degree_id = degree.id " +
            "JOIN rank ON professor.rank_id = rank.id " +
            "JOIN chair ON professor.chair_id = chair.id " +
            "JOIN faculty ON chair.faculty_id = faculty.id " +
            "WHERE professor.reader_id = :id")
    Optional<ProfessorRepresentation> getRepresentationById(Long id);
}
