package com.example.a18bit0003_spash_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
     //int SPLASH_SCREEN_OUT=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
         new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {
                Intent in = new Intent( MainActivity.this, MainActivity2.class );
                startActivity( in );
                finish();


            }
        }, 10000 );


    }
}