package com.example.ht_512;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    Button buttonSwitch;
    View additionalButtons;
    View name;
    TextView text;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button0;
    Button buttonDot;
    Button buttonC;
    Button wallpaperButton;
    ImageView image;
    private boolean isInUsualMode;
    EditText fileNameET;
    String fileName;
    Button buttonOK;
    public static final int REQUEST_PERMISSION = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

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

                fileName = fileNameET.getText().toString();
                if (isExternalStorageWritable()) {
                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), fileName);
                    Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                    if (bitmap != null)
                    {
                        image.setImageBitmap(bitmap);}
                    else
                        Toast.makeText(MainActivity.this, "Боюсь, произошла ошибочка :(", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state);
    }



    public void init() {
        image  = findViewById(R.id.image);
        text = findViewById(R.id.text);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button0 = findViewById(R.id.button0);
        buttonDot = findViewById(R.id.buttonDot);
        buttonC = findViewById(R.id.buttonC);
        buttonSwitch = findViewById(R.id.buttonSwitch);
        additionalButtons = findViewById(R.id.additionalButtons);
        wallpaperButton = findViewById(R.id.wallpaperButton);
        name = findViewById(R.id.name);

        button1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (text.getText().toString().equals("0")) {
                    text.setText("");
                }
                text.setText(text.getText().toString() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (text.getText().toString().equals("0")) {
                    text.setText("");
                }
                text.setText(text.getText().toString() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (text.getText().toString().equals("0")) {
                    text.setText("");
                }
                text.setText(text.getText().toString() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (text.getText().toString().equals("0")) {
                    text.setText("");
                }
                text.setText(text.getText().toString() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (text.getText().toString().equals("0")) {
                    text.setText("");
                }
                text.setText(text.getText().toString() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (text.getText().toString().equals("0")) {
                    text.setText("");
                }
                text.setText(text.getText().toString() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (text.getText().toString().equals("0")) {
                    text.setText("");
                }
                text.setText(text.getText().toString() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (text.getText().toString().equals("0")) {
                    text.setText("");
                }
                text.setText(text.getText().toString() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (text.getText().toString().equals("0")) {
                    text.setText("");
                }
                text.setText(text.getText().toString() + "9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (text.getText().toString().equals("0")) {
                    text.setText("");
                }
                text.setText(text.getText().toString() + "0");
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                text.setText(text.getText().toString() + ",");
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("0");
            }
        });

        wallpaperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View layout = findViewById(R.id.wallpaperLayout);
                if (layout.getVisibility() == View.INVISIBLE) layout.setVisibility(View.VISIBLE);
                else layout.setVisibility(View.INVISIBLE);
            }
        });

    }

    public void onClick(View v) {
        if (isInUsualMode) {
            additionalButtons.setVisibility(View.VISIBLE);
            name.setVisibility(View.INVISIBLE);
            isInUsualMode = false;
        } else {
            additionalButtons.setVisibility(View.INVISIBLE);
            name.setVisibility(View.VISIBLE);
            isInUsualMode = true;
        }

    }
}
