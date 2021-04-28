package com.example.sql1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2;
    EditText name,age;
    Switch sw;
    ListView l1;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        btn1=findViewById( R.id.b1 );
        btn2=findViewById( R.id.b2 );
        name=findViewById( R.id.name );
        age=findViewById( R.id.name2 );
        sw=findViewById( R.id.switch1 );
        l1=findViewById( R.id.customerlist );

        btn1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int k1=Integer.parseInt(  age.getText().toString());
                sql1 sql =new sql1(name.getText().toString(),k1,sw.isChecked(),-1 );
                //Toast.makeText( getApplicationContext(),sql.toString(), Toast.LENGTH_SHORT ).show();


                mysql mysql1 =  new mysql( MainActivity.this);
                final boolean b = mysql1.addone11( sql );
                if(b)
                {
                    Toast.makeText( MainActivity.this,"success",Toast.LENGTH_LONG ).show();
                }
                else
                {
                    Toast.makeText( MainActivity.this,"unsuccessfull",Toast.LENGTH_LONG).show();
                }

            }
        } );
        btn2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText( getApplicationContext(),"button2 is cic",Toast.LENGTH_LONG).show();

            }
        } );




    }
}