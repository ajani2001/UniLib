package org.ajani2001.back.faculty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/faculty")
public class FacultyController {

    @Autowired
    private FacultyRepository repository;

    @PostMapping
    Faculty create(@RequestBody Faculty newFaculty) {
        return repository.save(newFaculty);
    }

    @GetMapping
    Iterable<Faculty> readAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Faculty readById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PutMapping("/{id}")
    Faculty updateById(@RequestBody Faculty faculty, @PathVariable Long id) {
        if(!faculty.getId().equals(id))
            throw new RuntimeException();

        return repository.save(faculty);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
