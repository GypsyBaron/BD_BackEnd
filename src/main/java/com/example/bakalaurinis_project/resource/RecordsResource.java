package com.example.bakalaurinis_project.resource;


import com.example.bakalaurinis_project.model.Records;
import com.example.bakalaurinis_project.model.RecordsForm;
import com.example.bakalaurinis_project.repository.RecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/records")
public class RecordsResource {

    @Autowired
    RecordsRepository recordsRepository;

    @GetMapping(value = "/all")
    public List<Records> getAll() {
        return recordsRepository.findAll();
    }

    @PostMapping(value ="/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map createRecord(@RequestBody RecordsForm recordsForm) {
        Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Records records = new Records(recordsForm.getUserid(), recordsForm.getFoodid(),
                recordsForm.getType(), date);
        recordsRepository.save(records);
        return Collections.singletonMap("response", "Maistas pridėtas");
    }
}
