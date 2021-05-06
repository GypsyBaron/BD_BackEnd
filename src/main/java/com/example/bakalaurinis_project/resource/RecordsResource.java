package com.example.bakalaurinis_project.resource;


import com.example.bakalaurinis_project.model.*;
import com.example.bakalaurinis_project.repository.FoodsRepository;
import com.example.bakalaurinis_project.repository.RecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping(value = "/records")
public class RecordsResource {

    @Autowired
    RecordsRepository recordsRepository;
    @Autowired
    FoodsRepository foodsRepository;

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

    @PostMapping(value = "/today", produces = MediaType.APPLICATION_JSON_VALUE)
    public TodayForm getTodayFood(@RequestBody IdForm idForm) {
        Integer calories = 0;
        Double carbs = 0.0;
        Double proteins = 0.0;
        Double fats = 0.0;
        Optional<Foods> foods;
        Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        List<Records> records = recordsRepository.findRecordsByDateAndUserid(date, idForm.getId());

        for (Records record : records) {
            foods = foodsRepository.findById(record.getFoodid());
            calories += foods.get().getCal();
            carbs += foods.get().getCarbs();
            proteins += foods.get().getProteins();
            fats += foods.get().getFats();
        }

        return new TodayForm(calories, carbs, proteins, fats);
    }
}
