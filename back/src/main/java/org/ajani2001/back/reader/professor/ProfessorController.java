package org.ajani2001.back.reader.professor;

import org.ajani2001.back.RCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController extends RCRUDController<Professor, ProfessorRepresentation> {
    @Autowired
    public ProfessorController(ProfessorRepository repository) {
        super(repository);
    }
}
