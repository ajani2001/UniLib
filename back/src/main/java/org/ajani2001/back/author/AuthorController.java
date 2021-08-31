package org.ajani2001.back.author;

import org.ajani2001.back.CRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/author")
public class AuthorController extends CRUDController<Author> {
    AuthorRepository repository;

    @Autowired
    public AuthorController(AuthorRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
