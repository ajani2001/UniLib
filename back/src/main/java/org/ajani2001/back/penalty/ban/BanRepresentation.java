package org.ajani2001.back.penalty.ban;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.ajani2001.back.penalty.PenaltyRepresentation;

import java.sql.Date;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BanRepresentation extends PenaltyRepresentation {
    Date endDate;
}
