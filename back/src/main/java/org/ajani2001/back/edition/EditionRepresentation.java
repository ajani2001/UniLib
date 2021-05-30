package org.ajani2001.back.edition;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class EditionRepresentation {
    Long id;
    String author;
    String publishing;
    String title;
    Integer cost;
}
