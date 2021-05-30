package org.ajani2001.back.point;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ajani2001.back.BasicEntry;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Point implements BasicEntry {
    @Id
    Long id;
    String name;
    Boolean isSubscription;
}