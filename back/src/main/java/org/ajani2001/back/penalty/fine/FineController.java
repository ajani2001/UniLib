package org.ajani2001.back.penalty.fine;

import org.ajani2001.back.RCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fine")
public class FineController extends RCRUDController<Fine, FineRepresentation> {
    @Autowired
    public FineController(FineRepository repository) {
        super(repository);
    }
}
