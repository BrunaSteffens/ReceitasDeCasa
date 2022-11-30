package com.example.receitasDeCasa.model;

public class ModoPreparo implements Comparable<ModoPreparo> {
    private static final String TAG = "ModoPreparo";
    private String passo;
    private int receita_id;
    private Integer ordem=0;

    public ModoPreparo(String passo, int receita_id) {
        this.passo = passo;
        this.receita_id = receita_id;
        this.ordem = ordem+1;
    }

    public String getPasso() {
        return passo;
    }

    public int getReceita_id() { return receita_id; }

    public void setPasso(String passo, int receita_id) {
        this.passo = passo;
        this.receita_id = receita_id;
    }

      @Override
    public int compareTo(ModoPreparo o) {
        return this.ordem.compareTo(o.ordem);
    }


}
