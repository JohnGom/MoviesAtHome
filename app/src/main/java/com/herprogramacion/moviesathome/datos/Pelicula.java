package com.herprogramacion.moviesathome.datos;

/**
 * Created by lds on 22/09/2016.
 */
public class Pelicula {


    private String idPelicula;
    private String nombre;
    private String categoria;
    private String idioma;
    private String sinopsis;
    private String duracion;
    private int cantidad;
    private int image;

    public Pelicula (String idPelicula, String nombre, String categoria, String idioma, String sinopsis,
                     String duracion, int cantidad, int image){
        this.setIdPelicula(idPelicula);
        this.setNombre(nombre);
        this.setCategoria(categoria);
        this.setIdioma(idioma);
        this.setSinopsis(sinopsis);
        this.setDuracion(duracion);
        this.setCantidad(cantidad);
        this.setImage(image);

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getIdPelicula() {return idPelicula;}

    public void setIdPelicula(String idPelicula) {this.idPelicula = idPelicula;}

    public String getSinopsis() {return sinopsis;}

    public void setSinopsis(String sinopsis) {this.sinopsis = sinopsis;}

    public String getDuracion() {return duracion;}

    public void setDuracion(String duracion) {this.duracion = duracion;}

    public int getCantidad() {return cantidad;}

    public void setCantidad(int cantidad) {this.cantidad = cantidad;}

}

