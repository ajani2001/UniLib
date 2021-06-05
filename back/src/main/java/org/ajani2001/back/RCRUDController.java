package org.ajani2001.back;

import org.ajani2001.back.exception.BadRequestException;
import org.ajani2001.back.exception.NotFoundException;
import org.springframework.web.bind.annotation.*;

public abstract class RCRUDController<EntryClass extends BasicEntry, EntryRepresentationClass> {
    final RCRUDRepository <EntryClass, EntryRepresentationClass, Long> repository;

    public RCRUDController(RCRUDRepository<EntryClass, EntryRepresentationClass, Long> repository) {
        this.repository = repository;
    }

    @PostMapping
    EntryRepresentationClass create(@RequestBody EntryClass newEntry) {
        if(newEntry.getId() != null)
            throw new BadRequestException();
        EntryClass savedEntry = repository.save(newEntry);
        return repository.getRepresentationById(savedEntry.getId()).get();
    }

    @GetMapping("/all")
    Iterable<EntryRepresentationClass> readAll() {
        return repository.getRepresentationAll();
    }

    @GetMapping("/{id}")
    EntryRepresentationClass readById(@PathVariable Long id) {
        return repository.getRepresentationById(id).orElseThrow(NotFoundException::new);
    }

    @PutMapping
    EntryRepresentationClass updateById(@RequestBody EntryClass entry) {
        if(!repository.existsById(entry.getId()))
            throw new NotFoundException();
        EntryClass savedEntry = repository.save(entry);
        return repository.getRepresentationById(savedEntry.getId()).get();
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) {
        if(!repository.existsById(id))
            throw new NotFoundException();
        repository.deleteById(id);
    }
}
