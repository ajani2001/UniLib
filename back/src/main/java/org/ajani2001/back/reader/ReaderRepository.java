package org.ajani2001.back.reader;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface ReaderRepository extends CrudRepository<Reader, Long> {

    @Query("SELECT DISTINCT reader.id, reader.first_name, reader.last_name, " +
            "reader.acceptation_date, reader.retirement_date " +
            "FROM reader LEFT JOIN borrowing ON reader.id = borrowing.reader_id " +
            "LEFT JOIN point ON borrowing.point_id = point.id " +
            "LEFT JOIN penalty ON reader.id = penalty.reader_id " +
            "LEFT JOIN ban ON penalty.id = ban.penalty_id " +
            "LEFT JOIN professor ON reader.id = professor.reader_id " +
            "LEFT JOIN chair on professor.chair_id = chair.id " +
            "LEFT JOIN faculty as professor_faculty ON chair.faculty_id = professor_faculty.id " +
            "LEFT JOIN student ON reader.id = student.reader_id " +
            "LEFT JOIN group_table ON student.group_id = group_table.id " +
            "LEFT JOIN faculty as student_faculty ON group_table.faculty_id = student_faculty.id " +
            "LEFT JOIN employee ON reader.id = employee.reader_id " +
            "WHERE (:pointId IS NULL OR :pointId = point.id) AND " +
            "(:chairId IS NULL OR :chairId = chair.id) AND " +
            "(:facultyId IS NULL OR :facultyId = professor_faculty.id OR :facultyId = student_faculty.id) AND " +
            "(:year IS NULL OR :year = group_table.year) AND " +
            "(:groupId IS NULL OR :groupId = group_table.id) AND " +
            "(:isStudent IS NULL OR :isStudent = true AND student.reader_id IS NOT NULL OR :isStudent = false AND student.reader_id IS NULL) AND " +
            "(:isProfessor IS NULL OR :isProfessor = true AND professor.reader_id IS NOT NULL OR :isProfessor = false AND professor.reader_id IS NULL) AND " +
            "(:isEmployee IS NULL OR :isEmployee = true AND employee.reader_id IS NOT NULL OR :isEmployee = false AND employee.reader_id IS NULL) AND " +
            "(:isDebtor IS NULL OR borrowing.end_date IS NULL AND borrowing.until_date < CURRENT_DATE) AND " +
            "(:isMaliciousDebtor IS NULL OR borrowing.end_date IS NULL AND borrowing.until_date < CURRENT_DATE - 10) AND" +
            "(:isBanned IS NULL OR ban.end_date > CURRENT_DATE) AND " +
            "(:isBannedForALongTime IS NULL OR ban.end_date - penalty.date > 60) AND " +
            "(:acceptedSince IS NULL OR :acceptedSince::date < reader.acceptation_date) AND " +
            "(cast(:retiredSince as date) IS NULL OR cast(:retiredSince as date) < reader.retirement_date)")
    Iterable<Reader>getFiltered(Integer pointId, Integer chairId, Integer facultyId, Integer year, Integer groupId, Boolean isStudent, Boolean isProfessor, Boolean isEmployee, Boolean isDebtor, Boolean isMaliciousDebtor, Boolean isBanned, Boolean isBannedForALongTime, Date acceptedSince, Date retiredSince);
}
