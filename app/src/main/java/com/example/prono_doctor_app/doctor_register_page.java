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
                //EditText ed=findViewById( R.id.editTextTextPersonName10 )
                EditText id=findViewById( R.id.editTextTextPersonName3 );
                EditText pass=findViewById(R.id. editTextTextPersonName4 );
                EditText cit=findViewById(R.id. editTextTextPersonName5 );
                EditText yox=findViewById(R.id. editTextTextPersonName6 );
                EditText add=findViewById(R.id. editTextTextPersonName7 );
                EditText mob=findViewById(R.id. editTextTextPersonName8 );
                EditText spe=findViewById(R.id. editTextTextPersonName9 );
                EditText name=findViewById( R.id.editTextTextPersonName10 );

                String id1=id.getText().toString();
                String pass1=pass.getText().toString();
                String city=cit.getText().toString();
                String yox1=yox.getText().toString();
                String add1=add.getText().toString();
                String mob1=mob.getText().toString();
                String spe1=spe.getText().toString();
                String name1=name.getText().toString();
                if(id1.equals("DOCTOR_ID"))
                {
                    Toast.makeText( getApplicationContext(),"please enter the doctor id",Toast.LENGTH_SHORT ).show();
                    return;
                }
                if(pass1.equals("PASSWORD"))
                {
                    Toast.makeText( getApplicationContext(),"please enter the PASSWORD",Toast.LENGTH_SHORT ).show();
                    return;
                }
                if(city.equals("CITY"))
                {
                    Toast.makeText( getApplicationContext(),"please enter the CITY",Toast.LENGTH_SHORT ).show();
                    return;
                }
                if(yox1.equals("YEAR_OF_EXPERIENCE"))
                {
                    Toast.makeText( getApplicationContext(),"please enter the YEAR OF EXPERIENCE",Toast.LENGTH_SHORT ).show();
                    return;
                }
                if(add1.equals("ADDRESS"))
                {
                    Toast.makeText( getApplicationContext(),"please enter the ADDRESS",Toast.LENGTH_SHORT ).show();
                    return;
                }
                if(mob1.equals( "MOBILE NO"))
                {
                    Toast.makeText( getApplicationContext(),"please enter the MOBILE NO",Toast.LENGTH_SHORT ).show();
                    return;
                }
                if(spe1.equals("SPECIALITY"))
                {
                    Toast.makeText( getApplicationContext(),"please enter the SPECIALITY",Toast.LENGTH_SHORT ).show();
                    return;
                }
                Random rd=new Random(  );
                int k11=rd.nextInt();
                my_database_class my_database_class=new my_database_class( getApplicationContext(),"df",null,1 );
                int k1=my_database_class.write_in_doctor_table( id1,name1,pass1,city,spe1,yox1,add1,mob1,Integer.toString( k11 ),Integer.toString( k11+5 ) );

                //my_database_class.read_database_doctor();

                if(k1==1)
                { Log.d("doctor_register_page","successfull");
                Toast.makeText( getApplicationContext(),"Registered succesfully \n make note of id "+id1,Toast.LENGTH_LONG ).show();
                    Intent in=new Intent( getApplicationContext(),Doctor_page.class );
                    startActivity( in );

                }

                else {
                    Log.d( "doctor_register_page", "failed" );
                  Toast.makeText( getApplicationContext(),"Registation failed try again ",Toast.LENGTH_SHORT ).show();
                }



                //Log.d("doctor_register_page",s1+" "+s2+" "+s3+" "+s4+" "+s5+" "+s6+" "+s7);
            }
        } );
    }
}