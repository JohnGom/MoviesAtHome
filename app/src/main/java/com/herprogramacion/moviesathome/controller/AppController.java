package com.herprogramacion.moviesathome.controller;

import com.herprogramacion.moviesathome.R;
import com.herprogramacion.moviesathome.datos.Pelicula;
import com.herprogramacion.moviesathome.sqlite.BaseDatosPelicula;
import com.herprogramacion.moviesathome.sqlite.Operaciones;

import java.util.ArrayList;

/**
 * Created by lds on 22/09/2016.
 */
public class AppController {


    Operaciones peli;
    private static AppController _instance;



    private String[] peliList;


    public static AppController getInstance()
    {
        if (_instance == null)
        {
            _instance = new AppController();
        }
        return _instance;
    }





    private AppController(){
        this.fillCountryList();
    }

    private void fillCountryList() {
            peli.insertarPelicula(new Pelicula(null, "CivilWar", "Accion", "Latino", "historietas de marvel","2:20",34,R.drawable.civilwar));
            peli.insertarPelicula(new Pelicula(null, "Skiptrace", "Accion", "Español", "esta jackie chan","1:34",34,R.drawable.skiptrace));
        
//https://www.youtube.com/watch?v=NLmw18mkwIc

    }


    public boolean IsValidPass(String password, String confpassword) {
        Boolean resp = false;
        if (password.equals(confpassword)) {
            resp = true;
        }
        return resp;
    }
}

