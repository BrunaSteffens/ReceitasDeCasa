package com.example.receitasDeCasa.repository;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.receitasDeCasa.model.Ingrediente;
import com.example.receitasDeCasa.model.ModoPreparo;
import com.example.receitasDeCasa.model.Receita;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class ModoPreparoRepositorio {
    private static final String TAG = "ModoPreparoRepositorio";
    private static ModoPreparoRepositorio instance;
    private Context context;
    private List<ModoPreparo>modoPreparoList = new ArrayList<>();
    private SQLiteDatabase database;

    public ModoPreparoRepositorio(Context context){
        super();
        this.context = context;
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        database = databaseHelper.getWritableDatabase();
    }

    public static ModoPreparoRepositorio getInstance(Context context){
        if(instance == null){
            instance = new ModoPreparoRepositorio(context);
        }
        return instance;
    }

    public static ModoPreparoRepositorio getInstance(){ return instance; }

    public void addModoPreparo(ModoPreparo modoPreparo){
        //(String passo, int receita_id)
        //(modo_preparo INTEGER PRIMARY KEY AUTOINCREMENT, passo TEXT, receita_id INTEGER, FOREIGN KEY (receita_id) REFERENCES receitas (receita_id));";
        String sql = "INSERT INTO modo_preparo (passo, receita_id) values (?, ?);";
        Object[] args = {modoPreparo.getPasso(), modoPreparo.getReceita_id()};
        database.execSQL(sql);

    }

    public ModoPreparo getModoPreparo(int id){
        String sql = "SELECT * FROM modo_preparo where receita_id = ?;";
        String[] args = {""+id};
        Cursor cursor = database.rawQuery(sql, args);

        if (cursor.moveToFirst()){
            return modoPreparoFromCursor(cursor);
        } else{
            return null;
        }
    }

    public void addModoPreparoTeste(){
        ModoPreparo m1 = new ModoPreparo("Ferva 450ml de água", 1);
        ModoPreparo m2 = new ModoPreparo("Junte o macarrão e cozinhe por 3 minutos", 1);
        ModoPreparo m3 = new ModoPreparo("Retire do fogo e misture o tempero", 1);
        addModoPreparo(m1);
        addModoPreparo(m2);
        addModoPreparo(m3);

        Log.d(TAG, "addModoPreparo: adicionad modo preparo da receita teste");
    }

    private ModoPreparo modoPreparoFromCursor(Cursor cursor){
        ModoPreparo modoPreparo = new ModoPreparo(
                cursor.getString(1),
                cursor.getInt(2));
        return  modoPreparo;
    }
}
