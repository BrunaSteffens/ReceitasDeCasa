package com.example.receitasDeCasa.repository;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.receitasDeCasa.model.Ingrediente;
import com.example.receitasDeCasa.model.ModoPreparo;

import java.util.ArrayList;
import java.util.List;

public class IngredienteRepositorio {
    private static final String TAG = "IngredienteRepositorio";
    private static IngredienteRepositorio instance;
    private Context context;
    private List<Ingrediente> ingredienteList = new ArrayList<>();
    private SQLiteDatabase database;

    public IngredienteRepositorio(Context context){
        super();
        this.context = context;
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        database = databaseHelper.getWritableDatabase();
    }

    public static IngredienteRepositorio getInstance(Context context){
        if(instance == null){
            instance = new IngredienteRepositorio(context);
        }
        return instance;
    }

    public static IngredienteRepositorio getInstance(){ return instance; }

    public void addIngrediente(Ingrediente ingrediente){
        //(String ingrediente, int receita_id)
        //ingrediente TEXT, receita_id INTEGER, FOREIGN KEY (receita_id) REFERENCES receitas (receita_id));";
        String sql = "INSERT INTO ingredientes (ingrediente, receita_id) values (?, ?);";
        Object[] args = {ingrediente.getIngrediente(), ingrediente.getReceita_id()};
        database.execSQL(sql, args);

    }

    public Ingrediente getIngrediente(int id){
        String sql = "SELECT * FROM ingredientes where receita_id = ?;";
        String[] args = {"" +id};
        Cursor cursor = database.rawQuery(sql, args);

        if (cursor.moveToFirst()){
            return ingredienteFromCursor(cursor);
        } else{
            return null;
        }
    }

    public void addIngredienteTeste(){
        Ingrediente i = new Ingrediente("1 Pacote de miojo", 1);
        addIngrediente(i);
        Log.d(TAG, "addMIngredienteTeste: adicionado o ingrediente teste");
    }

    private Ingrediente ingredienteFromCursor(Cursor cursor){
        Ingrediente ingrediente = new Ingrediente(
                cursor.getString(1),
                cursor.getInt(2));
        return  ingrediente;
    }
}
