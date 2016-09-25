package com.herprogramacion.moviesathome.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.herprogramacion.moviesathome.R;
import com.herprogramacion.moviesathome.sqlite.Operaciones;

public class SingIn extends AppCompatActivity {

    EditText userName;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);


        userName=(android.widget.EditText) this.findViewById(R.id.editUsername);
        password=(android.widget.EditText) this.findViewById(R.id.editPassword);
    }

    public void login(View view) {

        if( Operaciones.obtenerInstancia(getApplicationContext()).validCliente(userName.getText().toString(),password.getText().toString())) {
            Intent intent = new Intent(this, ListaPeliculaActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "El usuario y contraseña no coinciden", Toast.LENGTH_SHORT).show();
            userName.setText("");
            password.setText("");
        }
    }
}



