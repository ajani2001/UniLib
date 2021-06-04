package org.ajani2001.back.edition;

import org.ajani2001.back.RCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/edition")
public class EditionController extends RCRUDController<Edition, EditionRepresentation> {
    EditionRepository repository;

    @Autowired
    public EditionController(EditionRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @GetMapping("/top20")
    Iterable<EditionStats> readTop20(@RequestParam Map<String, String> params) {
        Long pointId = params.get("point_id") == null ? null : Long.parseLong(params.get("point_id"));
        Long facultyId = params.get("faculty_id") == null ? null : Long.parseLong(params.get("faculty_id"));
        return repository.getTop20(pointId, facultyId);
    }
}
