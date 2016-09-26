package com.herprogramacion.moviesathome.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
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


    public BaseDatosPelicula(Context contexto) {
        super(contexto, NOMBRE_BASE_DATOS, null, VERSION_ACTUAL);
        this.contexto = contexto;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+Tablas.CLIENTE+" ( "+Clientes.ID+" TEXT primary key," +
                        Clientes.NOMBRE+" TEXT NOT NULL,"+Clientes.APELLIDO+" TEXT NOT NULL,"+Clientes.TELEFONO+" TEXT NOT NULL," +
                        Clientes.USUARIO+" TEXT NOT NULL,"+Clientes.CONTRASEÑA+"TEXT NOT NULL)");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + Tablas.PEDIDO);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.CLIENTE);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.PELICULA);

        onCreate(db);

    }
    public Cursor getPelis (){
        String colmnas [] = {Peliculas.ID, Peliculas.NOMBRE, Peliculas.CATEGORIA, Peliculas.IDIOMA, Peliculas.SINOPSIS,
                Peliculas.DURACION, Peliculas.CANTIDAD, Peliculas.IMAGE};

        Cursor c = this.getReadableDatabase().query(Tablas.PELICULA, colmnas, null,null,null,null,null);
        return c;
    }

}
