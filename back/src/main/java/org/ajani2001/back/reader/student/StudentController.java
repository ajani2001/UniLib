package org.ajani2001.back.reader.student;

import org.ajani2001.back.RCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController extends RCRUDController<Student, StudentRepresentation> {
    @Autowired
    public StudentController(StudentRepository repository) {
        super(repository);
    }
}
