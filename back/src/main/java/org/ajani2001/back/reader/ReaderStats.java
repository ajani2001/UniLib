package org.ajani2001.back.reader;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ReaderStats extends Reader {
    Integer group;
    Integer year;
    String faculty;
    String chair;
    Integer penaltyCount;
}
