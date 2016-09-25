package com.herprogramacion.moviesathome.sqlite;

import java.util.UUID;

/**
 * Created by lds on 22/09/2016.
 */
public class ContratoPelicula {

    interface ColumnasCliente {

        String ID = "id";
        String NOMBRE = "nombre";
        String APELLIDO = "apellido";
        String TELEFONO = "telefono";
        String USUARIO = "usuario";
        String CONTRASEÑA = "contraseña";
    }

    interface ColumnasPelicula {

        String ID = "id";
        String NOMBRE = "nombre";
        String CATEGORIA = "categoria";
        String IDIOMA = "idioma";
        String SINOPSIS = "sinopsis";
        String DURACION = "duracion";
        String CANTIDAD = "cantidad";
        String IMAGE = "image";
    }

    interface ColumnasPedido {

        String ID = "id";
        String FECHA_INICIO = "fecha_incio";
        String FECHA_FIN = "fecha_fin";
        String COSTO = "costo";
        String ID_CLIENTE = "id_cliente";
        String ID_PELICULA = "id_pelicula";

    }

    public static class Clientes implements ColumnasCliente {
        public static String generarIdCliente() {
            return "CLI-" + UUID.randomUUID().toString();
        }
    }

        public static class Peliculas implements ColumnasPelicula {
            public static String generarIdPelicula() {
                return "PEL-" + UUID.randomUUID().toString();
            }
        }

        public static class Pedidos implements ColumnasPedido {
            public static String generarIdPedido() {
                return "PED-" + UUID.randomUUID().toString();
            }
        }
    }
