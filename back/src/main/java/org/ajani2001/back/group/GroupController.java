package org.ajani2001.back.group;

import org.ajani2001.back.RCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/group")
public class GroupController extends RCRUDController<Group, GroupRepresentation> {
    @Autowired
    public GroupController(GroupRepository repository) {
        super(repository);
    }
}
