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
    EntryClass create(@RequestBody EntryClass newEntry) {
        if(newEntry.getId() != null)
            throw new BadRequestException();
        return repository.save(newEntry);
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
    EntryClass updateById(@RequestBody EntryClass entry) {
        if(!repository.existsById(entry.getId()))
            throw new NotFoundException();
        return repository.save(entry);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) {
        if(!repository.existsById(id))
            throw new NotFoundException();
        repository.deleteById(id);
    }
}
