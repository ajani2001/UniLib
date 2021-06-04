package org.ajani2001.back.book;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.ajani2001.back.BasicEntry;
import org.springframework.data.annotation.Id;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements BasicEntry {
    @Id
    Long id;
    Long edition_id;
    Long point_id;
    Date issueDate;
    Date acquisitionDate;
    Date decommissionDate;
}