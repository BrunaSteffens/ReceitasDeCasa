package com.example.receitasDeCasa.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "BancoReceitas";
    private static final Integer DB_VERSION = 1;
    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlUser = "create table users (user_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT, password TEXT); ";
        db.execSQL(sqlUser);

        String sqlReceita = "create table receitas (receita_id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT, rendimento INTEGER, tempo_preparo INTEGER, ingredientes TEXT, modo_preparo TEXT, categoria_id INTEGER, FOREIGN KEY (categoria_id) REFERENCES categorias (categoria_id));";
        db.execSQL(sqlReceita);

       // String sqlCategoria = "create table categorias (categoria_id INTEGER PRIMARY KEY, categoria TEXT);";
       // db.execSQL(sqlCategoria);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql_upgrade_users = "DROP TABLE IF EXISTS users";
        db.execSQL(sql_upgrade_users);

        onCreate(db);

    }
}
