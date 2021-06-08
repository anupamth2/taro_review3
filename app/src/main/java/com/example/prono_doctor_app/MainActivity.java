package com.example.prono_doctor_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        //my_database_class mydb=new my_database_class( this,"dfd",null,1 );
        //mydb.read_database_doctor();
        //mydb.read_database_patient();
        //mydb.read_database_disease();
        Intent in =new Intent( this,arrange_meeting_class.class );
        in.putExtra( "destination",1 );
        startActivity( in );
        //firebase_class_next fb_next=new firebase_class_next();
        //fb_next.get_pateint_list( 43343 );






    }
}