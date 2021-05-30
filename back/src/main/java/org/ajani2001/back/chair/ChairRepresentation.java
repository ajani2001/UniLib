package org.ajani2001.back.chair;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class ChairRepresentation {
    @Id
    Long id;
    String faculty;
    String name;
}
