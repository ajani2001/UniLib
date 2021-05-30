package org.ajani2001.back.borrowing.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ajani2001.back.BasicEntry;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;

@Data
@AllArgsConstructor
@Table("order_table")
public class Order implements BasicEntry {
    @Id
    @Column("borrowing_id")
    Long id;
    Date supplyDate;
}
