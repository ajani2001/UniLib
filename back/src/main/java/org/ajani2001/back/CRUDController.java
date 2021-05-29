package org.ajani2001.back;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;

public abstract class CRUDController<T extends BasicEntry> {

    private final CrudRepository<T, Long> repository;

    CRUDController(CrudRepository<T, Long> repository) {
        this.repository = repository;
    }

    @PostMapping
    T create(@RequestBody T newEntry) {
        return repository.save(newEntry);
    }

    @GetMapping
    Iterable<T> readAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    T readById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PutMapping("/{id}")
    T updateById(@RequestBody T entry, @PathVariable Long id) {
        if(!entry.getId().equals(id))
            throw new RuntimeException();

        return repository.save(entry);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
