package com.example.receitasDeCasa.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.receitasDeCasa.R;
import com.example.receitasDeCasa.model.Ingrediente;
import com.example.receitasDeCasa.model.Receita;


public class AddReceitaFragment extends Fragment {

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private EditText popupIngrediente, popupModoPreparo;
    private Button salvar, cancelar, adicionarModoPreparo, cancelarModoPreparo;
    private Spinner categoria;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }

        //PROXIMOS PASSOS:
        //CONFIGURAR O RECYCLER VIEW DOS INGREDIENTES E DO MODO DE PREPARO PARA INCLUIR OS NOVOS ITENS CONFORME ADICIONAR
        //DESCOBRIR COMO SALVAR AS MULTIPLAS ENTRADAS NO BANCO (VARIOS PASSOS E VARIOS INGREDIENTES)
        //SALVAR A RECEITA NO BANCO DE DADOS


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_add_receita, container, false);

        ImageButton addIngrediente = (ImageButton) view.findViewById(R.id.cad_rec_add_ingrediente);
        Button confirmar = (Button) view.findViewById(R.id.add_receita_confirmar);
        ImageButton addPreparo = (ImageButton) view.findViewById(R.id.cad_rec_add_modopreparo);


        Spinner categoria = (Spinner) view.findViewById(R.id.spinner_categoria);
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.categoria, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categoria.setAdapter(spinnerAdapter);

        //usar .setSelection com o spinner para receber a informação


        addIngrediente.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        criarIngredientePopup();

                    }
                }
        );

        addPreparo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        criarModoPreparoPopup();

                    }
                }
        );

        confirmar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Receita receita = new Receita();
                        receita.setTitulo(((TextView) v.findViewById(R.id.cad_rec_titulo)).getText().toString());
                        receita.setRendimento(Integer.parseInt(((TextView) v.findViewById(R.id.cad_rec_rendimento)).getText().toString()));
                        receita.setTempoPreparo(Integer.parseInt(((TextView) v.findViewById(R.id.cad_rec_tempo_prep)).getText().toString()));
                        receita.setCategoria(categoria.getSelectedItem().toString());
                    }
                }


        );

        return view;
    }

    public void criarIngredientePopup(){
        dialogBuilder = new AlertDialog.Builder(getContext());
        final View ingrediente_popup = getLayoutInflater().inflate(R.layout.popup_ingrediente, null);
        popupIngrediente = (EditText) ingrediente_popup.findViewById(R.id.ingrediente);

        salvar = (Button) ingrediente_popup.findViewById(R.id.salvar);
        cancelar = (Button) ingrediente_popup.findViewById(R.id.cancelar);

        dialogBuilder.setView(ingrediente_popup);
        dialog = dialogBuilder.create();
        dialog.show();

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //salvar o ingrediente
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


    }

    //método para adicionar passo a passo do preparo, via pop up
    public void criarModoPreparoPopup(){
        dialogBuilder = new AlertDialog.Builder(getContext());
        final View modoPreparo_popup = getLayoutInflater().inflate(R.layout.popup_modo_preparo, null);
        popupModoPreparo = (EditText) modoPreparo_popup.findViewById(R.id.passo);

        adicionarModoPreparo = (Button) modoPreparo_popup.findViewById(R.id.adicionar_preparo);
        cancelarModoPreparo = (Button) modoPreparo_popup.findViewById(R.id.cancelar_preparo);

        dialogBuilder.setView(modoPreparo_popup);
        dialog = dialogBuilder.create();
        dialog.show();

        //confirmar inclusão do novo passo
        adicionarModoPreparo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //adicionar novo passo
            }
        });

        //cancelar a inclusão do novo passo
        cancelarModoPreparo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


    }


}