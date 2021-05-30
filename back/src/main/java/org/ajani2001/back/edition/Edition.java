package org.ajani2001.back.edition;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ajani2001.back.BasicEntry;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
public class Edition implements BasicEntry {
    @Id
    Long id;
    Long author_id;
    Long publishing_id;
    String title;
    Integer cost;
}
