package com.example.bakalaurinis_project.resource;

import com.example.bakalaurinis_project.model.SleepRecordsForm;
import com.example.bakalaurinis_project.model.Sleeprecords;
import com.example.bakalaurinis_project.repository.SleepRecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/sleep")
public class SleepRecordsResource {

    @Autowired
    SleepRecordsRepository sleepRecordsRepository;

    @GetMapping(value = "/all")
    public List<Sleeprecords> getAll() {
        List<Sleeprecords> sleepRecords = sleepRecordsRepository.findAll();
        return sleepRecords;
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map createSleepRecord(@RequestBody SleepRecordsForm form) {
        Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Sleeprecords sleeprecords = new Sleeprecords(form.getUserid(), form.getDuration(),
                form.getQuality(), date);
        sleepRecordsRepository.save(sleeprecords);
        return Collections.singletonMap("response", "Miego įrašas pridėtas");
    }
}
