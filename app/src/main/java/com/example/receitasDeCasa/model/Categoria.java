package com.example.receitasDeCasa.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Categoria {

    CARNES("Carnes", 1),
    AVES("Aves", 2),
    PEIXES_FRUTOS_DO_MAR("Peixes e frutos do mar", 3),
    VEGETARIANAS("Vegetarianas", 4),
    VEGANAS("Veganas", 5),
    MASSAS("Massas", 6),
    SALADAS_MOLHOS_ACOMPANHAMENTOS("Saladas, molhos e acompanhamentos", 7),
    SOPAS("Sopas", 8),
    DOCES_SOBREMESAS("Doces e sobremesas", 9),
    LANCHES("Lanches", 10),
    BEBIDAS("Bebidas", 11);

    final String nomeCategoria;
    final int categoria_id;

    Categoria (String nomeCategoria, int categoria_id){
        this.nomeCategoria = nomeCategoria;
        this.categoria_id = categoria_id;
    }

}





/*public class Categoria {
    private String categoria;
    public static final List<String> categorias = new ArrayList<String>(Arrays.asList (new String[]{"Aves", "Carnes"}));
    public static final String CATEGORIA_AVE = "Aves";


    private Categoria() {    }

    private Categoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public List<Categoria> getCategorias (){
        List<Categoria> categorias = new ArrayList<>();
        categorias.add(new Categoria("Aves"));
        categorias.add(new Categoria("Carnes"));
        categorias.add(new Categoria("Peixes e frutos do mar"));
        categorias.add(new Categoria("Vegetarianas"));
        categorias.add(new Categoria("Veganas"));
        categorias.add(new Categoria("Massas"));
        categorias.add(new Categoria("Saladas"));
        categorias.add(new Categoria("Sopas"));
        categorias.add(new Categoria("Doces e Sobremesas"));
        categorias.add(new Categoria("Lanches"));
        categorias.add(new Categoria("Bebidas"));

        return categorias;
    }
}
*/