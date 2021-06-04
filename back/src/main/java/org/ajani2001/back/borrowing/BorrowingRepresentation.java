package org.ajani2001.back.borrowing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BorrowingRepresentation extends Borrowing {
    String readerFirstName;
    String readerLastName;
    String title;
    String point;
}
