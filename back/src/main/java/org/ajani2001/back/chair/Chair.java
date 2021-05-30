package org.ajani2001.back.chair;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ajani2001.back.BasicEntry;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Chair implements BasicEntry {
    @Id
    Long id;
    Long faculty_id;
    String name;
}
