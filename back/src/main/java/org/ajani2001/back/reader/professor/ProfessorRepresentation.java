package org.ajani2001.back.reader.professor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.ajani2001.back.reader.Reader;


@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProfessorRepresentation extends Reader {
    String degree;
    String rank;
    String chair;
    String faculty;
}