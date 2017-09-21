package com.example.marcelo.recetasdecocina.model;

import java.util.List;

/**
 * Created by Marcelo on 14/09/2017.
 */

public class ResultResponse {

    private List<Receta> recipes;

    public List<Receta> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Receta> recipes) {
        this.recipes = recipes;
    }
}
