package org.ajani2001.back.book;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.sql.Date;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BookRepresentation extends Book {
    String title;
    String author;
    String publishing;
    String point;
}