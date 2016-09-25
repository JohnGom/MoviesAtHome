package com.herprogramacion.moviesathome.datos;

/**
 * Created by lds on 22/09/2016.
 */
public class Cliente {



    private String idCliente;
    private String nombre;
    private String apellido;
    private String telefono;
    private String usuario;
    private String contraseña;



    public Cliente(String idCliente, String nombre, String apellido, String telefono, String usuario, String contraseña){
        this.setIdCliente(idCliente);
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setTelefono(telefono);
        this.setUsuario(usuario);
        this.setContraseña(contraseña);
    }

    public String getIdCliente() {return idCliente;}

    public void setIdCliente(String idCliente) {this.idCliente = idCliente;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApellido() {return apellido;}

    public void setApellido(String apellido) {this.apellido = apellido;}

    public String getUsuario() {return usuario;}

    public void setUsuario(String usuario) {this.usuario = usuario;}

    public String getContraseña() {return contraseña;}

    public void setContraseña(String contraseña) {this.contraseña = contraseña;}

    public String getTelefono() {return telefono;}

    public void setTelefono(String telefono) {this.telefono = telefono;}}


