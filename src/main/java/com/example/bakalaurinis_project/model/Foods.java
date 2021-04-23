package com.example.bakalaurinis_project.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Foods {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String food;
    private Integer cal;
    private Double carbs;
    private Double proteins;
    private Double fats;

    public Foods(Integer id, String food, Integer cal, Double carbs, Double proteins, Double fats) {
        this.id = id;
        this.food = food;
        this.cal = cal;
        this.carbs = carbs;
        this.proteins = proteins;
        this.fats = fats;
    }

    public Foods() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoods() {
        return food;
    }

    public void setFoods(String foods) {
        this.food = foods;
    }

    public Integer getCal() {
        return cal;
    }

    public void setCal(Integer cal) {
        this.cal = cal;
    }

    public Double getCarbs() {
        return carbs;
    }

    public void setCarbs(Double carbs) {
        this.carbs = carbs;
    }

    public Double getProteins() {
        return proteins;
    }

    public void setProteins(Double proteins) {
        this.proteins = proteins;
    }

    public Double getFats() {
        return fats;
    }

    public void setFats(Double fats) {
        this.fats = fats;
    }
}
