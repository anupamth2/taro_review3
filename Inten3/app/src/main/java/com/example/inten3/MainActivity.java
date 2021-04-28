package com.example.inten3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Scene;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        try{
            Intent intent1=getIntent();
            int k111=intent1.getIntExtra( "sum1",-35 );
            Toast.makeText( this,"we ger the value "+k111, LENGTH_LONG ).show();

        }
        catch (Exception e)
        {
            Toast.makeText( this,"this is king hustle", LENGTH_LONG ).show();

        }

    }
    public  void function(View view)
    {
        Toast.makeText( this,"we are executig ", LENGTH_LONG  ).show();
        try {
            Intent intent = new Intent(this,Dis.class );
            intent.putExtra( "fno1",12 );
            intent.putExtra( "fno2",14 );
            startActivity( intent);
        }
        catch (Exception e)
        {

            Toast.makeText( this,"there is an error ", LENGTH_LONG ).show();
        }
        Intent rn=getIntent();
        int k1=rn.getIntExtra( "sum",1 );
        Toast.makeText( this,"the value of k1 "+k1, LENGTH_LONG ).show();


    }






}