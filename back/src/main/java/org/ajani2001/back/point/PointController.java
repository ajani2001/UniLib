package org.ajani2001.back.point;

import org.ajani2001.back.CRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/point")
public class PointController extends CRUDController<Point> {
    @Autowired
    public PointController(PointRepository repository) {
        super(repository);
    }
}
