package com.example.bakalaurinis_project.model;

public class TodayForm {
    private Integer cal;
    private Double carbs;
    private Double proteins;
    private Double fats;

    public TodayForm(Integer cal, Double carbs, Double proteins, Double fats) {
        this.cal = cal;
        this.carbs = carbs;
        this.proteins = proteins;
        this.fats = fats;
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
