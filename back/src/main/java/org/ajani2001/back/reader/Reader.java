package org.ajani2001.back.reader;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.ajani2001.back.BasicEntry;
import org.springframework.data.annotation.Id;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reader implements BasicEntry {
    @Id
    Long id;
    String firstName;
    String lastName;
    Date acceptationDate;
    Date retirementDate;
}