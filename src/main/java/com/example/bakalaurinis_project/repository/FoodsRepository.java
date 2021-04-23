package com.example.bakalaurinis_project.repository;

import com.example.bakalaurinis_project.model.Foods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodsRepository extends JpaRepository<Foods, Integer> {
    List<Foods> findFoodsByFoodContaining(String title);
}
