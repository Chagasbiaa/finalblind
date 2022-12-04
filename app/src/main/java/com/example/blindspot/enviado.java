package com.example.blindspot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class enviado extends AppCompatActivity {
    Button menu;
    Button personas;
    Button casos;
    Button perfil;
    Button foto;
    Button voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviado);
        personas = findViewById(R.id.btnpersonaal);
        personas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(enviado.this, personas.class);
                startActivity(intent);
            }
        });

        casos = findViewById(R.id.btncasosol);
        casos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(enviado.this, aventura.class);
                startActivity(intent);
            }
        });

        voltar = findViewById(R.id.btnvoltar);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(enviado.this, opcoes.class);
                startActivity(intent);
            }
        });

        perfil = findViewById(R.id.btnperfilll);
        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(enviado.this, perfil.class);
                startActivity(intent);
            }
        });

        menu = findViewById(R.id.btnhomeerl);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(enviado.this, Menu.class);
                startActivity(intent);
            }
        });
    }
}