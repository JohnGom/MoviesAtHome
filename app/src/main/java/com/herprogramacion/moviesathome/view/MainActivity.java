package com.herprogramacion.moviesathome.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.herprogramacion.moviesathome.R;

public class MainActivity extends AppCompatActivity {
    Button signin;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        signup = (Button) findViewById(R.id.btnsignup);
        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent signup = new Intent(MainActivity.this, SignUp.class);
                startActivity(signup);

            }
        });

        signin = (Button) findViewById(R.id.btnsignin);
        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent signin = new Intent(MainActivity.this, SingIn.class);
                startActivity(signin);
            }
        });
    }
}
