package com.herprogramacion.moviesathome.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.herprogramacion.moviesathome.datos.Pelicula;
import com.herprogramacion.moviesathome.sqlite.BaseDatosPelicula.Tablas;
import com.herprogramacion.moviesathome.datos.Pedido;
import com.herprogramacion.moviesathome.datos.Cliente;
import com.herprogramacion.moviesathome.sqlite.ContratoPelicula.Clientes;
import com.herprogramacion.moviesathome.sqlite.ContratoPelicula.Peliculas;
import com.herprogramacion.moviesathome.sqlite.ContratoPelicula.Pedidos;

public class Operaciones {
    private static BaseDatosPelicula baseDatos;

    private static Operaciones instancia = new Operaciones();


    public static Operaciones obtenerInstancia(Context contexto) {
        if (baseDatos == null) {
            baseDatos = new BaseDatosPelicula(contexto);
        }
        return instancia;
    }

    public String insertarPedido(Pedido pedido) {
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        // Generar Pk
        String idPedido = Pedidos.generarIdPedido();

        ContentValues valores = new ContentValues();
        valores.put(Pedidos.ID, idPedido);
        valores.put(Pedidos.FECHA_INICIO, pedido.getFechaIncio());
        valores.put(Pedidos.FECHA_FIN, pedido.getFechaFin());
        valores.put(Pedidos.COSTO, pedido.getCosto());
        valores.put(Pedidos.ID_CLIENTE, pedido.getIdCliente());
        valores.put(Pedidos.ID_PELICULA, pedido.getIdPelicula());

        // Insertar cabecera
        db.insertOrThrow(Tablas.PEDIDO, null, valores);

        return idPedido;
    }

    public String insertarProducto(Pelicula pelicula) {
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        ContentValues valores = new ContentValues();
        // Generar Pk
        String idPelicula = Peliculas.generarIdPelicula();
        valores.put(Peliculas.ID, idPelicula);
        valores.put(Peliculas.NOMBRE, pelicula.getNombre());
        valores.put(Peliculas.CATEGORIA, pelicula.getCategoria());
        valores.put(Peliculas.IDIOMA, pelicula.getIdioma());
        valores.put(Peliculas.SINOPSIS, pelicula.getSinopsis());
        valores.put(Peliculas.DURACION, pelicula.getDuracion());
        valores.put(Peliculas.CANTIDAD, pelicula.getCantidad());
        valores.put(Peliculas.IMAGE, pelicula.getImage());

        db.insertOrThrow(Tablas.PEDIDO, null, valores);
        return idPelicula;
    }

    public void insertarCliente (Cliente cliente) {
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        // Generar Pk
        String idCliente = Clientes.generarIdCliente();

        ContentValues valores = new ContentValues();
        valores.put(Clientes.ID, cliente.getIdCliente());
        valores.put(Clientes.NOMBRE, cliente.getNombre());
        valores.put(Clientes.APELLIDO, cliente.getApellido());
        valores.put(Clientes.TELEFONO, cliente.getTelefono());
        valores.put(Clientes.USUARIO, cliente.getUsuario());
        valores.put(Clientes.CONTRASEÑA, cliente.getContraseña());

        db.insert(Tablas.CLIENTE, null, valores);
        db.close();
    }

    public boolean validCliente (String user, String pass) {
        boolean res= false;

        SQLiteDatabase db = baseDatos.getWritableDatabase();

        Cursor fila =db.rawQuery("SELECT " +Clientes.USUARIO+","+Clientes.CONTRASEÑA+" FROM "+Tablas.CLIENTE+" where "+Clientes.USUARIO+"=  "+user+"",null);

        if (fila.moveToFirst()) {
            if(fila.getString(0).equals(user) && fila.getString(1).equals(pass)){
                res=true;
            }else{
                res=false;
            }
        } else {
            res=false;
        }
        db.close();
        return res;
    }

}
