package com.example.blindspot;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.BreakIterator;

public class amem extends AppCompatActivity implements View.OnClickListener {

    // declare the variables
    Button read, write;
    EditText userInput;
    TextView fileContent;
    Button menu;
    Button personas;
    Button casos;
    Button perfil;

    private String filename = "demoFile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amem);
        personas = findViewById(R.id.btnpersona12);
        personas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(amem.this, personas.class);
                startActivity(intent);
            }
        });

        casos = findViewById(R.id.btncasos12);
        casos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(amem.this, aventura.class);
                startActivity(intent);
            }
        });

        perfil = findViewById(R.id.btnperfil12);
        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(amem.this, perfil.class);
                startActivity(intent);
            }
        });

        menu = findViewById(R.id.btnhomee12);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(amem.this, Menu.class);
                startActivity(intent);
            }
        });

        read = findViewById(R.id.read_button);
        write = findViewById(R.id.write_button);
        userInput = findViewById(R.id.userInput);
        fileContent = findViewById(R.id.content);

        read.setOnClickListener(this);
        write.setOnClickListener(this);
    }

    public void printMessage(String m) {
        Toast.makeText(this, m, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        Button b = (Button) view;

        String b_text = b.getText().toString();

        switch (b_text.toLowerCase()) {
            case "write": {
                writeData();
                break;
            }
            case "read": {
                readData();
                break;
            }
        }
    }

    private void writeData() {

        try {
            FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE);
            String data = userInput.getText().toString();
            fos.write(data.getBytes());
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        userInput.setText("");
    }


    private void readData() {
        try {
            FileInputStream fin = openFileInput(filename);
            int a;
            StringBuilder temp = new StringBuilder();
            while ((a = fin.read()) != -1) {
                temp.append((char) a);
            }

            // setting text from the file.
            fileContent.setText(temp.toString());
            fin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
