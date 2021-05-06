package com.example.bakalaurinis_project.resource;

import com.example.bakalaurinis_project.model.*;
import com.example.bakalaurinis_project.repository.RecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/recipes")
public class RecipesResource {

    @Autowired
    RecipesRepository recipesRepository;

    @GetMapping(value = "/all")
    public List<Recipes> getAll() {
        List<Recipes> recipes = recipesRepository.findAll();
        return recipes;
    }

    @PostMapping(value = "/title", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Recipes> getByTitle(@RequestBody RecipeTitle recipeTitle) {
        return recipesRepository.findRecipesByNameContaining(recipeTitle.getRecipetitle());
    }
}
