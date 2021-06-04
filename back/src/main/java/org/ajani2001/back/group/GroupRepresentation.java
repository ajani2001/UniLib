package org.ajani2001.back.group;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GroupRepresentation extends Group {
    String faculty;
}
