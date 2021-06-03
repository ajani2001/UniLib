package org.ajani2001.back.point;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PointRepresentation {
    Long id;
    String name;
    Boolean isSubscription;
    Integer readerCount;
    Integer debtorCount;
    Integer debtAmount;
}
