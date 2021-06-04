package org.ajani2001.back.reader.student;

import org.ajani2001.back.RCRUDRepository;
import org.springframework.data.jdbc.repository.query.Query;

import java.util.Optional;

public interface StudentRepository extends RCRUDRepository<Student, StudentRepresentation, Long> {
    @Override
    @Query("SELECT reader.*, group_table.id AS group_id, " +
            "group_table.number AS group, faculty.name AS faculty " +
            "FROM reader JOIN student ON reader.id = student.reader_id " +
            "JOIN group_table ON student.group_id = group_table.id " +
            "JOIN faculty ON group_table.faculty_id = faculty.id")
    Iterable<StudentRepresentation> getRepresentationAll();

    @Override
    @Query("SELECT reader.*, group_table.id AS group_id, " +
            "group_table.number AS group, faculty.name AS faculty " +
            "FROM reader JOIN student ON reader.id = student.reader_id " +
            "JOIN group_table ON student.group_id = group_table.id " +
            "JOIN faculty ON group_table.faculty_id = faculty.id " +
            "WHERE reader.id = :id")
    Optional<StudentRepresentation> getRepresentationById(Long id);
}
