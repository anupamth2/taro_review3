package com.example.prono_doctor_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class doctor_register_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_doctor_register_page );
        my_database_class mydb_=new my_database_class( this,"dfd",null,1 );
        mydb_.read_database_doctor();
        Button b1=findViewById( R.id.button5 );
        b1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText ed1=findViewById( R.id.editTextTextPersonName3 );
                EditText ed2=findViewById(R.id. editTextTextPersonName4 );
                EditText ed3=findViewById(R.id. editTextTextPersonName5 );
                EditText ed4=findViewById(R.id. editTextTextPersonName6 );
                EditText ed5=findViewById(R.id. editTextTextPersonName7 );
                EditText ed6=findViewById(R.id. editTextTextPersonName8 );
                EditText ed7=findViewById(R.id. editTextTextPersonName9 );
                EditText ed8=findViewById( R.id.editTextTextPersonName10 );

                String s1=ed1.getText().toString();
                String s2=ed2.getText().toString();
                String s3=ed3.getText().toString();
                String s4=ed4.getText().toString();
                String s5=ed5.getText().toString();
                String s6=ed6.getText().toString();
                String s7=ed7.getText().toString();
                String s8=ed8.getText().toString();
                if(s1.equals("DOCTOR_ID"))
                {
                    Toast.makeText( getApplicationContext(),"please enter the doctor id",Toast.LENGTH_SHORT ).show();
                    return;
                }
                if(s2.equals("PASSWORD"))
                {
                    Toast.makeText( getApplicationContext(),"please enter the PASSWORD",Toast.LENGTH_SHORT ).show();
                    return;
                }
                if(s3.equals("CITY"))
                {
                    Toast.makeText( getApplicationContext(),"please enter the CITY",Toast.LENGTH_SHORT ).show();
                    return;
                }
                if(s4.equals("YEAR_OF_EXPERIENCE"))
                {
                    Toast.makeText( getApplicationContext(),"please enter the YEAR OF EXPERIENCE",Toast.LENGTH_SHORT ).show();
                    return;
                }
                if(s5.equals("ADDRESS"))
                {
                    Toast.makeText( getApplicationContext(),"please enter the ADDRESS",Toast.LENGTH_SHORT ).show();
                    return;
                }
                if(s6.equals( "MOBILE NO"))
                {
                    Toast.makeText( getApplicationContext(),"please enter the MOBILE NO",Toast.LENGTH_SHORT ).show();
                    return;
                }
                if(s7.equals("SPECIALITY"))
                {
                    Toast.makeText( getApplicationContext(),"please enter the SPECIALITY",Toast.LENGTH_SHORT ).show();
                    return;
                }
                Random rd=new Random(  );
                int k11=rd.nextInt();
                my_database_class my_database_class=new my_database_class( getApplicationContext(),"df",null,1 );
                int k1=my_database_class.write_in_doctor_table( s1,s8,s2,s3,s4,s5,s6,s7,Integer.toString( k11 ),Integer.toString( k11+5 ) );

                //my_database_class.read_database_doctor();

                if(k1==1)
                { Log.d("doctor_register_page","successfull");
                Toast.makeText( getApplicationContext(),"Registered succesfully \n make note of id "+s1,Toast.LENGTH_LONG ).show();
                    Intent in=new Intent( getApplicationContext(),Doctor_page.class );
                    startActivity( in );

                }

                else {
                    Log.d( "doctor_register_page", "failed" );
                  Toast.makeText( getApplicationContext(),"Registation failed try again ",Toast.LENGTH_SHORT ).show();
                }



                Log.d("doctor_register_page",s1+" "+s2+" "+s3+" "+s4+" "+s5+" "+s6+" "+s7);
            }
        } );
    }
}