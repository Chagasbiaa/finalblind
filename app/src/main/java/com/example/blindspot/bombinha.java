package com.example.blindspot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.OutputStream;
import java.util.Objects;

public class bombinha extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    Button btnsalvarimg1, btnsalvarimg2, btnsalvarimg3, btnsalvarimg4, btnsalvarimg5;
    ImageView img1, img2, img3, img4, img5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bombinha);

        btnsalvarimg1 = findViewById(R.id.btnsalvarimg1);
        btnsalvarimg2 = findViewById(R.id.btnsalvarimg2);
        btnsalvarimg3 = findViewById(R.id.btnsalvarimg3);
        btnsalvarimg4 = findViewById(R.id.btnsalvarimg4);
        btnsalvarimg5 = findViewById(R.id.btnsalvarimg5);
        img1 = findViewById(R.id.imageView6);
        img2 = findViewById(R.id.imageView8);
        img3 = findViewById(R.id.imageView9);
        img4 = findViewById(R.id.imageView10);
        img5 = findViewById(R.id.imageView11);

        btnsalvarimg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(bombinha.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    saveImage();
                }
                else {
                    ActivityCompat.requestPermissions(bombinha.this, new String[]{
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                    }, REQUEST_CODE);
                }
            }
        });

        btnsalvarimg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(bombinha.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    saveImage2();
                }
                else {
                    ActivityCompat.requestPermissions(bombinha.this, new String[]{
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                    }, REQUEST_CODE);
                }
            }
        });

        btnsalvarimg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(bombinha.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    saveImage3();
                } else {
                    ActivityCompat.requestPermissions(bombinha.this, new String[]{
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                    }, REQUEST_CODE);
                }
            }
        });

        btnsalvarimg4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(bombinha.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    saveImage4();
                }
                else {
                    ActivityCompat.requestPermissions(bombinha.this, new String[]{
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                    }, REQUEST_CODE);
                }
            }
        });

        btnsalvarimg5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(bombinha.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
                {
                    saveImage5();
                }
                else {
                    ActivityCompat.requestPermissions(bombinha.this, new String[]{
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                    }, REQUEST_CODE);
                }
            }
        });
    }

    public void onRequestPermissionResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        if(requestCode == REQUEST_CODE){
            if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                saveImage();
            }else {
                Toast.makeText(bombinha.this, "Por favor, aceite as permissões.", Toast.LENGTH_SHORT).show();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void saveImage(){

        Uri images;
        ContentResolver contentResolver = getContentResolver();

        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            images = MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY);
        }
        else{
            images = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        }

        ContentValues contentValues = new ContentValues();
        contentValues.put(MediaStore.Images.Media.DISPLAY_NAME, System.currentTimeMillis() + ".jpg");
        contentValues.put(MediaStore.Images.Media.MIME_TYPE, "images/*");
        Uri uri = contentResolver.insert(images,contentValues);

        try{
            BitmapDrawable bitmapDrawable = (BitmapDrawable) img1.getDrawable();
            Bitmap bitmap = bitmapDrawable.getBitmap();

            OutputStream outputStream = contentResolver.openOutputStream(Objects.requireNonNull(uri));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            Objects.requireNonNull(outputStream);

            Toast.makeText(bombinha.this, "Imagem salva!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(bombinha.this, "Imagem não foi salva!", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

    }

    private void saveImage2(){
        Uri images;
        ContentResolver contentResolver = getContentResolver();

        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            images = MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY);
        }
        else{
            images = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        }

        ContentValues contentValues = new ContentValues();
        contentValues.put(MediaStore.Images.Media.DISPLAY_NAME, System.currentTimeMillis() + ".jpg");
        contentValues.put(MediaStore.Images.Media.MIME_TYPE, "images/*");
        Uri uri = contentResolver.insert(images,contentValues);

        try{
            BitmapDrawable bitmapDrawable = (BitmapDrawable) img2.getDrawable();
            Bitmap bitmap = bitmapDrawable.getBitmap();

            OutputStream outputStream = contentResolver.openOutputStream(Objects.requireNonNull(uri));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            Objects.requireNonNull(outputStream);

            Toast.makeText(bombinha.this, "Imagem salva!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(bombinha.this, "Imagem não foi salva!", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

    }

    private void saveImage3(){
        Uri images;
        ContentResolver contentResolver = getContentResolver();

        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            images = MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY);
        }
        else{
            images = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        }

        ContentValues contentValues = new ContentValues();
        contentValues.put(MediaStore.Images.Media.DISPLAY_NAME, System.currentTimeMillis() + ".jpg");
        contentValues.put(MediaStore.Images.Media.MIME_TYPE, "images/*");
        Uri uri = contentResolver.insert(images,contentValues);

        try{
            BitmapDrawable bitmapDrawable = (BitmapDrawable) img3.getDrawable();
            Bitmap bitmap = bitmapDrawable.getBitmap();

            OutputStream outputStream = contentResolver.openOutputStream(Objects.requireNonNull(uri));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            Objects.requireNonNull(outputStream);

            Toast.makeText(bombinha.this, "Imagem salva!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(bombinha.this, "Imagem não foi salva!", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

    }

    private void saveImage4(){
        Uri images;
        ContentResolver contentResolver = getContentResolver();

        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            images = MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY);
        }
        else{
            images = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        }

        ContentValues contentValues = new ContentValues();
        contentValues.put(MediaStore.Images.Media.DISPLAY_NAME, System.currentTimeMillis() + ".jpg");
        contentValues.put(MediaStore.Images.Media.MIME_TYPE, "images/*");
        Uri uri = contentResolver.insert(images,contentValues);

        try{
            BitmapDrawable bitmapDrawable = (BitmapDrawable) img4.getDrawable();
            Bitmap bitmap = bitmapDrawable.getBitmap();

            OutputStream outputStream = contentResolver.openOutputStream(Objects.requireNonNull(uri));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            Objects.requireNonNull(outputStream);

            Toast.makeText(bombinha.this, "Imagem salva!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(bombinha.this, "Imagem não foi salva!", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

    }

    private void saveImage5(){
        Uri images;
        ContentResolver contentResolver = getContentResolver();

        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            images = MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY);
        }
        else{
            images = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        }

        ContentValues contentValues = new ContentValues();
        contentValues.put(MediaStore.Images.Media.DISPLAY_NAME, System.currentTimeMillis() + ".jpg");
        contentValues.put(MediaStore.Images.Media.MIME_TYPE, "images/*");
        Uri uri = contentResolver.insert(images,contentValues);

        try{
            BitmapDrawable bitmapDrawable = (BitmapDrawable) img5.getDrawable();
            Bitmap bitmap = bitmapDrawable.getBitmap();

            OutputStream outputStream = contentResolver.openOutputStream(Objects.requireNonNull(uri));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            Objects.requireNonNull(outputStream);

            Toast.makeText(bombinha.this, "Imagem salva!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(bombinha.this, "Imagem não foi salva!", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

    }
}
