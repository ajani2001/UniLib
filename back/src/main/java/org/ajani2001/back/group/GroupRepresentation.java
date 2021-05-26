package org.ajani2001.back.group;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GroupRepresentation {
    private Long id;
    private Integer number;
    private String faculty;
}
