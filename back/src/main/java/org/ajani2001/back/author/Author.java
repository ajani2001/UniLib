package org.ajani2001.back.author;

import lombok.Data;
import lombok.AllArgsConstructor;
import org.ajani2001.back.BasicEntry;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Author implements BasicEntry {
    @Id
    private Long id;
    private String name;
}