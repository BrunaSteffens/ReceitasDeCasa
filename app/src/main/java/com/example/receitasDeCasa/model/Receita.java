package com.example.receitasDeCasa.model;

import androidx.recyclerview.widget.SortedList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

public class Receita  {
    private static final String TAG = "Receita";

    private int id;
    private String titulo;
    private int rendimento;
    private int tempoPreparo;
    private String categoria;
    private static int sequencia=1;

    public Receita(int id, String titulo, int rendimento, int tempoPreparo, String categoria) {
        this.id=sequencia++;
        this.titulo = titulo;
        this.rendimento = rendimento;
        this.tempoPreparo = tempoPreparo;
        this.categoria = categoria;
    }

    public Receita(String titulo, int rendimento, int tempoPreparo, String categoria) {
        this.titulo = titulo;
        this.rendimento = rendimento;
        this.tempoPreparo = tempoPreparo;
        this.categoria = categoria;
    }

    public Receita() {
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
