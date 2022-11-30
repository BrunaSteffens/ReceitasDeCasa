package com.example.receitasDeCasa.model;

import java.util.List;

public class Ingrediente {
    private static final String TAG = "Ingrediente";
    private String ingrediente;
    private int receita_id;

    public Ingrediente(String ingrediente, int receita_id) {
        this.ingrediente = ingrediente;
        this.receita_id = receita_id;
    }

    public Ingrediente() {    }

    public String getIngrediente() {
        return ingrediente;
    }

    public int getReceita_id() { return receita_id; }

    public void setIngrediente(String ingrediente, int receita_id) {
        this.ingrediente = ingrediente;
        this.receita_id = receita_id;

    }

}
