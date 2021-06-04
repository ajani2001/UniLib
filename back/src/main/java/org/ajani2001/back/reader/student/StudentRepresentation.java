package org.ajani2001.back.reader.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.ajani2001.back.reader.Reader;


@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class StudentRepresentation extends Reader {
    Long groupId;
    Integer group;
    String faculty;
}
