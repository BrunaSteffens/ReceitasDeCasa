package com.example.receitasDeCasa.model;

import java.util.ArrayList;
import java.util.List;

public class Receita {
    private static final String TAG = "Recipe";
    private String titulo;
    private List<Ingrediente> ingredientes;
    private List<ModoPreparo> modoPreparo;
    private int rendimento;
    private int tempoPreparo;
    private Categoria categoria;

    public Receita(String titulo, List<Ingrediente> ingredientes, List<ModoPreparo> modoPreparo, int rendimento, int tempoPreparo, Categoria categoria) {
        this.titulo = titulo;
        this.ingredientes = ingredientes;
        this.modoPreparo = modoPreparo;
        this.rendimento = rendimento;
        this.tempoPreparo = tempoPreparo;
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
    }

    public List<ModoPreparo> getModoPreparo() {
        return modoPreparo;
    }

    public void setModoPreparo(ModoPreparo passo) {
        modoPreparo.add(passo);
    }

    public int getRendimento() {
        return rendimento;
    }

    public void setRendimento(int rendimento) {
        this.rendimento = rendimento;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(int tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
