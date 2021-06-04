package org.ajani2001.back.penalty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ajani2001.back.BasicEntry;
import org.springframework.data.annotation.Id;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Penalty implements BasicEntry {
    @Id
    Long id;
    Long reader_id;
    Date date;
}
