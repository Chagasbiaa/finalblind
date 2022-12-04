package com.example.blindspot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class opcoes extends AppCompatActivity {

    Button menu;
    Button personas;
    Button casos;
    Button perfil;
    Button sensor;
    Button local;
    Button foto;
    Button perns;
    Button perns2;
    Switch switcher;
    boolean ModoDark;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcoes);

        switcher = findViewById(R.id.switchExibe);

        sharedPreferences = getSharedPreferences("MODE", Context.MODE_PRIVATE );
        ModoDark = sharedPreferences.getBoolean("night", true);

        if(ModoDark){
            switcher.setChecked(true);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        }

        switcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ModoDark) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("night", false);



                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("night", true);

                }
                editor.apply();
            }
        });

        personas = findViewById(R.id.btnpersona12);
        personas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(opcoes.this, personas.class);
                startActivity(intent);
            }
        });

        casos = findViewById(R.id.btncasos12);
        casos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(opcoes.this, aventura.class);
                startActivity(intent);
            }
        });

        perfil = findViewById(R.id.btnperfil12);
        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(opcoes.this, perfil.class);
                startActivity(intent);
            }
        });

        menu = findViewById(R.id.btnhomee12);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(opcoes.this, Menu.class);
                startActivity(intent);
            }
        });

        sensor = findViewById(R.id.btnsens);
        sensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(opcoes.this, sensor_laterna.class);
                startActivity(intent);
            }
        });

        local = findViewById(R.id.btnlocal);
        local.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(opcoes.this, localizacao.class);
                startActivity(intent);
            }
        });

        foto = findViewById(R.id.btnfoto);
        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(opcoes.this, foto.class);
                startActivity(intent);
            }
        });

        perns = findViewById(R.id.btnpersn);
        perns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(opcoes.this, amem.class);
                startActivity(intent);
            }
        });

        perns2 = findViewById(R.id.btnpersn2);
        perns2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(opcoes.this, bombinha.class);
                startActivity(intent);
            }
        });
    }

}