package org.ajani2001.back.reader.employee;

import org.ajani2001.back.RCRUDRepository;
import org.springframework.data.jdbc.repository.query.Query;

import java.util.Optional;

public interface EmployeeRepository extends RCRUDRepository<Employee, EmployeeRepresentation, Long> {
    @Override
    @Query("SELECT reader.* " +
            "FROM reader JOIN employee ON reader.id = employee.reader_id ")
    Iterable<EmployeeRepresentation> getRepresentationAll();

    @Override
    @Query("SELECT reader.* " +
            "FROM reader JOIN employee ON reader.id = employee.reader_id " +
            "WHERE reader_id = :id")
    Optional<EmployeeRepresentation> getRepresentationById(Long id);
}
