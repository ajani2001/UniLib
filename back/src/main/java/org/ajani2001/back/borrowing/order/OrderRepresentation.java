package org.ajani2001.back.borrowing.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.ajani2001.back.borrowing.BorrowingRepresentation;

import java.sql.Date;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderRepresentation extends BorrowingRepresentation {
    Date supplyDate;
}
