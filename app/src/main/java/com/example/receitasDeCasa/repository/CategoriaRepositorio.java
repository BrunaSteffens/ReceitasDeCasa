package com.example.receitasDeCasa.repository;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.receitasDeCasa.model.Categoria;
import com.example.receitasDeCasa.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class CategoriaRepositorio {
    private static final String TAG = "CategoriaRepositorio";
    private static CategoriaRepositorio instance;
    private Context contexto;
    private SQLiteDatabase database;

    public CategoriaRepositorio(Context contexto) {
        super();
        this.contexto = contexto;
        DatabaseHelper dataBaseHelper = new DatabaseHelper(contexto);
        database = dataBaseHelper.getWritableDatabase();
    }

    public static CategoriaRepositorio getInstance(Context contexto) {
        if (instance == null) {
            instance = new CategoriaRepositorio(contexto);
        }
        return instance;
    }

    public static CategoriaRepositorio getInstance() {
        return instance;
    }
    
   /* public void addCategoria(){
        String sql = "insert into categorias (categoria_id, categoria) values (1, 'Carnes');";
        database.execSQL(sql);
        Log.d(TAG, "addCategoria: Categorias inseridas no banco");
    } */


}
