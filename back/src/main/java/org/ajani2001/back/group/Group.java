package org.ajani2001.back.group;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@Table("group_table")
public class Group {

    @Id
    private Long id;
    private String number;
    private Long faculty_id;

}
