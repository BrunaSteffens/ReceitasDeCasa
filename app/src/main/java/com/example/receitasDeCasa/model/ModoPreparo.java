package com.example.receitasDeCasa.model;

public class ModoPreparo {
    private static final String TAG = "ModoPreparo";
    private String passo;

    public ModoPreparo(String passo) {
        this.passo = passo;
    }

    public String getPasso() {
        return passo;
    }

    public void setPasso(String passo) {
        this.passo = passo;
    }
}
