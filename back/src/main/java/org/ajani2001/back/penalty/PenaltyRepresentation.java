package org.ajani2001.back.penalty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PenaltyRepresentation extends Penalty {
    String readerFirstName;
    String readerLastName;
}
