package com.herprogramacion.moviesathome.controller;

import com.herprogramacion.moviesathome.R;

import java.util.ArrayList;

/**
 * Created by lds on 22/09/2016.
 */
public class AppController {


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



    }


    public boolean IsValidPass(String password, String confpassword) {
        Boolean resp = false;
        if (password.equals(confpassword)) {
            resp = true;
        }
        return resp;
    }
}

