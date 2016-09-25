package com.herprogramacion.moviesathome.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.provider.BaseColumns;


import com.herprogramacion.moviesathome.sqlite.ContratoPelicula.Clientes;
import com.herprogramacion.moviesathome.sqlite.ContratoPelicula.Peliculas;
import com.herprogramacion.moviesathome.sqlite.ContratoPelicula.Pedidos;


/**
 * Created by lds on 22/09/2016.
 */
public class BaseDatosPelicula extends SQLiteOpenHelper {


    private static final String NOMBRE_BASE_DATOS = "pedidoPelicula.db";

    private static final int VERSION_ACTUAL = 1;

    private final Context contexto;

    interface Tablas {
        String CLIENTE = "cliente";
        String PELICULA = "pelicula";
        String PEDIDO = "pedido";
    }

    interface Referencias {

        String ID_PEDIDO = String.format("REFERENCES %s(%s) ON DELETE CASCADE",
                Tablas.PEDIDO, Pedidos.ID);

        String ID_PELICULA = String.format("REFERENCES %s(%s)",
                Tablas.PELICULA, Peliculas.ID);

        String ID_CLIENTE = String.format("REFERENCES %s(%s)",
                Tablas.CLIENTE, Clientes.ID);
    }

    public BaseDatosPelicula(Context contexto) {
        super(contexto, NOMBRE_BASE_DATOS, null, VERSION_ACTUAL);
        this.contexto = contexto;
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                db.setForeignKeyConstraintsEnabled(true);
            } else {
                db.execSQL("PRAGMA foreign_keys=ON");
            }
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT UNIQUE NOT NULL, %s DATETIME NOT NULL, %s DATETIME NOT NULL," +
                        "%s REAL NOT NULL, %s TEXT NOT NULL %s, %s TEXT NOT NULL %s)",
                Tablas.PEDIDO, BaseColumns._ID,
                Pedidos.ID, Pedidos.FECHA_INICIO, Pedidos.FECHA_FIN, Pedidos.COSTO,
                Pedidos.ID_CLIENTE, Referencias.ID_CLIENTE,
                Pedidos.ID_PELICULA, Referencias.ID_PELICULA));

        db.execSQL(String.format("CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT NOT NULL UNIQUE,%s TEXT NOT NULL,%s TEXT NOT NULL, %s TEXT NOT NULL," +
                        "%s TEXT NOT NULL,%s TEXT NOT NULL %s )",
                Tablas.CLIENTE, BaseColumns._ID,
                Clientes.ID, Clientes.NOMBRE, Clientes.APELLIDO, Clientes.TELEFONO,
                Clientes.USUARIO, Clientes.CONTRASEÑA));

        db.execSQL(String.format("CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT NOT NULL UNIQUE,%s TEXT NOT NULL,%s TEXT NOT NULL, %s TEXT NOT NULL," +
                        "%s TEXT NOT NULL,%s INTEGER NOT NULL,%s INTEGER NOT NULL %s )",
                Tablas.PELICULA, BaseColumns._ID,
                Peliculas.ID, Peliculas.NOMBRE, Peliculas.CATEGORIA, Peliculas.IDIOMA, Peliculas.SINOPSIS,
                Peliculas.DURACION, Peliculas.CANTIDAD, Peliculas.IMAGE));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + Tablas.PEDIDO);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.CLIENTE);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.PELICULA);

        onCreate(db);

    }
}
