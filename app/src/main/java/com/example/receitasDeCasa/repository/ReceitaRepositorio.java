package com.example.receitasDeCasa.repository;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.recyclerview.widget.SortedList;

import com.example.receitasDeCasa.model.Categoria;
import com.example.receitasDeCasa.model.Ingrediente;
import com.example.receitasDeCasa.model.ModoPreparo;
import com.example.receitasDeCasa.model.Receita;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class ReceitaRepositorio {
    private static final String TAG = "ReceitaRepositorio";
    private static ReceitaRepositorio instance;
    private Context context;
    private List<Receita> receitaList = new ArrayList<>();
    private SQLiteDatabase database;

    public ReceitaRepositorio(Context context){
        super();
        this.context = context;
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        database = databaseHelper.getWritableDatabase();
    }

    public static ReceitaRepositorio getInstance(Context context){
        if(instance == null){
            instance = new ReceitaRepositorio(context);
        }
        return instance;
    }

    public static ReceitaRepositorio getInstance(){ return instance; }

    public void addReceitaTeste(){
        Receita receita = new Receita(1, "Miojo", 1, 5, "Massas");
        addReceita(receita);

        Log.d(TAG, "addReceitaTeste: adicionada receita teste de " + receita.getTitulo());
    }

    public List<Receita> getReceitaList(){
        return receitaList;
    }

    public void addReceita(Receita receita){
        //receita_id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT, rendimento INTEGER, tempo_preparo INTEGER, ingredientes TEXT, modo_preparo TEXT, categoria_id INTEGER, FOREIGN KEY (categoria_id) REFERENCES categorias (categoria_id));";
        String sql = "INSERT INTO receitas (titulo, rendimento, tempo_preparo, categoria) values (?, ?, ?, ?);";
        Object[] args = {receita.getTitulo(), receita.getRendimento(), receita.getTempoPreparo(), receita.getCategoria()};
        database.execSQL(sql,args);
    }

    public Receita getReceita(int id){
        String sql = "SELECT receita_id FROM receitas where receita_id = ?;";
        String[] args = {""+id};
        Cursor cursor = database.rawQuery(sql, args);

        if (cursor.moveToFirst()){
            return receitaFromCursor(cursor);
        } else{
            return null;
        }
    }

    private Receita receitaFromCursor(Cursor cursor){
        Receita receita = new Receita(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getInt(2),
                cursor.getInt(3),
                cursor.getString(4));
        return receita;
    }


}
