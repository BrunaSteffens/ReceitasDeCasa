package com.example.receitasDeCasa.model;

import androidx.recyclerview.widget.SortedList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

public class Receita  {
    private static final String TAG = "Recipe";

    private String titulo;
    private List<Ingrediente> ingredientes;
    private SortedSet<ModoPreparo> modoPreparo;
    private int rendimento;
    private int tempoPreparo;
    private int categoria_id;

    public Receita(String titulo, List<Ingrediente> ingredientes, SortedSet<ModoPreparo> modoPreparo, int rendimento, int tempoPreparo, int categoria_id) {
        this.titulo = titulo;
        this.ingredientes = ingredientes;
        this.modoPreparo = modoPreparo;
        this.rendimento = rendimento;
        this.tempoPreparo = tempoPreparo;
        this.categoria_id = categoria_id;
    }

    public Receita() {
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

    public SortedSet<ModoPreparo> getModoPreparo() {
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

    public int getCategoria() {
        return categoria_id;
    }

    public void setCategoria(int categoria_id) {
        this.categoria_id = categoria_id;
    }
}
