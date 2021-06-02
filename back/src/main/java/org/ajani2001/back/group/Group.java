package org.ajani2001.back.group;

import lombok.Data;
import lombok.AllArgsConstructor;
import org.ajani2001.back.BasicEntry;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@Table("group_table")
public class Group implements BasicEntry {
    @Id
    Long id;
    String number;
    Integer year;
    Long faculty_id;
}
