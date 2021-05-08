package com.example.prono_doctor_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Random;

public class docto_scedule_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_docto_scedule_page );
        Button b8=findViewById( R.id.button8 );
        Intent in=getIntent();
        String doctor_id=in.getStringExtra( "doctor_id" );


        final RadioGroup radioGroup=findViewById( R.id.radioGroup );
        final EditText edit1=findViewById( R.id.editTextTextPersonName17 );
        final String s1=edit1.getText().toString();
        final EditText edit2=findViewById( R.id.editTextTextPersonName18 );
        final String s2=edit2.getText().toString();
        final EditText edit3=findViewById( R.id.editTextTextPersonName19 );
        final String s3=edit3.getText().toString();
        Random random=new Random(  );
        Button b10=findViewById( R.id.button10 );

        final int id=random.nextInt(10000);
         int doc_id=0;
        try{
            doc_id=Integer.parseInt( doctor_id );
        }
        catch (Exception e)
        {

            doc_id=0;

        }
        final int doc_id_1=doc_id;
        b8.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int select_id=radioGroup.getCheckedRadioButtonId();
                int day=1;
                if(select_id==R.id.radioButton1)
                    day=1;
                if(select_id==R.id.radioButton2)
                    day=2;
                if(select_id==R.id.radioButton3)
                    day=3;
                if(select_id==R.id.radioButton4)
                    day=4;
                if(select_id==R.id.radioButton5)
                    day=5;
                if(select_id==R.id.radioButton6)
                    day=6;
                if(select_id==R.id.radioButton7)
                    day=7;
                String days=Integer.toString( day );
                days+="-";
                days+=s3;

                my_database_class mydb=new my_database_class( getApplicationContext(),"dad",null,1 );
                int kkt=mydb.write_in_schedule_table( id,days,s1,s2,doc_id_1,s3 );
                if(kkt==1)
                    Toast.makeText( getApplicationContext(),"succesfull write to schedule ",Toast.LENGTH_SHORT ).show();
                else
                    Toast.makeText( getApplicationContext(),"failed to write in schedule" ,Toast.LENGTH_SHORT).show();



            }
        } );
        b10.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int select_id=radioGroup.getCheckedRadioButtonId();
                int day=1;
                if(select_id==R.id.radioButton1)
                    day=1;
                if(select_id==R.id.radioButton2)
                    day=2;
                if(select_id==R.id.radioButton3)
                    day=3;
                if(select_id==R.id.radioButton4)
                    day=4;
                if(select_id==R.id.radioButton5)
                    day=5;
                if(select_id==R.id.radioButton6)
                    day=6;
                if(select_id==R.id.radioButton7)
                    day=7;
                String days=Integer.toString( day );
                days+="-";
                days+=s3;
                my_database_class mydb=new my_database_class( getApplicationContext(),"dad",null,1 );
                int kkt=mydb.write_in_schedule_table( id,days,s1,s2,doc_id_1,s3 );
                if(kkt==1)
                    Toast.makeText( getApplicationContext(),"succesfull write to schedule ",Toast.LENGTH_SHORT ).show();
                else
                    Toast.makeText( getApplicationContext(),"failed to write in schedule" ,Toast.LENGTH_SHORT).show();


            }
        } );

    }
}