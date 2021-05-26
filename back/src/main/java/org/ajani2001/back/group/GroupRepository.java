package org.ajani2001.back.group;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {

    @Query("SELECT group_table.id, group_table.number, faculty.name AS faculty " +
            "FROM group_table JOIN faculty " +
            "ON group_table.faculty_id = faculty.id")
    public Iterable<GroupRepresentation> findAllRepresentation();
}