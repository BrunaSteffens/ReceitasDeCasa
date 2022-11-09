package com.example.receitasDeCasa.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.receitasDeCasa.R;
import com.example.receitasDeCasa.model.Ingrediente;
import com.example.receitasDeCasa.model.ModoPreparo;

import java.util.List;

public class IngredienteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<Ingrediente> listaIngredientes;

    public IngredienteAdapter (List<Ingrediente> ingredientes){ this.listaIngredientes = ingredientes; }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vhIngredientes = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_ingredientes, parent, false);
        return new IngredienteViewHolder(vhIngredientes);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Ingrediente ingrediente = listaIngredientes.get(position);
        ((TextView) holder.itemView.findViewById(R.id.vh_ingrediente)).setText(ingrediente.getIngrediente());

    }

    @Override
    public int getItemCount() {
        return listaIngredientes.size();
    }
}

class IngredienteViewHolder extends RecyclerView.ViewHolder{
    public View view;

    public IngredienteViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView;
    }
}