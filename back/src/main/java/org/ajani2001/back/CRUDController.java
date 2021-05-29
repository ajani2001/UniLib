package org.ajani2001.back;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;

public abstract class CRUDController<EntryClass extends BasicEntry> {
    private final CrudRepository<EntryClass, Long> repository;

    public CRUDController(CrudRepository<EntryClass, Long> repository) {
        this.repository = repository;
    }

    @PostMapping
    EntryClass create(@RequestBody EntryClass newEntry) {
        return repository.save(newEntry);
    }

    @GetMapping
    Iterable<EntryClass> readAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    EntryClass readById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PutMapping("/{id}")
    EntryClass updateById(@RequestBody EntryClass entry, @PathVariable Long id) {
        if(!entry.getId().equals(id))
            throw new RuntimeException();
        return repository.save(entry);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
