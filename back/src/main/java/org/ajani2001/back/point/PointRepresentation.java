package org.ajani2001.back.point;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PointRepresentation extends Point {
    Integer readerCount;
    Integer debtorCount;
    Integer debtAmount;
}
