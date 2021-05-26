package org.ajani2001.back.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/group")
public class GroupController {

    @Autowired
    private GroupRepository repository;

    @PostMapping
    Group create(@RequestBody Group newGroup) {
        return repository.save(newGroup);
    }

    @GetMapping
    Iterable<GroupRepresentation> readAll() {
        return repository.findAllRepresentation();
    }

    @GetMapping("/{id}")
    Group readById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PutMapping("/{id}")
    Group updateById(@RequestBody Group group, @PathVariable Long id) {
        if(!group.getId().equals(id))
            throw new RuntimeException();

        return repository.save(group);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
