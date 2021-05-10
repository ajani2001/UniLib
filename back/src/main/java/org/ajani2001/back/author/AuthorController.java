package org.ajani2001.back.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private AuthorRepository repository;

    @PostMapping
    Author create(@RequestBody Author newAuthor) {
        return repository.save(newAuthor);
    }

    @GetMapping
    Iterable<Author> readAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Author readById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PutMapping("/{id}")
    Author updateById(@RequestBody Author author, @PathVariable Long id) {
        if(!author.getId().equals(id))
            throw new RuntimeException();

        return repository.save(author);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
