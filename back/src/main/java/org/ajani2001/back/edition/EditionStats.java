package org.ajani2001.back.edition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EditionStats extends EditionRepresentation {
    Integer borrowingCount;
}
