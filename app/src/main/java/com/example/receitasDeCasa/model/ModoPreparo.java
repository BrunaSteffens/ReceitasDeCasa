package com.example.receitasDeCasa.model;

public class ModoPreparo implements Comparable<ModoPreparo> {
    private static final String TAG = "ModoPreparo";
    private String passo;
    private Integer ordem=0;

    public ModoPreparo(String passo) {
        this.passo = passo;
        this.ordem = ordem+1;
    }

    public String getPasso() {
        return passo;
    }

    public void setPasso(String passo) {
        this.passo = passo;
    }

      @Override
    public int compareTo(ModoPreparo o) {
        return this.ordem.compareTo(o.ordem);
    }


}
