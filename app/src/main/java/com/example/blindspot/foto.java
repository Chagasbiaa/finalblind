package com.example.blindspot;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class foto extends AppCompatActivity {

    Button menu;
    Button personas;
    Button casos;
    Button perfil;
    Button foto;
    Button enviar;
    private ImageView mImgPhoto;
    private Uri mSelectedUri;
    private Object IOExeption;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);

        mImgPhoto = findViewById(R.id.imagefoto);

        personas = findViewById(R.id.btnpersonaa);
        personas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(foto.this, personas.class);
                startActivity(intent);
            }
        });

        enviar = findViewById(R.id.btnenviar);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(foto.this, enviado.class);
                startActivity(intent);
            }
        });

        casos = findViewById(R.id.btncasoso);
        casos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(foto.this, aventura.class);
                startActivity(intent);
            }
        });

        perfil = findViewById(R.id.btnperfill);
        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(foto.this, perfil.class);
                startActivity(intent);
            }
        });

        menu = findViewById(R.id.btnhomeer);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(foto.this, Menu.class);
                startActivity(intent);
            }
        });

        foto = findViewById(R.id.btnselected_photo);
        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectPhoto();


            }
        });
        }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0) {
            mSelectedUri = data.getData();

            Bitmap bitmap = null;
            try {
            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), mSelectedUri);
            mImgPhoto.setImageDrawable (new BitmapDrawable(bitmap));
            foto.setAlpha(0);

        } catch (IOException e){

            }

        }
    }
    private void selectPhoto() {
                Intent intent = new Intent (Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 0);
    }

}

