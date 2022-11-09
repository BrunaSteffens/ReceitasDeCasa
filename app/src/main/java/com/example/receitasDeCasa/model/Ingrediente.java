package com.example.receitasDeCasa.model;

import java.util.List;

public class Ingrediente {
    private static final String TAG = "Ingrediente";
    private String ingrediente;

    public Ingrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

}
