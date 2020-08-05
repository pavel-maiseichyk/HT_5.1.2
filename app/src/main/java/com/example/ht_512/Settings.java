package com.example.ht_512;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class Settings extends AppCompatActivity {
    EditText fileNameET;
    String fileName;
    ImageView image;
    Button buttonOK;
    public static final int REQUEST_PERMISSION = 8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View inflatedView = getLayoutInflater().inflate(R.layout.activity_main, null);


        image = (ImageView) inflatedView.findViewById(R.id.image);

        setContentView(R.layout.activity_settings);

        buttonOK = findViewById(R.id.buttonOk);
        fileNameET = findViewById(R.id.fileName);

        int permissionStatus = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permissionStatus == PackageManager.PERMISSION_GRANTED)
            Toast.makeText(this, "Всё гуд, разрешение есть", Toast.LENGTH_SHORT).show();
        else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_PERMISSION);}

            buttonOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(Settings.this, "Кнопка нажалась", Toast.LENGTH_SHORT).show();
                    fileName = fileNameET.getText().toString();
                    if (isExternalStorageWritable()) {
                        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), fileName);
                        Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                        if (bitmap != null)
                        {
                            image.setImageBitmap(bitmap);}
                        else
                            Toast.makeText(Settings.this, "Bitmap пуст", Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(Settings.this, "Боюсь, произошла ошибочка :(", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Settings.this, MainActivity.class);
                    startActivity(intent);
                }
            });
        }


    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state);
    }
}