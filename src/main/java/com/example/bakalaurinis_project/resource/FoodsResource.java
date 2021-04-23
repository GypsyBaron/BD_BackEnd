package com.example.bakalaurinis_project.resource;

import com.example.bakalaurinis_project.model.Foods;
import com.example.bakalaurinis_project.repository.FoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/foods")
public class FoodsResource {

    @Autowired
    FoodsRepository foodsRepository;

    @GetMapping(value = "/all")
    public List<Foods> getAll() {
        List<Foods> foods = foodsRepository.findAll();
        return foods;
    }

    @GetMapping(value = {"/title/{title}"})
    public List<Foods> getByTitle(@PathVariable String title) {
        List<Foods> foods = foodsRepository.findFoodsByFoodContaining(title);
        return foods;
    }
}
