package org.ajani2001.back.penalty;

import org.ajani2001.back.RCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/penalty")
public class PenaltyController extends RCRUDController<Penalty, PenaltyRepresentation> {
    @Autowired
    public PenaltyController(PenaltyRepository repository) {
        super(repository);
    }
}
