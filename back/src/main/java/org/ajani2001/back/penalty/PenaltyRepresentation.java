package org.ajani2001.back.penalty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PenaltyRepresentation {
    Long id;
    String readerFirstName;
    String readerLastName;
    Date date;
}
