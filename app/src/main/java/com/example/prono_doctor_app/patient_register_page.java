package com.example.prono_doctor_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class patient_register_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_patient_register_page );
        final EditText ed1=findViewById( R.id.editTextTextPersonName11 );
        final EditText ed2=findViewById( R.id.editTextTextPersonName12 );
        final EditText ed3=findViewById( R.id.editTextTextPersonName13 );
        final EditText ed4=findViewById( R.id.editTextTextPersonName14 );
        final EditText ed5=findViewById( R.id.editTextTextPersonName15 );
        final EditText ed6=findViewById( R.id.editTextTextPersonName16 );
        Button b7=findViewById( R.id.button7 );
        b7.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                String s1=ed1.getText().toString();
                String s2=ed2.getText().toString();
                String s3=ed3.getText().toString();
                String s4=ed4.getText().toString();
                String s5=ed5.getText().toString();
                String s6=ed6.getText().toString();

                if(s1.equals( "Name")||s2.equals("password")||s3.equals("AGE")||s4.equals("CITY")||s5.equals("state")||s6.equals("Mobile No"))
                {
                    Toast.makeText( getApplicationContext(), "FILL all details ",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    my_database_class my_db=new my_database_class( getApplicationContext()," fd ",null,1 );
                    int k=my_db.write_in_patient(s1,s2,s3,s4,s5,s6);
                    if(k==1)
                    {
                        Toast.makeText( getApplicationContext(),"succesfull registered ",Toast.LENGTH_SHORT ).show();
                        Intent in =new Intent( getApplicationContext(),patient_login_page.class );


                        startActivity( in );
                    }
                    else
                    {
                        Toast.makeText( getApplicationContext(),"Registration failed,try again",Toast.LENGTH_SHORT ).show();

                    }

                }

            }
        } );

    }


}