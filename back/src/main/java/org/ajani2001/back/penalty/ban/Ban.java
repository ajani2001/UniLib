package org.ajani2001.back.penalty.ban;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ajani2001.back.BasicEntry;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.sql.Date;

@Data
@AllArgsConstructor
public class Ban implements BasicEntry {
    @Id
    @Column("penalty_id")
    Long id;
    Date endDate;
}
