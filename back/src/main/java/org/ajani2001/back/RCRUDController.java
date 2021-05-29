package org.ajani2001.back;

import org.springframework.web.bind.annotation.*;

public abstract class RCRUDController<EntryClass extends BasicEntry, EntryRepresentationClass> {
    final RCRUDRepository <EntryClass, EntryRepresentationClass, Long> repository;

    public RCRUDController(RCRUDRepository<EntryClass, EntryRepresentationClass, Long> repository) {
        this.repository = repository;
    }

    @PostMapping
    EntryClass create(@RequestBody EntryClass newEntry) {
        return repository.save(newEntry);
    }

    @GetMapping
    Iterable<EntryRepresentationClass> readAll() {
        return repository.getRepresentationAll();
    }

    @GetMapping("/{id}")
    EntryRepresentationClass readById(@PathVariable Long id) {
        return repository.getRepresentationById(id).orElseThrow(RuntimeException::new);
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
