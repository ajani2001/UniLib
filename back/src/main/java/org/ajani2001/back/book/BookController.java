package org.ajani2001.back.book;

import org.ajani2001.back.RCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/book")
public class BookController extends RCRUDController<Book, BookRepresentation> {
    BookRepository repository;

    @Autowired
    public BookController(BookRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @GetMapping("/flow")
    Iterable<BookRepresentation> readFlow(@RequestParam Map<String, String> params) {
        Long pointId = params.get("point_id") == null ? null : Long.parseLong(params.get("point_id"));
        Long authorId = params.get("author_id") == null ? null : Long.parseLong(params.get("author_id"));
        Integer issueYear = params.get("issue_year") == null ? null : Integer.parseInt(params.get("issue_year"));
        Integer supplyYear = params.get("supply_year") == null ? null : Integer.parseInt(params.get("supply_year"));
        return repository.getFlow(pointId, authorId, issueYear, supplyYear);
    }

    @GetMapping("/ordered")
    Iterable<BookRepresentation> readOrdered(@RequestParam String sinceDate) {
        return repository.getOrdered(sinceDate);
    }
}
