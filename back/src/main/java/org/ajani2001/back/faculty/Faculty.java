package org.ajani2001.back.faculty;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Faculty {
    @Id
    private Long id;
    private String name;
}
