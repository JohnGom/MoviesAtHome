package com.herprogramacion.moviesathome.datos;

/**
 * Created by lds on 22/09/2016.
 */
public class Pedido{

    private String idPedido;
    private String fechaIncio;
    private String fechaFin;
    private float costo;
    private String idCliente;
    private String idPelicula;


    public Pedido (String idPedido, String fechaIncio, String fechaFin, float costo, String idCliente, String idPelicula ){

        this.setIdPedido(idPedido);
        this.setFechaIncio(fechaIncio);
        this.setFechaFin(fechaFin);
        this.setCosto(costo);
        this.setIdCliente(idCliente);
        this.setIdPelicula(idPelicula);

    }

    public String getIdPedido() {return idPedido;}

    public void setIdPedido(String idPedido) {this.idPedido = idPedido;}

    public String getFechaIncio() {return fechaIncio;}

    public void setFechaIncio(String fechaIncio) {this.fechaIncio = fechaIncio;}

    public String getFechaFin() {return fechaFin;}

    public void setFechaFin(String fechaFin) {this.fechaFin = fechaFin;}

    public float getCosto() {return costo;}

    public void setCosto(float costo) {this.costo = costo;}

    public String getIdCliente() {return idCliente;}

    public void setIdCliente(String idCliente) {this.idCliente = idCliente;}

    public String getIdPelicula() {return idPelicula;}

    public void setIdPelicula(String idPelicula) {this.idPelicula = idPelicula;}

}
