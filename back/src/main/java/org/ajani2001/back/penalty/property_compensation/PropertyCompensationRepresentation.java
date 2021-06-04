package org.ajani2001.back.penalty.property_compensation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.ajani2001.back.penalty.PenaltyRepresentation;

import java.sql.Date;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PropertyCompensationRepresentation extends PenaltyRepresentation {
    Long old_book_id;
    Long new_book_id;
    String oldBookTitle;
    String newBookTitle;
}
