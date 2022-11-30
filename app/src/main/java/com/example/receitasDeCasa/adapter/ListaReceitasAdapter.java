package com.example.receitasDeCasa.adapter;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.receitasDeCasa.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.receitasDeCasa.model.Receita;
import com.squareup.picasso.Picasso;
import java.util.List;

public class ListaReceitasAdapter extends RecyclerView.Adapter {
    private List<Receita> receitaList;
    private static final String TAG = "ListaReceitasAdapter";

    public ListaReceitasAdapter(List<Receita> receitaList) {
        this.receitaList = receitaList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutVH = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_lista_receitas, parent, false);
        return new ListaReceitasViewHolder(layoutVH);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Receita receita = receitaList.get(position);

        /*Picasso.get().load(
                receita.getFotoUrl()).into(
                ((ImageView)((PhotosViewHolder) holder).view.findViewById(R.id.foto_receita))
        ); */
        ((TextView) holder.itemView.findViewById(R.id.nome_receita)).setText(receita.getTitulo());
        ((TextView) holder.itemView.findViewById(R.id.categoria)).setText(receita.getCategoria());
        ((TextView) holder.itemView.findViewById(R.id.tempo_preparo)).setText(receita.getTempoPreparo()+"");
        ((TextView) holder.itemView.findViewById(R.id.rendimento)).setText(receita.getRendimento()+"");

    }

    @Override
    public int getItemCount() {
        return receitaList.size();
    }
}

class ListaReceitasViewHolder extends RecyclerView.ViewHolder {
    public View view;

    public ListaReceitasViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView;

    }
}