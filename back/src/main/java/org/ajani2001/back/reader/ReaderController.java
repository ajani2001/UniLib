package org.ajani2001.back.reader;

import org.ajani2001.back.CRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reader")
public class ReaderController extends CRUDController<Reader> {
    @Autowired
    public ReaderController(ReaderRepository repository) {
        super(repository);
    }
}
