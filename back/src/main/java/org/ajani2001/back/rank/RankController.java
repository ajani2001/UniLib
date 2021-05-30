package org.ajani2001.back.rank;

import org.ajani2001.back.CRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rank")
public class RankController extends CRUDController<Rank> {
    @Autowired
    public RankController(RankRepository repository) {
        super(repository);
    }
}
