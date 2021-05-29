package org.ajani2001.back.faculty;

import org.ajani2001.back.CRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/faculty")
public class FacultyController extends CRUDController<Faculty> {
    @Autowired
    public FacultyController(FacultyRepository repository) {
        super(repository);
    }
}
