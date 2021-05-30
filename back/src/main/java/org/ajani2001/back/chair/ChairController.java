package org.ajani2001.back.chair;

import org.ajani2001.back.RCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chair")
public class ChairController extends RCRUDController<Chair, ChairRepresentation> {
    @Autowired
    public ChairController(ChairRepository repository) {
        super(repository);
    }
}
