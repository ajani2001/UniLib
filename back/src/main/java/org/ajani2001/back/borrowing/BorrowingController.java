package org.ajani2001.back.borrowing;

import org.ajani2001.back.RCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/borrowing")
public class BorrowingController extends RCRUDController<Borrowing, BorrowingRepresentation> {
    @Autowired
    public BorrowingController(BorrowingRepository repository) {
        super(repository);
    }
}
