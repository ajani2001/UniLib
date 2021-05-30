package org.ajani2001.back.borrowing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowingRepresentation {
    Long id;
    String readerFirstName;
    String readerLastName;
    String title;
    String point;
    Date beginDate;
    Date endDate;
    Date untilDate;
}
