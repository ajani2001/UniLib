package org.ajani2001.back.group;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GroupRepresentation {
    Long id;
    Integer number;
    Integer year;
    String faculty;
}
