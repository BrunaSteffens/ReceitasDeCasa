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

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql_upgrade_users = "DROP TABLE IF EXISTS users";
        db.execSQL(sql_upgrade_users);

        onCreate(db);

    }
}
