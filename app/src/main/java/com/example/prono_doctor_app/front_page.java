package com.example.prono_doctor_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class front_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_front_page );
        Button b=findViewById( R.id.button );
        Button b2=findViewById( R.id.button2 );
        b.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in =new Intent( getApplicationContext(),Doctor_page.class );
                startActivity( in );
            }
        } );
        b2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in =new Intent( getApplicationContext(),patient_login_page.class );
                startActivity( in );
            }
        } );
    }
}