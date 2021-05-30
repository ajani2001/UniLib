package org.ajani2001.back.degree;

import org.ajani2001.back.CRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/degree")
public class DegreeController extends CRUDController<Degree> {
    @Autowired
    public DegreeController(DegreeRepository repository) {
        super(repository);
    }
}
