package org.ajani2001.back.faculty;

import lombok.Data;
import lombok.AllArgsConstructor;
import org.ajani2001.back.BasicEntry;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Faculty implements BasicEntry {
    @Id
    private Long id;
    private String name;
}
