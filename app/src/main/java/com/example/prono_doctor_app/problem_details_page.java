package com.example.prono_doctor_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class problem_details_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_problem_details_page );
        Button b8=findViewById( R.id.button8 );
        b8.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                problem_details_2 pb2=new problem_details_2();
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace( R.id.my_fragment,pb2 );
                ft.commit();



            }
        } );
        Button b10=findViewById( R.id.button10 );
        b10.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                problem_details_4 pb4=new problem_details_4();
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace( R.id.my_fragment,pb4 );
                ft.commit();
            }
        } );
    }
}