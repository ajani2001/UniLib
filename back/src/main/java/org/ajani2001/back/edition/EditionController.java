package org.ajani2001.back.edition;

import org.ajani2001.back.RCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/edition")
public class EditionController extends RCRUDController<Edition, EditionRepresentation> {
    @Autowired
    public EditionController(EditionRepository repository) {
        super(repository);
    }
}
