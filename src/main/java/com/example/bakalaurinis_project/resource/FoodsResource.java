package com.example.bakalaurinis_project.resource;

import com.example.bakalaurinis_project.model.Foods;
import com.example.bakalaurinis_project.model.FoodsForm;
import com.example.bakalaurinis_project.model.TestString;
import com.example.bakalaurinis_project.repository.FoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

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

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map createNewFood(@RequestBody FoodsForm foodsForm) {

        if (foodsRepository.existsFoodsByFood(foodsForm.getFood())) {
            return Collections.singletonMap("response", "Maistas tokiu pavadinimu jau egzistuoja");
        }

        if (foodsForm.getFood().length() <= 4) {
            return Collections.singletonMap("response", "Maisto pavadinimas turi bti bent iš 4 simbolių");
        }

        if (foodsForm.getCal() < (foodsForm.getCarbs() * 4) + (foodsForm.getProteins()) * 4 + (foodsForm.getFats() * 9)) {
            return Collections.singletonMap("response",
                    "Angliavandeniai, Baltymai ir Riebalai negali viršyti kalorijų kiekio");
        }

        Foods foods = new Foods(foodsRepository.findTopByOrderByIdDesc().getId() + 1, foodsForm.getFood(),
                foodsForm.getCal(), foodsForm.getCarbs(), foodsForm.getProteins(), foodsForm.getFats());
        foodsRepository.save(foods);
        return Collections.singletonMap("response", "Maistas pridėtas");
    }
}
