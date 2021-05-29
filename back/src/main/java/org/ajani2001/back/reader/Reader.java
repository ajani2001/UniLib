package org.ajani2001.back.reader;

import lombok.Data;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;

import java.sql.Date;

@Data
@AllArgsConstructor
public class Reader {
    @Id
    Long id;
    String firstName;
    String lastName;
    Date acceptationDate;
    Date retirementDate;
}