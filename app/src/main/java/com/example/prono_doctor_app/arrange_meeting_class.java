package com.example.prono_doctor_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class arrange_meeting_class extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_arrange_meeting_class );
        my_database_class my_database_class1=new my_database_class( this,"fdf",null,1 );
       // my_database_class1.read_database_doctor();
        //my_database_class1.read_database_patient();
        //my_database_class1.read_database_disease();
        //my_database_class1.read_schedule_table();
        ArrayList<String> s1=new ArrayList<>(  );
        s1=my_database_class1.get_all_patient_id();
    }
}