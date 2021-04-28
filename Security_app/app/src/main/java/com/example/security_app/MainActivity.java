package com.example.security_app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.io.FileOutputStream;
import android.io.FileInputStream;
import android.io.File;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private Button writeText,readText;
    private EditText enterText;
    private TextView showText;
    private String file ="myfile";
    private String fileContents;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        writeText=findViewById(R.id.withText);
        readText= findViewById(R.id.readText);
        enterText=findViewById(R.id.enterText);
        showText=findViewById(R.id.showText);

    }
}