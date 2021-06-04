package org.ajani2001.back.edition;

import org.ajani2001.back.RCRUDRepository;
import org.ajani2001.back.borrowing.BorrowingRepresentation;
import org.ajani2001.back.reader.Reader;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EditionRepository extends RCRUDRepository<Edition, EditionRepresentation, Long> {

    @Override
    @Query("SELECT edition.*, author.name AS author, publishing.name AS publishing " +
            "FROM edition JOIN author ON edition.author_id = author.id " +
            "JOIN publishing ON edition.publishing_id = publishing.id")
    Iterable<EditionRepresentation> getRepresentationAll();

    @Override
    @Query("SELECT edition.*, author.name AS author, publishing.name AS publishing " +
            "FROM edition JOIN author ON edition.author_id = author.id " +
            "JOIN publishing ON edition.publishing_id = publishing.id " +
            "WHERE edition.id = :id")
    Optional<EditionRepresentation> getRepresentationById(Long id);

    @Query("SELECT edition.*, author.name AS author, " +
            "publishing.name AS publishing, COUNT(edition.id) as borrowing_count " +
            "FROM edition JOIN author ON edition.author_id = author.id " +
            "JOIN publishing ON edition.publishing_id = publishing.id " +
            "JOIN book ON edition.id = book.edition_id " +
            "JOIN borrowing ON book.id = borrowing.book_id " +
            "JOIN reader ON borrowing.reader_id = reader.id " +
            "LEFT JOIN student ON reader.id = student.reader_id " +
            "LEFT JOIN group_table ON student.group_id = group_table.id " +
            "LEFT JOIN faculty AS student_faculty ON group_table.faculty_id = student_faculty.id " +
            "LEFT JOIN professor ON reader.id = professor.reader_id " +
            "LEFT JOIN chair ON professor.chair_id = chair.id " +
            "LEFT JOIN faculty AS professor_faculty ON chair.faculty_id = professor_faculty.id " +
            "WHERE (:pointId IS NULL OR :pointId = borrowing.point_id) AND " +
            "(:facultyId IS NULL OR :facultyId = professor_faculty.id OR :facultyId = student_faculty.id)" +
            "GROUP BY edition.id, author.name, publishing.name " +
            "ORDER BY borrowing_count DESC " +
            "LIMIT 20")
    Iterable<EditionStats> getTop20(Long pointId, Long facultyId);

    @Query("SELECT COALESCE(SUM(book.id), 0) AS amount " +
            "FROM edition JOIN book ON edition.id = book.edition_id " +
            "WHERE edition.id = :id AND " +
            "(:pointId IS NULL OR book.point_id = :pointId) AND " +
            "(:isPresent IS NULL OR :isPresent = book.id NOT IN " +
            "(SELECT book_id FROM borrowing WHERE end_date IS NULL) ) ")
    Integer getAmountById(Long id, Long pointId, Boolean isPresent);

    @Query("SELECT borrowing.*, reader.first_name AS reader_first_name, " +
            "reader.last_name AS reader_last_name, " +
            "edition.title AS title, point.name AS point " +
            "FROM borrowing JOIN reader ON borrowing.reader_id = reader.id " +
            "JOIN book ON borrowing.book_id = book.id " +
            "JOIN edition ON book.edition_id = edition.id " +
            "JOIN point ON borrowing.point_id = point.id " +
            "WHERE edition.id = :id AND borrowing.end_date IS NULL")
    Iterable<BorrowingRepresentation> getCurrentBorrowingsById(Long id);
}