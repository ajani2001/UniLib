package org.ajani2001.back.publishing;

import org.ajani2001.back.CRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/publishing")
public class PublishingController extends CRUDController<Publishing> {
    @Autowired
    public PublishingController(PublishingRepository repository) {
        super(repository);
    }
}
