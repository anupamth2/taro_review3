package com.example.inten3;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Scene;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Dis extends AppCompatActivity {
    int k1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.new_layout );


        //Toast.makeText( this,"welcome to india ",Toast.LENGTH_LONG ).show();
        Intent rin = getIntent();
        int a = rin.getIntExtra( "fno1", 1 );
        int b = rin.getIntExtra( "fno2", 2 );
        int z = a * b;
        k1=z;
        rin.putExtra( "sum", z );
        Toast.makeText( this, "the sum is " + z, Toast.LENGTH_LONG ).show();
        // setResult(101,rin);
    }
        public void function11(View view)
        {


            try {


                Intent intent2 = new Intent( this, MainActivity.class );
                intent2.putExtra( "sum1", k1 );
                startActivity( intent2 );

            }
            catch (Exception e)
            {
                Toast.makeText( this,"we cannot call ",Toast.LENGTH_LONG ).show();

            }

        }




}