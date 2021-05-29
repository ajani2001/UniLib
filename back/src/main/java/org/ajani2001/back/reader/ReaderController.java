package org.ajani2001.back.reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reader")
public class ReaderController {

    @Autowired
    private ReaderRepository repository;

    @PostMapping
    Reader create(@RequestBody Reader newReader) {
        return repository.save(newReader);
    }

    @GetMapping
    Iterable<Reader> readAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Reader readById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PutMapping("/{id}")
    Reader updateById(@RequestBody Reader reader, @PathVariable Long id) {
        if(!reader.getId().equals(id))
            throw new RuntimeException();

        return repository.save(reader);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
