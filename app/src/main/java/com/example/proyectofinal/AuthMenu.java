package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AuthMenu extends AppCompatActivity {
    Button register,login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_menu);

        register = findViewById(R.id.aam_btn_registrarse);
        login = findViewById(R.id.aam_btn_iniciarSesion);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RegisterMenu.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),LoginMenu.class));
            }
        });



    }
}