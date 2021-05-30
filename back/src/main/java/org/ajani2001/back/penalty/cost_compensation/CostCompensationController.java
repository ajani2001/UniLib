package org.ajani2001.back.penalty.cost_compensation;

import org.ajani2001.back.RCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cost_compensation")
public class CostCompensationController extends RCRUDController<CostCompensation, CostCompensationRepresentation> {
    @Autowired
    public CostCompensationController(CostCompensationRepository repository) {
        super(repository);
    }
}
