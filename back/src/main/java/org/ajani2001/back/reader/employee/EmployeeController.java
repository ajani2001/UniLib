package org.ajani2001.back.reader.employee;

import org.ajani2001.back.RCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController extends RCRUDController<Employee, EmployeeRepresentation> {
    @Autowired
    public EmployeeController(EmployeeRepository repository) {
        super(repository);
    }
}
