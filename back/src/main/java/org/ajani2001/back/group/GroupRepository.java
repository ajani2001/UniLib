package org.ajani2001.back.group;

import org.ajani2001.back.RCRUDRepository;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends RCRUDRepository<Group, GroupRepresentation, Long> {

    @Override
    @Query("SELECT group_table.id, group_table.number, faculty.name AS faculty " +
            "FROM group_table JOIN faculty " +
            "ON group_table.faculty_id = faculty.id")
    public Iterable<GroupRepresentation> getRepresentationAll();

    @Override
    @Query("SELECT group_table.id, group_table.number, faculty.name AS faculty " +
            "FROM group_table JOIN faculty " +
            "ON group_table.faculty_id = faculty.id " +
            "WHERE group_table.id = :id")
    public Optional<GroupRepresentation> getRepresentationById(Long id);
}