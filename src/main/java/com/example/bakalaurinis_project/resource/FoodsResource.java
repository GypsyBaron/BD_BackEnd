package com.example.bakalaurinis_project.resource;

import com.example.bakalaurinis_project.model.Foods;
import com.example.bakalaurinis_project.model.TestString;
import com.example.bakalaurinis_project.repository.FoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/foods")
public class FoodsResource {

    @Autowired
    FoodsRepository foodsRepository;

    @GetMapping(value = "/all")
    public List<Foods> getAll() {
        return foodsRepository.findAll();
    }

    @PostMapping(value = "/title", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Foods> getByTitle(@RequestBody TestString foodtitle) {
        return foodsRepository.findFoodsByFoodContaining(foodtitle.getFoodtitle());
    }
}
