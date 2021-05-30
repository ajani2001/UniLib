package org.ajani2001.back.reader.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ajani2001.back.BasicEntry;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Data
@AllArgsConstructor
public class Employee implements BasicEntry {
    @Id
    @Column("reader_id")
    Long id;
}