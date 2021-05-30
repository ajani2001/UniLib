package org.ajani2001.back.borrowing;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ajani2001.back.BasicEntry;
import org.springframework.data.annotation.Id;

import java.sql.Date;

@Data
@AllArgsConstructor
public class Borrowing implements BasicEntry {
    @Id
    Long id;
    Long reader_id;
    Long book_id;
    Long point_id;
    Date beginDate;
    Date endDate;
    Date untilDate;
}
