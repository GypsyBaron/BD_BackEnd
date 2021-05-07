package com.example.bakalaurinis_project.model;

public class RecipeForm {

    private String name;
    private String url;

    public RecipeForm(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public RecipeForm() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
