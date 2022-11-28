package com.example.receitasDeCasa.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.receitasDeCasa.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.receitasDeCasa.model.Receita;

import java.util.List;

public class ReceitaAdapter extends RecyclerView.Adapter {
    private List<Receita> dados;
    private static final String TAG = "ReceitaAdapter";

    public ReceitaAdapter(List<Receita> dados){ this.dados = dados;}

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: Criando VH das receitas");
        View layoutVH = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_lista_receitas, parent, false);
        return new ReceitaViewHolder(layoutVH);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: inclusão dos dados da receita na lista");
        Receita objeto = dados.get(position);


    }

    @Override
    public int getItemCount() {
        return dados.size();
    }
}

class ReceitaViewHolder extends RecyclerView.ViewHolder{
    public View view;

    public ReceitaViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView;
    }
}