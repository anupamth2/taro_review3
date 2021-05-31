package com.example.prono_doctor_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.prono_doctor_app.static_data.patient_id_for_problem_details;

public class patient_login_page extends AppCompatActivity {

    EditText ed1;
    EditText ed2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_patient_login_page );
        ed1=findViewById( R.id.ed1 );
        ed2=findViewById( R.id.ed2 );

    }
    public  void sign_up_page(View view)
    {
        Intent in=new Intent( this,patient_register_page.class );
        startActivity( in );
    }
    public void validate(View view)
    {
        String s1=ed1.getText().toString();
        String s2=ed1.getText().toString();
        if(s1.equals( "enter mobile no" )||s2.equals( "enter password" ))
        {
            Toast.makeText( getApplicationContext(),"Enter the details properly ",Toast.LENGTH_SHORT ).show();

        }
        else
        {
            my_database_class my_db=new my_database_class( this,"d f",null,1 );
            int kk1=my_db.verify_patient_login( s1,s2 );
            if(kk1==1)
            {
                //patient_id_for_problem_details=s1;
                Toast.makeText(this,"login successfully",Toast.LENGTH_SHORT ).show();
                Intent in = new Intent( getApplicationContext(),problem_details_page.class );
                in.putExtra( "patient_id",s1 );
                in.putExtra( "destination",1 );
                startActivity( in );

            }
            else
            {
                Toast.makeText( this,"login failed ",Toast.LENGTH_SHORT ).show();
            }

        }


    }

}