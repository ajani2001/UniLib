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
    private Long id;
    private String number;
    private Long faculty_id;
}
