package org.ajani2001.back.book;

import lombok.Data;
import lombok.AllArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
public class BookRepresentation {
    Long id;
    String title;
    String author;
    String publishing;
    String point;
    Date acquisitionDate;
    Date decommissionDate;
}