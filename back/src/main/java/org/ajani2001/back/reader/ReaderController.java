package org.ajani2001.back.reader;

import org.ajani2001.back.CRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Map;

@RestController
@RequestMapping("/api/reader")
public class ReaderController extends CRUDController<Reader> {
    ReaderRepository repository;

    @Autowired
    public ReaderController(ReaderRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @GetMapping("/filter")
    Iterable<Reader> readFiltered(@RequestParam Map<String, String> params) {
        Integer pointId = params.get("point_id") == null ? null : Integer.parseInt(params.get("point_id"));
        Integer chairId = params.get("chair_id") == null ? null : Integer.parseInt(params.get("chair_id"));
        Integer facultyId = params.get("faculty_id") == null ? null : Integer.parseInt(params.get("faculty_id"));
        Integer year = params.get("year") == null ? null : Integer.parseInt(params.get("year"));
        Integer groupId = params.get("group_id") == null ? null : Integer.parseInt(params.get("group_id"));
        Boolean isStudent = params.get("category") == null ? null : params.get("category").equals("student");
        Boolean isProfessor = params.get("category") == null ? null : params.get("category").equals("professor");
        Boolean isEmployee = params.get("category") == null ? null : params.get("category").equals("employee");
        Boolean isDebtor = params.get("is_debtor") == null ? null : Boolean.parseBoolean(params.get("is_debtor"));
        Boolean isMaliciousDebtor = params.get("is_malicious_debtor") == null ? null : Boolean.parseBoolean(params.get("is_malicious_debtor"));
        Boolean isBanned = params.get("is_banned") == null ? null : Boolean.parseBoolean(params.get("is_banned"));
        Boolean isBannedForALongTime = params.get("is_banned_for_a_long_time") == null ? null : Boolean.parseBoolean(params.get("is_banned_for_a_long_time"));
        Date acceptedSince = params.get("accepted_since") == null ? null : Date.valueOf(params.get("accepted_since"));
        Date retiredSince = params.get("retired_since") == null ? null : Date.valueOf(params.get("retired_since"));
        return repository.getFiltered(pointId, chairId, facultyId,year,groupId,isStudent,isProfessor,isEmployee,isDebtor,isMaliciousDebtor,isBanned,isBannedForALongTime, acceptedSince., retiredSince);
    }
}
