package org.ajani2001.back.penalty.fine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.ajani2001.back.penalty.PenaltyRepresentation;

import java.sql.Date;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FineRepresentation extends PenaltyRepresentation {
    Integer amount;
}
