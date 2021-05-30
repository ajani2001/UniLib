package org.ajani2001.back.penalty.fine;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ajani2001.back.BasicEntry;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Data
@AllArgsConstructor
public class Fine implements BasicEntry {
    @Id
    @Column("penalty_id")
    Long id;
    Integer amount;
}
