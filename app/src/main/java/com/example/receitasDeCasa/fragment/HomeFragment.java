package com.example.receitasDeCasa.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.receitasDeCasa.R;
import com.example.receitasDeCasa.adapter.ListaReceitasAdapter;
import com.example.receitasDeCasa.model.Receita;
import com.example.receitasDeCasa.repository.ReceitaRepositorio;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private ArrayList<Receita> receitaList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home, container, false);


        //new ReceitaRepositorio(getView().getContext()).addReceitaTeste();
        //está apontando para objeto nulo, verificar
        //testar se está aparecendo o recyclerview da lista de receitas



        RecyclerView rv = view.findViewById(R.id.rv_lista_receitas);
        ListaReceitasAdapter adapter = new ListaReceitasAdapter(new ReceitaRepositorio(view.getContext()).getReceitaList());
        rv.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(view.getContext());
        rv.setLayoutManager(llm);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}