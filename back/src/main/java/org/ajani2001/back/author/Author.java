package org.ajani2001.back.author;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Author {
    @Id
    private Long id;
    private String name;
}