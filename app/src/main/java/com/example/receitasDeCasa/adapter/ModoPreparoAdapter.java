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

public class ModoPreparoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<ModoPreparo> modoDePreparo;

    public ModoPreparoAdapter(List<ModoPreparo> dados) { this.modoDePreparo = dados;}

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vhModoPreparo = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_modo_preparo, parent, false);
        return new ModoPreparoViewHolder(vhModoPreparo);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ModoPreparo passo = modoDePreparo.get(position);
        ((TextView) holder.itemView.findViewById(R.id.modoPreparo)).setText(passo.getPasso());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

class ModoPreparoViewHolder extends RecyclerView.ViewHolder{
    public View view;

    public ModoPreparoViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView;
    }
}
