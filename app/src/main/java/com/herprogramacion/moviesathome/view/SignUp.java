package com.herprogramacion.moviesathome.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.herprogramacion.moviesathome.R;
import com.herprogramacion.moviesathome.controller.AppController;
import com.herprogramacion.moviesathome.datos.Cliente;
import com.herprogramacion.moviesathome.sqlite.Operaciones;

public class SignUp extends AppCompatActivity {

    EditText nombre;
    EditText apellido;
    EditText userName;
    EditText password;
    EditText telefono;
    EditText confirmP;

    Operaciones datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        nombre = (android.widget.EditText) this.findViewById(R.id.nombre);
        apellido = (android.widget.EditText) this.findViewById(R.id.apellido);
        telefono = (android.widget.EditText) this.findViewById(R.id.telefono);
        userName = (android.widget.EditText) this.findViewById(R.id.usuario);
        password = (android.widget.EditText) this.findViewById(R.id.password);
        confirmP = (android.widget.EditText) this.findViewById(R.id.confirPass);
    }

    public void registrar (View v){

        if(AppController.getInstance().IsValidPass(password.getText().toString(),confirmP.getText().toString())) {

            datos.insertarCliente(new Cliente(null, nombre.getText().toString(), apellido.getText().toString(),
                    telefono.getText().toString(), userName.getText().toString(), password.getText().toString()));
            nombre.setText("");
            apellido.setText("");
            userName.setText("");
            password.setText("");
            telefono.setText("");
            confirmP.setText("");

            Toast.makeText(this, "Registrado", Toast.LENGTH_SHORT).show();


        }else{
            password.setText("");
            confirmP.setText("");
            Toast.makeText(this, "Las contraseñas no son iguales", Toast.LENGTH_SHORT).show();
        }

    }


}

