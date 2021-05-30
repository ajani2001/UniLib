package org.ajani2001.back.penalty.ban;

import org.ajani2001.back.RCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ban")
public class BanController extends RCRUDController<Ban, BanRepresentation> {
    @Autowired
    public BanController(BanRepository repository) {
        super(repository);
    }
}
