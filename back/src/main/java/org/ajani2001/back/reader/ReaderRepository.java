package org.ajani2001.back.reader;

import org.ajani2001.back.book.BookRepresentation;
import org.ajani2001.back.borrowing.BorrowingRepresentation;
import org.ajani2001.back.penalty.fine.FineRepresentation;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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
            "(:retiredSince IS NULL OR :retiredSince::date < reader.retirement_date)")
    Iterable<Reader>getFiltered(Integer pointId, Integer chairId, Integer facultyId, Integer year, Integer groupId, Boolean isStudent, Boolean isProfessor, Boolean isEmployee, Boolean isDebtor, Boolean isMaliciousDebtor, Boolean isBanned, Boolean isBannedForALongTime, String acceptedSince, String retiredSince);

    @Query("SELECT reader.id, reader.first_name, reader.last_name, " +
            "reader.acceptation_date, reader.retirement_date, " +
            "group_table.number AS group, group_table.year, faculty.name AS faculty, " +
            "chair.name AS chair, subq_penalty.penalty_count " +
            "FROM reader JOIN " +
            "(SELECT reader.id AS reader_id, COUNT(penalty.id) AS penalty_count " +
            "FROM reader LEFT JOIN penalty ON reader.id = penalty.reader_id " +
            "GROUP BY reader.id) AS subq_penalty " +
            "ON reader.id = subq_penalty.reader_id " +
            "LEFT JOIN professor ON reader.id = professor.reader_id " +
            "LEFT JOIN chair ON professor.chair_id = chair.id " +
            "LEFT JOIN student ON reader.id = student.reader_id " +
            "LEFT JOIN group_table ON student.group_id = group_table.id " +
            "LEFT JOIN faculty ON COALESCE(chair.faculty_id, group_table.faculty_id) = faculty.id " +
            "WHERE reader.id = :id")
    Optional<ReaderStats> getStatsById(Long id);

    @Query("SELECT penalty.id, reader.first_name AS reader_first_name, " +
            "reader.last_name AS reader_last_name, penalty.date, fine.amount " +
            "FROM reader JOIN penalty ON reader.id = penalty.reader_id " +
            "JOIN fine ON penalty.id = fine.penalty_id " +
            "WHERE reader.id = :id")
    Iterable<FineRepresentation> getFinesById(Long id);

    @Query("SELECT book.id, edition.title AS edition, author.name AS author, " +
            "publishing.name AS publishing, point.name AS point, " +
            "book.issue_date, book.acquisition_date, book.decommission_date " +
            "FROM reader JOIN penalty ON reader.id = penalty.reader_id " +
            "LEFT JOIN property_compensation ON penalty.id = property_compensation.penalty_id " +
            "LEFT JOIN cost_compensation ON penalty.id = cost_compensation.penalty_id " +
            "JOIN book ON COALESCE(property_compensation.lost_book_id, cost_compensation.book_id) = book.id " +
            "WHERE reader.id = :id")
    Iterable<BookRepresentation> getLostBooksById(Long id);

    @Query("SELECT borrowing.id, reader.first_name AS reader_first_name, " +
            "reader.last_name AS reader_last_name, edition.title AS title, " +
            "point.name AS point, borrowing.begin_date, borrowing.end_date, borrowing.until_date " +
            "FROM borrowing JOIN reader ON borrowing.reader_id = reader.id " +
            "JOIN book ON borrowing.book_id = book.id " +
            "JOIN edition ON book.edition_id = edition.id " +
            "JOIN point ON borrowing.point_id = point.id " +
            "WHERE reader.id = :id AND " +
            "(:sinceDate IS NULL OR :sinceDate::date <= borrowing.begin_date) AND " +
            "(:notReturned IS NULL OR borrowing.end_date IS NULL)")
    Iterable<BorrowingRepresentation> getBorrowingsById(Long id, String sinceDate, Boolean notReturned);
}
