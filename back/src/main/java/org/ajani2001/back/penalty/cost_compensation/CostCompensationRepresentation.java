package org.ajani2001.back.penalty.cost_compensation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.ajani2001.back.penalty.PenaltyRepresentation;

import java.sql.Date;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CostCompensationRepresentation extends PenaltyRepresentation {
    Long book_id;
    String bookTitle;
    Integer bookCost;
}
