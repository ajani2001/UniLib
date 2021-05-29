package org.ajani2001.back.reader.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentRepository repository;

    @PostMapping
    Student create(@RequestBody Student newStudent) {
        return repository.save(newStudent);
    }

    @GetMapping
    Iterable<Student> readAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Student readById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PutMapping("/{id}")
    Student updateById(@RequestBody Student student, @PathVariable Long id) {
        if(!student.getId().equals(id))
            throw new RuntimeException();

        return repository.save(student);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
