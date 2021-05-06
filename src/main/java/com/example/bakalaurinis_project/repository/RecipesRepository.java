package com.example.bakalaurinis_project.repository;

import com.example.bakalaurinis_project.model.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipesRepository extends JpaRepository<Recipes, Integer> {
    List<Recipes> findRecipesByNameContaining(String title);
}
