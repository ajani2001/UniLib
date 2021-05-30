package org.ajani2001.back.penalty.property_compensation;

import org.ajani2001.back.RCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/property_compensation")
public class PropertyCompensationController extends RCRUDController<PropertyCompensation, PropertyCompensationRepresentation> {
    @Autowired
    public PropertyCompensationController(PropertyCompensationRepository repository) {
        super(repository);
    }
}
