package org.ajani2001.back.book;

import org.ajani2001.back.RCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book")
public class BookController extends RCRUDController<Book, BookRepresentation> {
    @Autowired
    public BookController(BookRepository repository) {
        super(repository);
    }
}
