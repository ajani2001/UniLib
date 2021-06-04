package org.ajani2001.back.penalty.property_compensation;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ajani2001.back.BasicEntry;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Data
@AllArgsConstructor
public class PropertyCompensation implements BasicEntry {
    @Id
    @Column("penalty_id")
    Long id;
    Long old_book_id;
    Long new_book_id;
}
