package org.ajani2001.back.chair;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ChairRepresentation extends Chair {
    String faculty;
}
