package org.ajani2001.back.reader.professor;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ajani2001.back.BasicEntry;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Data
@AllArgsConstructor
public class Professor implements BasicEntry {
    @Id
    @Column("reader_id")
    Long id;
    Long degree_id;
    Long rank_id;
    Long chair_id;
}