package org.ajani2001.back.reader.professor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.ajani2001.back.reader.Reader;


@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProfessorRepresentation extends Reader {
    Long degree_id;
    Long rank_id;
    Long chair_id;
    String degree;
    String rank;
    String chair;
    String faculty;
}