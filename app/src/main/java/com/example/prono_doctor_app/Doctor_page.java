package com.example.prono_doctor_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Doctor_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_doctor_page );
        Button b3=findViewById( R.id.button3 );
        Button b4=findViewById( R.id.button4 );
        EditText e1=findViewById( R.id.editTextTextPersonName );
        EditText e2=findViewById( R.id. editTextTextPersonName2);
        final  String s1=e1.getText().toString();
        final String s2=e1.getText().toString();
        b3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(s1.equals( "doctor_id" ))
                    return;
                if(s2.equals( "password" ))
                    return;
                my_database_class mydb=new my_database_class( getApplicationContext(),"jdjf",null,1 );
                int k1=mydb.verify_doctor_login( s1,s2 );
                if(k1==1)
                {
                    Intent in=new Intent( getApplicationContext(),docto_scedule_page.class );
                    in.putExtra( "doctor_id",s1 );
                    startActivity( in );
                    Toast.makeText( getApplicationContext(),"successfull login ",Toast.LENGTH_SHORT ).show();

                }
                else
                {

                    Toast.makeText( getApplicationContext(),"Login failed  ",Toast.LENGTH_SHORT ).show();
                    Intent in =new Intent( getApplicationContext(),docto_scedule_page.class );
                    in.putExtra( "doctor_id","111");
                    startActivity( in );

                }

            }
        } );
        b4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent( getApplicationContext(),doctor_register_page.class );
                startActivity( in );
            }
        } );
    }
}