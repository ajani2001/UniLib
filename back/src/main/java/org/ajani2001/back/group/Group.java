package org.ajani2001.back.group;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.ajani2001.back.BasicEntry;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("group_table")
public class Group implements BasicEntry {
    @Id
    Long id;
    Integer number;
    Integer year;
    Long faculty_id;
}
